package Les3Proxy;

public class RealImage implements Image {
    private String fileName;
    private long size;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Загрузка изображения: " + fileName);
        // Имитация тяжелой операции загрузки
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Имитация определения размера файла
        this.size = (long) (Math.random() * 10000000) + 1000000;
        System.out.println("Изображение загружено. Размер: " + size + " байт");
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public long getSize() {
        return size;
    }
}
