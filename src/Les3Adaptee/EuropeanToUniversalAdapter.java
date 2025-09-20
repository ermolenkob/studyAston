package Les3Adaptee;

// адаптер для европейской розетки
public class EuropeanToUniversalAdapter implements UniversalPowerOutlet {
    private EuropeanCharger europeanCharger;

    public EuropeanToUniversalAdapter(EuropeanCharger charger) {
        this.europeanCharger = charger;
    }

    @Override
    public String deliverPower() {
        return "Adapted: " + europeanCharger.supplyPower220V() + " to universal standard";
    }

    @Override
    public String getCompatibilityInfo() {
        return "European " + europeanCharger.getPlugType() + " → Universal adapter";
    }

    @Override
    public boolean checkSafety() {
        return europeanCharger.hasGround();
    }
}
