package Les3Handler;

// ChainOfResponsibilityDemo.java
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Создаем цепочку обработчиков
        Handler junior = new JuniorSupportHandler();
        Handler middle = new MiddleSupportHandler();
        Handler senior = new SeniorSupportHandler();
        Handler manager = new ManagerHandler();

        // Настраиваем цепочку: junior -> middle -> senior -> manager
        junior.setNext(middle).setNext(senior).setNext(manager);

        System.out.println("=== Тестирование цепочки обязанностей ===\n");

        // Создаем различные запросы
        Request[] requests = {
                new Request("Технический", "Не работает мышь", 1),
                new Request("Программный", "Ошибка в приложении", 2),
                new Request("Системный", "Сервер не отвечает", 3),
                new Request("Критический", "Полный сбой системы", 4),
                new Request("Аварийный", "Потеря данных", 5)
        };

        // Обрабатываем каждый запрос через цепочку
        for (Request request : requests) {
            System.out.println("\n--- Обработка запроса: " + request.getContent() + " (уровень: " + request.getSeverity() + ") ---");
            junior.handleRequest(request);
        }
    }
}