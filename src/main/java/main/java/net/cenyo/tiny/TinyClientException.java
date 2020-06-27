package main.java.net.cenyo.tiny;

public class TinyClientException extends RuntimeException {

    private static final long serialVersionUID = 5810677972369016949L;


    public TinyClientException() {
        super();
    }


    public TinyClientException(String message, Throwable cause) {
        super(message, cause);
    }


    public TinyClientException(String message) {
        super(message);
    }


    public TinyClientException(Throwable cause) {
        super(cause);
    }
}
