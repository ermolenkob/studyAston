package Les3Handler;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public abstract void handleRequest(Request request);
}
