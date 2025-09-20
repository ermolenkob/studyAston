package Les3Strategy;

// StrategyPatternDemo.java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Добавляем товары в корзину
        cart.addItem(1000);
        cart.addItem(2000);
        cart.addItem(500);

        System.out.println("Общая сумма: " + cart.getTotalAmount());

        // Используем разные стратегии оплаты
        // Кредитная карта
        PaymentStrategy creditCard = new CreditCardStrategy(
                "1234-5678-9012-3456",
                "Иван Иванов",
                "123",
                "12/25"
        );
        cart.setPaymentStrategy(creditCard);
        cart.checkout();

        // PayPal
        cart.addItem(1500);
        cart.addItem(800);

        PaymentStrategy paypal = new PayPalStrategy("user@example.com", "password123");
        cart.setPaymentStrategy(paypal);
        cart.checkout();

        // Криптовалюта
        cart.addItem(3000);

        PaymentStrategy crypto = new CryptoStrategy("0x742d35Cc6634C0532925a3b8...");
        cart.setPaymentStrategy(crypto);
        cart.checkout();
    }
}
