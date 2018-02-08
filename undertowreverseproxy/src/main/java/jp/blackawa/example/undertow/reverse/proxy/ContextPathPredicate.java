package jp.blackawa.example.undertow.reverse.proxy;

import java.net.URI;

public class ContextPathPredicate {
    private String contextPath;
    private URI endpoint;

    ContextPathPredicate(String contextPath, URI endpoint) {
        this.contextPath = contextPath;
        this.endpoint = endpoint;
    }

    boolean matches(String uri) {
        return uri.startsWith(contextPath);
    }

    URI getEndpoint() {
        return endpoint;
    }
}
