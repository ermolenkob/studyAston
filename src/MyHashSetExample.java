public class MyHashSetExample {
    public static void main(String[] args) {
        // Создаем наш собственный HashSet
        MyHashSet<String> mySet = new MyHashSet<>();

        System.out.println("=== ТЕСТИРОВАНИЕ МЕТОДА INSERT ===");

        // Добавляем элементы
        System.out.println("Добавляем 'apple': " + mySet.insert("apple")); // true
        System.out.println("Добавляем 'banana': " + mySet.insert("banana")); // true
        System.out.println("Добавляем 'orange': " + mySet.insert("orange")); // true

        // Пытаемся добавить дубликат
        System.out.println("Добавляем 'apple' снова: " + mySet.insert("apple")); // false

        // Добавляем еще элементы
        System.out.println("Добавляем 'grape': " + mySet.insert("grape")); // true
        System.out.println("Добавляем 'lemon': " + mySet.insert("lemon")); // true

        System.out.println("\n=== ТЕСТИРОВАНИЕ МЕТОДА REMOVE ===");

        // Удаляем существующие элементы
        System.out.println("Удаляем 'banana': " + mySet.remove("banana")); // true
        System.out.println("Удаляем 'orange': " + mySet.remove("orange")); // true

        // Пытаемся удалить несуществующий элемент
        System.out.println("Удаляем 'mango' (не существует): " + mySet.remove("mango")); // false

        // Пытаемся удалить уже удаленный элемент
        System.out.println("Удаляем 'banana' снова: " + mySet.remove("banana")); // false

        System.out.println("\n=== ТЕСТ С ЧИСЛАМИ ===");

        MyHashSet<Integer> numberSet = new MyHashSet<>();

        // Добавляем числа
        for (int i = 1; i <= 5; i++) {
            System.out.println("Добавляем " + i + ": " + numberSet.insert(i));
        }

        // Пытаемся добавить дубликаты
        System.out.println("Добавляем 3 снова: " + numberSet.insert(3)); // false
        System.out.println("Добавляем 5 снова: " + numberSet.insert(5)); // false

        // Удаляем некоторые числа
        System.out.println("Удаляем 2: " + numberSet.remove(2)); // true
        System.out.println("Удаляем 4: " + numberSet.remove(4)); // true
        System.out.println("Удаляем 10 (не существует): " + numberSet.remove(10)); // false

        System.out.println("\n=== ТЕСТ С NULL ===");

        // Тестируем обработку null
        System.out.println("Добавляем null: " + mySet.insert(null)); // false
        System.out.println("Удаляем null: " + mySet.remove(null)); // false

        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЙ ТЕСТ ===");

        // Создаем новый набор для демонстрации
        MyHashSet<String> testSet = new MyHashSet<>(4); // Маленькая емкость для теста коллизий

        // Добавляем элементы, которые могут иметь одинаковый хэш
        String[] testWords = {"a", "b", "c", "d", "e", "f", "g"};

        for (String word : testWords) {
            boolean inserted = testSet.insert(word);
            System.out.println("Добавили '" + word + "': " + inserted +
                    ", хэш: " + word.hashCode() +
                    ", индекс: " + (Math.abs(word.hashCode()) % 4));
        }

        // Удаляем некоторые элементы
        System.out.println("\nУдаляем 'c': " + testSet.remove("c"));
        System.out.println("Удаляем 'e': " + testSet.remove("e"));
        System.out.println("Удаляем 'x' (не существует): " + testSet.remove("x"));

        // Пытаемся добавить элементы снова
        System.out.println("\nПытаемся добавить удаленные элементы:");
        System.out.println("Добавляем 'c' снова: " + testSet.insert("c")); // true
        System.out.println("Добавляем 'e' снова: " + testSet.insert("e")); // true
        System.out.println("Добавляем 'a' снова: " + testSet.insert("a")); // false (уже существует)
    }
}