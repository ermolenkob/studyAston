public class MyArrayListExample {
    public static void main(String[] args) {
        System.out.println("=== СОЗДАНИЕ И РАБОТА С MYARRAYLIST ===");

        // 1. Создаем список строк
        MyArrayList<String> stringList = new MyArrayList<>();
        System.out.println("Создан пустой список: " + stringList);
        System.out.println("Размер: " + stringList.size());

        // 2. Добавляем элементы
        System.out.println("\n--- Добавление элементов ---");
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        System.out.println("После добавления 3 элементов: " + stringList);
        System.out.println("Размер: " + stringList.size());

        // 3. Добавляем элемент по индексу
        System.out.println("\n--- Добавление по индексу ---");
        stringList.add(1, "Grape");
        System.out.println("После добавления 'Grape' на позицию 1: " + stringList);

        // 4. Получаем элементы
        System.out.println("\n--- Получение элементов ---");
        System.out.println("Элемент на позиции 0: " + stringList.get(0));
        System.out.println("Элемент на позиции 2: " + stringList.get(2));
        System.out.println("Элемент на позиции 3: " + stringList.get(3));

        // 5. Удаляем элементы
        System.out.println("\n--- Удаление элементов ---");
        String removedElement = stringList.remove(2);
        System.out.println("Удаленный элемент: " + removedElement);
        System.out.println("После удаления элемента на позиции 2: " + stringList);

        // 6. Добавляем массив элементов
        System.out.println("\n--- Добавление массива элементов ---");
        String[] newFruits = {"Mango", "Pineapple", "Kiwi", "Lemon"};
        stringList.addAll(newFruits);
        System.out.println("После добавления массива: " + stringList);
        System.out.println("Размер: " + stringList.size());

        // 7. Тестируем автоматическое расширение
        System.out.println("\n--- Тест автоматического расширения ---");
        MyArrayList<Integer> numbers = new MyArrayList<>(4); // Маленькая начальная емкость

        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 10);
            System.out.println("Добавлен " + (i * 10) + ", размер: " + numbers.size());
        }
        System.out.println("Итоговый список чисел: " + numbers);

        // 8. Работа с разными типами данных
        System.out.println("\n--- Работа с разными типами данных ---");

        // Список целых чисел
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(100);
        intList.add(200);
        intList.add(300);
        System.out.println("Список целых чисел: " + intList);

        // Список дробных чисел
        MyArrayList<Double> doubleList = new MyArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);
        doubleList.add(1.618);
        System.out.println("Список дробных чисел: " + doubleList);

        // Список булевых значений
        MyArrayList<Boolean> boolList = new MyArrayList<>();
        boolList.add(true);
        boolList.add(false);
        boolList.add(true);
        System.out.println("Список булевых значений: " + boolList);

        // 9. Демонстрация обработки ошибок
        System.out.println("\n--- Обработка ошибок ---");
        try {
            System.out.println("Попытка получить элемент с неверным индексом:");
            stringList.get(100); // Вызовет исключение
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            System.out.println("Попытка добавить элемент с неверным индексом:");
            stringList.add(-1, "Error"); // Вызовет исключение
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // 10. Демонстрация вставки в разные позиции
        System.out.println("\n--- Вставка в разные позиции ---");
        MyArrayList<String> demoList = new MyArrayList<>();

        // Вставка в пустой список
        demoList.add(0, "First");
        System.out.println("После вставки в пустой список: " + demoList);

        // Вставка в начало
        demoList.add(0, "New First");
        System.out.println("После вставки в начало: " + demoList);

        // Вставка в конец
        demoList.add(demoList.size(), "Last");
        System.out.println("После вставки в конец: " + demoList);

        // Вставка в середину
        demoList.add(1, "Middle");
        System.out.println("После вставки в середину: " + demoList);

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}