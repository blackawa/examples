package jp.blackawa.examples;

/**
 * 挨拶を出力するサービスクラス.
 */
public class HelloService {
    private Hello hello;

    // Getter, Setterを用意しておく.
    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public Hello getHello() {
        return hello;
    }
}
