package Les3Handler;

public class MiddleSupportHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getSeverity() <= 2) {
            System.out.println("Средний специалист обрабатывает запрос: " + request.getContent());
        } else if (nextHandler != null) {
            System.out.println("Средний специалист передает запрос старшему коллеге");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Запрос не может быть обработан: " + request.getContent());
        }
    }
}
