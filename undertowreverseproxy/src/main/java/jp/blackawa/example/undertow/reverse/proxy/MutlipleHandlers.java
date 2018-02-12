package jp.blackawa.example.undertow.reverse.proxy;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class MutlipleHandlers {
    public static void main(String[] args) {
        Undertow undertow = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new ChainableHandler(0, new ChainableHandler(1)))
                .build();

        undertow.start();
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
            System.out.println("handler[" + index + "] started");
            System.out.println("Request Header ===============");
            System.out.println(exchange.getRequestHeaders());
            System.out.println("Request Header ===============");

            exchange.getRequestHeaders().put(new HttpString("X-Add-" + index), "handler[" + index + "]is working");
            if (next != null) {
                next.handleRequest(exchange);
            }
            exchange.getResponseHeaders().put(new HttpString("X-Add-" + index), "handler[" + index + "]");

            System.out.println("Response Header ===============");
            System.out.println(exchange.getResponseHeaders());
            System.out.println("Response Header ===============");
            System.out.println("handler[" + index + "] ended");
        }
    }
}
