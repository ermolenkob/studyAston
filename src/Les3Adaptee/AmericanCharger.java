package Les3Adaptee;

public class AmericanCharger {
    public String providePower110V() {
        return "110V power from American outlet";
    }

    public String getOutletType() {
        return "Type A/B (American)";
    }

    public boolean isPolarized() {
        return true;
    }
}
