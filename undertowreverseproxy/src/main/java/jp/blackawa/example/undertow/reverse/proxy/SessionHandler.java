package jp.blackawa.example.undertow.reverse.proxy;

import io.undertow.Undertow;
import io.undertow.server.handlers.CookieImpl;

public class SessionHandler {
    public static void main(String[] args) {
        Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(exchange -> {
                    exchange.getResponseCookies().put("SESSION", new CookieImpl("SESSION", "hoge------------"));
                })
                .build()
                .start();
    }
}
