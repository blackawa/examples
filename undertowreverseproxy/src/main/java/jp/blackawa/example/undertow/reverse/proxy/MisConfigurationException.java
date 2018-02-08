package jp.blackawa.example.undertow.reverse.proxy;

public class MisConfigurationException extends RuntimeException {
    public MisConfigurationException(String message) {
        super(message);
    }
}
