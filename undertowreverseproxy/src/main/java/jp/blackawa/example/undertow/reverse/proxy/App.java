package jp.blackawa.example.undertow.reverse.proxy;

import java.net.URI;
import java.net.URISyntaxException;

import io.undertow.Undertow;
import io.undertow.server.handlers.proxy.ProxyClient;
import io.undertow.server.handlers.proxy.ProxyHandler;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        ProxyClient proxyClient = new ContextPathProxyClient(
                new ContextPathPredicate("/api", new URI("http://localhost:3000")),
                new ContextPathPredicate("/", new URI("http://localhost:3001"))
        );

        Undertow undertow = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(ProxyHandler.builder().setProxyClient(proxyClient).build())
                .build();

        undertow.start();
    }
}
