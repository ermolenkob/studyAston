package Les3Proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Прокси в действии ===\n");

        // Создаем прокси вместо реальных объектов
        Image image1 = new ImageProxy("nature.jpg");
        Image image2 = new ImageProxy("portrait.png");
        Image image3 = new ImageProxy("landscape.bmp");

        System.out.println("Прокси созданы, но реальные объекты еще не загружены\n");

        // Получаем информацию без загрузки
        System.out.println("Информация без загрузки:");
        System.out.println("Файл: " + image1.getFileName() + ", примерный размер: " + image1.getSize());
        System.out.println("Файл: " + image2.getFileName() + ", примерный размер: " + image2.getSize());
        System.out.println();

        // Отображаем изображение (происходит загрузка)
        System.out.println("Первое отображение (происходит загрузка):");
        image1.display();
        System.out.println();

        System.out.println("Второе отображение (уже загружено):");
        image1.display();
        System.out.println();

        // Предварительная загрузка
        ImageProxy proxy3 = (ImageProxy) image3;
        System.out.println("Предварительная загрузка третьего изображения:");
        proxy3.preload();
        System.out.println();

        System.out.println("Отображение предзагруженного изображения:");
        image3.display();
    }
}
