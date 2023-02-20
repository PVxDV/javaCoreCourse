package AbstractClassesChallengeRemasted;

public class PlayStation extends ProductsForSale{

    private boolean haveADrive;
    private String generation;

    public PlayStation(String type, double price, String description, boolean haveADrive, String generation) {
        super(type, price, description);
        this.haveADrive = haveADrive;
        this.generation = generation;
    }

    @Override
    public void showDetails() {
        System.out.printf("%s %s generation %s drive %n",
                this.getClass().getSimpleName(), generation, haveADrive ? "with" : "without");
    }
}
