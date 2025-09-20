package Les3Handler;

public class ManagerHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getSeverity() <= 4) {
            System.out.println("Руководитель обрабатывает запрос: " + request.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Запрос не может быть обработан: " + request.getContent());
        }
    }
}
