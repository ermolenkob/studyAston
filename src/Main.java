import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Book> books1 = List.of(
                new Book("Книга002", 1999, 300),
                new Book("Книга002", 2005, 450),
                new Book("Книга003", 2010, 500),
                new Book("Книга004", 2008, 250),
                new Book("Книга005", 2001, 600)
        );

        List<Book> books2 = List.of(
                new Book("Книга001", 1999, 300),
                new Book("Книга001", 2005, 450),
                new Book("Книга003", 2010, 500),
                new Book("Книга004", 2008, 250),
                new Book("Книга005", 2001, 600)
        );

        List<Book> books3 = List.of(
                new Book("Книга001", 1999, 300),
                new Book("Книга002", 2005, 450),
                new Book("Книга002", 2010, 500),
                new Book("Книга004", 2008, 250),
                new Book("Книга005", 2001, 600)
        );

        List<Book> books4 = List.of(
                new Book("Книга001", 1999, 300),
                new Book("Книга002", 2005, 450),
                new Book("Книга003", 2010, 500),
                new Book("Книга003", 2008, 250),
                new Book("Книга005", 2001, 600)
        );

        List<Book> books5 = List.of(
                new Book("Книга001", 1999, 300),
                new Book("Книга002", 2005, 450),
                new Book("Книга003", 2010, 500),
                new Book("Книга004", 2008, 250),
                new Book("Книга004", 2001, 600)
        );

        // Создаем студентов
        List<Student> students = List.of(
                new Student("Алиса", 20, books1),
                new Student("Боря", 21, books2),
                new Student("Вова", 22, books3),
                new Student("Гена", 23, books4),
                new Student("Дима", 24, books5)
        );

        students.stream()
                // 1. Вывести в консоль каждого студента
                .peek(student -> System.out.println(student.toString()))
                // 2. Получить для каждого студента список книг
                .flatMap(student -> student.getBooks().stream())
                // 3. Получить книги
                .peek(book -> System.out.println(book.toString()))
                // 4. Отсортировать книги по количеству страниц
                .sorted(Comparator.comparingInt(Book::getPages))
                // 5. Оставить только уникальные книги
                .distinct()
                // 6. Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
                .filter(book -> book.getYear() > 2000)
                // 7. Ограничить стрим на 3 элементах
                .limit(3)
                // 8. Получить из книг годы выпуска
                .map(Book::getYear)
                // 9. При помощи методов короткого замыкания вернуть Optional от книги
                // 10. При помощи методов получения значения из Optional вывести
                // в консоль год выпуска найденной книги, либо запись о том, что такая книга отсутствует
                .findFirst() // Короткое замыкание. найду первый и остановлюсь на нем
                .ifPresentOrElse(
                        year -> System.out.println("\nГод выпуска найденной книги: " + year),
                        () -> System.out.println("\nКнига не найдена")
                );
    }
}