package jp.blackawa.example.undertow.reverse.proxy;

public class NoPredicateMatchesException extends RuntimeException {
    public NoPredicateMatchesException(String message) {
        super(message);
    }
}
