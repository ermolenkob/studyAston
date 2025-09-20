package Les3Adaptee;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Адаптер в действии ===\n");

        // Создаем оригинальные объекты
        EuropeanCharger europeanCharger = new EuropeanCharger();
        AmericanCharger americanCharger = new AmericanCharger();

        System.out.println("Оригинальные зарядные устройства:");
        System.out.println("Европейское: " + europeanCharger.supplyPower220V());
        System.out.println("Американское: " + americanCharger.providePower110V());
        System.out.println();

        // Создаем адаптеры
        UniversalPowerOutlet europeanAdapter = new EuropeanToUniversalAdapter(europeanCharger);
        UniversalPowerOutlet americanAdapter = new AmericanToUniversalAdapter(americanCharger);

        System.out.println("Через адаптеры:");
        testPowerOutlet(europeanAdapter);
        testPowerOutlet(americanAdapter);

        // Дополнительное тестирование
        System.out.println("\n=== Дополнительное тестирование ===");
        UniversalPowerOutlet[] outlets = {europeanAdapter, americanAdapter};

        for (UniversalPowerOutlet outlet : outlets) {
            System.out.println("\nИнформация о совместимости: " + outlet.getCompatibilityInfo());
            System.out.println("Безопасность: " + (outlet.checkSafety() ? "✓ Проверено" : "✗ Опасно"));
            System.out.println("Питание: " + outlet.deliverPower());
        }
    }

    private static void testPowerOutlet(UniversalPowerOutlet outlet) {
        System.out.println(outlet.getCompatibilityInfo());
        System.out.println("Мощность: " + outlet.deliverPower());
        System.out.println("Безопасность: " + outlet.checkSafety());
        System.out.println();
    }
}
