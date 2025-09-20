package Les3Handler;

public class JuniorSupportHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getSeverity() <= 1) {
            System.out.println("Младший специалист обрабатывает запрос: " + request.getContent());
        } else if (nextHandler != null) {
            System.out.println("Младший специалист передает запрос старшему коллеге");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Запрос не может быть обработан: " + request.getContent());
        }
    }
}
