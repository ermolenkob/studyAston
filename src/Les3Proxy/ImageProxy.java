package Les3Proxy;

public class ImageProxy implements Image {
    private RealImage realImage;
    private String fileName;
    private boolean loaded = false;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    private void checkAndLoad() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
            loaded = true;
        }
    }

    @Override
    public void display() {
        checkAndLoad();
        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public long getSize() {
        if (!loaded) {
            // Может возвращать приблизительный размер без загрузки
            System.out.println("Получение приблизительного размера без загрузки файла");
            return (long) (Math.random() * 5000000) + 500000;
        }
        checkAndLoad();
        return realImage.getSize();
    }

    // Дополнительные методы прокси
    public boolean isLoaded() {
        return loaded;
    }

    public void preload() {
        if (!loaded) {
            System.out.println("Предварительная загрузка изображения: " + fileName);
            checkAndLoad();
        }
    }
}
