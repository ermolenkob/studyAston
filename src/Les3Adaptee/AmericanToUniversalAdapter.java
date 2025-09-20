package Les3Adaptee;

// адаптер для американской розетки
public class AmericanToUniversalAdapter implements UniversalPowerOutlet {
    private AmericanCharger americanCharger;

    public AmericanToUniversalAdapter(AmericanCharger charger) {
        this.americanCharger = charger;
    }

    @Override
    public String deliverPower() {
        return "Adapted: " + americanCharger.providePower110V() + " to universal standard";
    }

    @Override
    public String getCompatibilityInfo() {
        return "American " + americanCharger.getOutletType() + " → Universal adapter";
    }

    @Override
    public boolean checkSafety() {
        return americanCharger.isPolarized();
    }
}
