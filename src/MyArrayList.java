import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    // Добавить элемент
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Добавить по индексу
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Получить элемент
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    // Удалить по индексу
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    // Добавить все элементы из массива
    public void addAll(T[] array) {
        for (T element : array) {
            add(element);
        }
    }

    // Размер списка
    public int size() {
        return size;
    }

    // Проверка емкости
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}