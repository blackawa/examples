package jp.blackawa.example.undertow.reverse.proxy;

import java.net.URI;
import java.net.URISyntaxException;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.ResponseCommitListener;
import io.undertow.server.handlers.proxy.ProxyHandler;
import io.undertow.util.HttpString;

public class MutlipleHandlers {
    public static void main(String[] args) throws URISyntaxException {
        Undertow.builder()
                .addHttpListener(8081, "localhost")
                .setHandler(new ChainableHandler(1))
                .build()
                .start();

        Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(
                        new RewriteHeaderHandler(
                                ProxyHandler
                                        .builder()
                                        .setProxyClient(
                                                new ContextPathProxyClient(
                                                        new ContextPathPredicate(
                                                                "/api",
                                                                new URI("http://localhost:8081"))
                                                )
                                        )
                                        .build()))
                .build()
                .start();
    }

    private static class ChainableHandler implements HttpHandler {
        private String index;
        private HttpHandler next;

        public ChainableHandler(int index) {
            this(index, null);
        }

        public ChainableHandler(int index, HttpHandler next) {
            this.index = String.valueOf(index);
            this.next = next;
        }

        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
            if (exchange.isInIoThread()) {
                System.out.println("Dispatching exchange to worker thread...");
                exchange.dispatch(this);
            }
            System.out.println("=== handler[" + index + "] started");
            System.out.println("--- Request Header");
            System.out.println(exchange.getRequestHeaders());
            System.out.println("--- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

            exchange.getRequestHeaders().put(new HttpString("X-Add-" + index), "handler[" + index + "]");
            if (next != null) {
                next.handleRequest(exchange);
            }
            exchange.getResponseHeaders().put(new HttpString("X-Add-" + index), "handler[" + index + "]");

            System.out.println("--- Response Header");
            System.out.println(exchange.getResponseHeaders());
            System.out.println("--- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("=== handler[" + index + "] ended");
        }
    }

    private static class RewriteHeaderHandler implements HttpHandler {
        private HttpHandler next;

        public RewriteHeaderHandler(HttpHandler next) {
            this.next = next;
        }

        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
            System.out.println("=== RewriteHeaderHandler started");
            System.out.println("--- Request Header");
            System.out.println(exchange.getRequestHeaders());
            System.out.println("--- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            exchange.addResponseCommitListener(new ResponseCommitListener() {
                @Override
                public void beforeCommit(HttpServerExchange exchange) {
                    System.out.println("--- Response Header");
                    System.out.println(exchange.getResponseHeaders());
                    System.out.println("--- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println("=== RewriteHeaderHandler ended");
                }
            });
            next.handleRequest(exchange);
        }
    }
}
