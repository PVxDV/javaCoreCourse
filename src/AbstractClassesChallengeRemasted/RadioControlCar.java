package AbstractClassesChallengeRemasted;

public class RadioControlCar extends ProductsForSale{
    private int workingTime;

    public RadioControlCar(String type, double price, String description, int workingTime) {
        super(type, price, description);
        this.workingTime = workingTime;
    }

    @Override
    public void showDetails() {
        System.out.printf("%s with %d minutes of play without recharging %n", this.getClass().getSimpleName(), workingTime);
    }
}
