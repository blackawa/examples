package example.blackawa.jp;

/**
 * リストの構成要素.
 */
public class MyElement {
    private Status status;
    private int bar;

    public MyElement(Status status, int bar) {
        this.status = status;
        this.bar = bar;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }
}
