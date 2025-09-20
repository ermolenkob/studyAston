package Les3Builder;

public class Computer {
    // Обязательные параметры
    private final String processor;
    private final String ram;

    // Необязательные параметры
    private final String graphicsCard;
    private final String storage;
    private final String motherboard;
    private final String powerSupply;
    private final boolean hasBluetooth;
    private final boolean hasWiFi;
    private final String coolingSystem;

    // Приватный конструктор
    private Computer(ComputerBuilder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.graphicsCard = builder.graphicsCard;
        this.storage = builder.storage;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWiFi = builder.hasWiFi;
        this.coolingSystem = builder.coolingSystem;
    }

    // Геттеры
    public String getProcessor() { return processor; }
    public String getRam() { return ram; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getStorage() { return storage; }
    public String getMotherboard() { return motherboard; }
    public String getPowerSupply() { return powerSupply; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public boolean hasWiFi() { return hasWiFi; }
    public String getCoolingSystem() { return coolingSystem; }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", storage='" + storage + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", hasBluetooth=" + hasBluetooth +
                ", hasWiFi=" + hasWiFi +
                ", coolingSystem='" + coolingSystem + '\'' +
                '}';
    }

    // Статический Builder класс
    public static class ComputerBuilder {
        // Обязательные параметры
        private final String processor;
        private final String ram;

        // Необязательные параметры с значениями по умолчанию
        private String graphicsCard = "Integrated";
        private String storage = "256GB SSD";
        private String motherboard = "Standard";
        private String powerSupply = "500W";
        private boolean hasBluetooth = false;
        private boolean hasWiFi = false;
        private String coolingSystem = "Air";

        // Конструктор для обязательных параметров
        public ComputerBuilder(String processor, String ram) {
            this.processor = processor;
            this.ram = ram;
        }

        // Методы для необязательных параметров
        public ComputerBuilder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public ComputerBuilder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public ComputerBuilder hasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public ComputerBuilder hasWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public ComputerBuilder coolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        // Метод построения объекта
        public Computer build() {
            return new Computer(this);
        }
    }
}
