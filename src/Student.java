import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private List<Book> books;

    public Student(String name, int age, List<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Book> getBooks() { return books; }

    @Override
    public String toString() {
        return "Студент: " + name + ", возраст: " + age;
    }
}