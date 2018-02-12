package jp.blackawa.example.undertow.reverse.proxy;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.undertow.client.ClientCallback;
import io.undertow.client.ClientConnection;
import io.undertow.client.UndertowClient;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.ServerConnection;
import io.undertow.server.handlers.proxy.ProxyCallback;
import io.undertow.server.handlers.proxy.ProxyClient;
import io.undertow.server.handlers.proxy.ProxyConnection;
import io.undertow.util.AttachmentKey;
import io.undertow.util.HttpString;
import org.xnio.IoUtils;
import org.xnio.OptionMap;

public class ContextPathProxyClient implements ProxyClient {
    private final List<ContextPathPredicate> contextPathPredicates;
    private final AttachmentKey<ClientConnection> clientConnectionAttachmentKey = AttachmentKey.create(ClientConnection.class);
    private final UndertowClient client;

    public ContextPathProxyClient(ContextPathPredicate... contextPathPredicates) {
        this.contextPathPredicates = Arrays.asList(contextPathPredicates);
        this.client = UndertowClient.getInstance();
    }

    /**
     * プロキシ先を決める.
     *
     * @param exchange HTTPリクエスト・レスポンスオブジェクト
     * @return プロキシ先
     */
    public ProxyTarget findTarget(HttpServerExchange exchange) {
        URI endpoint = contextPathPredicates.stream()
                .filter(p -> p.matches(exchange.getRequestURI()))
                .findFirst()
                .orElseThrow(() -> new NoPredicateMatchesException(""))
                .getEndpoint();
        System.out.println("matched: " + endpoint.toString());
        return new ContextPathProxyTarget(endpoint);
    }

    /**
     * プロキシ先とのコネクションを獲得する.
     *
     * @param target   プロキシ先
     * @param exchange HTTPリクエスト・レスポンスオブジェクト
     * @param callback プロキシ先からのレスポンスを扱うコールバックオブジェクト
     * @param timeout  タイムアウト時間
     * @param timeUnit ?
     */
    public void getConnection(
            ProxyTarget target,
            HttpServerExchange exchange,
            ProxyCallback<ProxyConnection> callback,
            long timeout,
            TimeUnit timeUnit
    ) {
        URI targetHost = ((ContextPathProxyTarget) target).getEndpoint();
        ClientConnection existing = exchange.getConnection().getAttachment(clientConnectionAttachmentKey);
        // 普通に使いまわすとAPIに流してほしいものをWEBに流したり、逆をやったりするので、
        // 同じ方に複数回来た時にそっちに流す、みたいな実装にする必要がありそう.
//        if (existing != null) {
//            if (existing.isOpen()) {
//                callback.completed(exchange, new ProxyConnection(existing, ""));
//                return;
//            } else {
//                exchange.getConnection().removeAttachment(clientConnectionAttachmentKey);
//            }
//        }

        client.connect(
                new ConnectNotifier(clientConnectionAttachmentKey, callback, exchange),
                targetHost,
                exchange.getIoThread(),
                exchange.getConnection().getByteBufferPool(),
                OptionMap.EMPTY
        );
    }

    private static class ContextPathProxyTarget implements ProxyTarget {
        private URI endpoint;

        ContextPathProxyTarget(URI endpoint) {
            this.endpoint = endpoint;
        }

        URI getEndpoint() {
            return endpoint;
        }
    }

    private static class ConnectNotifier implements ClientCallback<ClientConnection> {
        private final AttachmentKey<ClientConnection> clientConnectionAttachmentKey;
        private ProxyCallback<ProxyConnection> callback;
        private HttpServerExchange exchange;

        ConnectNotifier(
                AttachmentKey<ClientConnection> clientConnectionAttachmentKey,
                ProxyCallback<ProxyConnection> callback,
                HttpServerExchange exchange
        ) {
            this.clientConnectionAttachmentKey = clientConnectionAttachmentKey;
            this.callback = callback;
            this.exchange = exchange;
        }

        @Override
        public void completed(ClientConnection result) {
            ServerConnection serverConnection = exchange.getConnection();
            serverConnection.putAttachment(clientConnectionAttachmentKey, result);
            serverConnection.addCloseListener(sc -> IoUtils.safeClose(result));
            result.getCloseSetter().set(c -> serverConnection.removeAttachment(clientConnectionAttachmentKey));
            callback.completed(exchange, new ProxyConnection(result, ""));
        }

        @Override
        public void failed(IOException e) {
            callback.failed(exchange);
        }
    }
}
