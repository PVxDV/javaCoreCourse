package AbstractClassesChallengeRemasted;

public class LegoCar extends ProductsForSale{

    private int numberOfBlocks;
    private String name;

    public LegoCar(String type, double price, String description, int numberOfBlocks, String name) {
        super(type, price, description);
        this.numberOfBlocks = numberOfBlocks;
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.printf("%s including %d number of blocks %n", name, numberOfBlocks);
    }
}
