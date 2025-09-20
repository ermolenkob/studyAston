package Les3Coffee;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", сахар";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 10.0;
    }
}
