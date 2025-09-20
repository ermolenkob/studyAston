package Les3Builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Builder в действии ===\n");

        // Простой компьютер
        Computer basicComputer = new Computer.ComputerBuilder("Intel i3", "8GB DDR4")
                .build();

        System.out.println("Базовый компьютер:");
        System.out.println(basicComputer);
        System.out.println();

        // Игровой компьютер
        Computer gamingComputer = new Computer.ComputerBuilder("AMD Ryzen 7", "32GB DDR4")
                .graphicsCard("NVIDIA RTX 4080")
                .storage("2TB NVMe SSD")
                .motherboard("ASUS ROG Strix")
                .powerSupply("850W Gold")
                .hasBluetooth(true)
                .hasWiFi(true)
                .coolingSystem("Liquid Cooling")
                .build();

        System.out.println("Игровой компьютер:");
        System.out.println(gamingComputer);
        System.out.println();

        // Офисный компьютер
        Computer officeComputer = new Computer.ComputerBuilder("Intel i5", "16GB DDR4")
                .storage("512GB SSD")
                .hasWiFi(true)
                .build();

        System.out.println("Офисный компьютер:");
        System.out.println(officeComputer);
        System.out.println();

        // Можно создавать цепочки вызовов
        Computer customComputer = new Computer.ComputerBuilder("Intel i7", "64GB DDR5")
                .graphicsCard("NVIDIA RTX 4090")
                .storage("4TB SSD")
                .motherboard("Gigabyte AORUS")
                .powerSupply("1000W Platinum")
                .hasBluetooth(true)
                .hasWiFi(true)
                .coolingSystem("Custom Water Loop")
                .build();

        System.out.println("Кастомный компьютер:");
        System.out.println(customComputer);
    }
}
