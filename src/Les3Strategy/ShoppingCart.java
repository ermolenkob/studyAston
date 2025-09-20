package Les3Strategy;

// ShoppingCart.java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private int totalAmount;

    public ShoppingCart() {
        this.totalAmount = 0;
    }

    public void addItem(int price) {
        totalAmount += price;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Не выбран способ оплаты!");
            return;
        }
        paymentStrategy.pay(totalAmount);
        totalAmount = 0; // очищаем корзину после оплаты
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
