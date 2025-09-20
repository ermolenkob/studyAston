package Les3Handler;

public class SeniorSupportHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getSeverity() <= 3) {
            System.out.println("Старший специалист обрабатывает запрос: " + request.getContent());
        } else if (nextHandler != null) {
            System.out.println("Старший специалист передает запрос руководителю");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Запрос не может быть обработан: " + request.getContent());
        }
    }
}
