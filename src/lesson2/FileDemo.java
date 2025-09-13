package lesson2;

import java.util.*;

public class FileDemo {

    public static void main(String[] args) {
        String fileName = "example.txt";

        try {
            // Запись данных в файл
            System.out.println("Записываем данные в файл...");
            FileManager.writeToFile(fileName, "Привет, мир!", false);
            FileManager.writeToFile(fileName, "Это тестовая запись.", true);
            FileManager.writeToFile(fileName, "Java File I/O demonstration", true);

            // Чтение всех строк из файла
            System.out.println("\nЧитаем файл построчно:");
            List<String> lines = FileManager.readFromFile(fileName);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("Строка " + (i + 1) + ": " + lines.get(i));
            }

            // Чтение файла как одной строки
            System.out.println("\nЧитаем файл как одну строку:");
            String content = FileManager.readFileAsString(fileName);
            System.out.println(content);

            // Тестирование обработки ошибок
            System.out.println("\nТестируем обработку ошибок...");
            try {
                FileManager.readFromFile("nonexistent.txt");
            } catch (FileOperationException e) {
                System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
                System.out.println("Причина: " + e.getCause().getMessage());
            }

        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка при работе с файлом:");
            System.err.println("Сообщение: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Причина: " + e.getCause().getMessage());
            }
            e.printStackTrace();
        }
    }
}
