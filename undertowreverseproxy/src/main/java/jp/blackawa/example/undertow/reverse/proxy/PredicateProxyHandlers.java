package jp.blackawa.example.undertow.reverse.proxy;

import java.net.URI;
import java.net.URISyntaxException;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.ResponseCommitListener;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.ProxyPeerAddressHandler;
import io.undertow.server.handlers.proxy.LoadBalancingProxyClient;
import io.undertow.server.handlers.proxy.ProxyHandler;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;
import sun.security.krb5.internal.rcache.AuthTimeWithHash;

public class PredicateProxyHandlers {
    public static void main(String[] args) throws URISyntaxException {
        // API backend application
        Undertow.builder().addHttpListener(8081, "localhost").setHandler(new SimpleHandler("application/json; charset=utf-8")).build().start();
        // Web backend application
        Undertow.builder().addHttpListener(8082, "localhost").setHandler(new SimpleHandler("text/html; charset=utf-8")).build().start();

        HttpHandler apiProxyHandler = ProxyHandler.builder()
                .setProxyClient(new LoadBalancingProxyClient().addHost(new URI("http://localhost:8081")))
                .build();
        HttpHandler webProxyHandler = ProxyHandler.builder()
                .setProxyClient(new LoadBalancingProxyClient().addHost(new URI("http://localhost:8082")))
                .build();

        // Handler to choose backend application depends on context path.
        HttpHandler pathHandler = new PathHandler()
                .addPrefixPath("/api", new RewriteHeaderHandler(apiProxyHandler))
                .addPrefixPath("/", new RewriteHeaderHandler(webProxyHandler));

        Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(pathHandler)
                .build()
                .start();
    }

    /**
     * Handler to mock backend application.
     * This handler returns simple response body.
     * You can choose response header by a constructor parameter.
     */
    private static class SimpleHandler implements HttpHandler {
        private HttpString AUTHENTICATION_HEADER_KEY = new HttpString("X-Authentication");
        private String contentType;

        public SimpleHandler(String contentType) {
            this.contentType = contentType;
        }

        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
            // Simply add response header and contents.
            String information = exchange.getRequestHeaders().get(AUTHENTICATION_HEADER_KEY).getFirst();
            exchange.getResponseHeaders().put(AUTHENTICATION_HEADER_KEY, "{\"information\": \"" + information + "\"}");

            // Add response information
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, contentType);
            exchange.getResponseSender().send("{\"message\": \"Hello world!\"}");
        }
    }

    private static class RewriteHeaderHandler implements HttpHandler {
        private final HttpString AUTHENTICATION_HEADER_KEY = new HttpString("X-Authentication");
        private HttpHandler next;

        public RewriteHeaderHandler(HttpHandler next) {
            this.next = next;
        }

        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
            // Add authentication information to request header for backend application
            exchange.getRequestHeaders().put(AUTHENTICATION_HEADER_KEY, "{\"accountId\": 1}");

            // Check response header from backend application, and remove authentication information
            exchange.addResponseCommitListener(exc -> {
                System.out.println("=== RewriteHeaderHandler/ResponseCommitListener");
                System.out.println(exc.getResponseHeaders());
                exchange.getResponseHeaders().remove(AUTHENTICATION_HEADER_KEY);
            });
            next.handleRequest(exchange);
        }
    }
}
