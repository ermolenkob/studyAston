import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> {
        private final List<T>[] buckets;
        private final int capacity;

        public MyHashSet() {
            this(16); // для примера
        }

        @SuppressWarnings("unchecked")
        public MyHashSet(int capacity) {
            this.capacity = capacity;
            this.buckets = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // Вставить элемент
        public boolean insert(T element) {
            if (element == null) return false;

            int index = Math.abs(element.hashCode()) % capacity;
            if (!buckets[index].contains(element)) {
                buckets[index].add(element);
                return true;
            }
            return false;
        }

        // Удалить элемент
        public boolean remove(T element) {
            if (element == null) return false;

            int index = Math.abs(element.hashCode()) % capacity;
            return buckets[index].remove(element);
        }
}