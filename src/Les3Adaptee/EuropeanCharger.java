package Les3Adaptee;

public class EuropeanCharger {
    public String supplyPower220V() {
        return "220V power from European socket";
    }

    public String getPlugType() {
        return "Type C/F (European)";
    }

    public boolean hasGround() {
        return true;
    }
}
