package AbstractClassesChallengeRemasted;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static ArrayList<ProductsForSale> productsForSale = new ArrayList<>();

    public static void main(String[] args) {
        productsForSale.add(new LegoCar("toy", 16.99, "Lego Technics", 1000, "model-457"));
        productsForSale.add(new PlayStation("gameTools", 50.99, "Play Station 5 with a drive", true, "5"));
        productsForSale.add(new RadioControlCar("toy", 30.23, "Toy Car with radio control", 120));
        printProductDetails();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addAnItemToTheOrder(order1, 1,2);
        addAnItemToTheOrder(order1,0,1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addAnItemToTheOrder(order2, 0,1);
        addAnItemToTheOrder(order2,2,1);
        addAnItemToTheOrder(order2,1,3);
        printOrder(order2);


    }

    private static void addAnItemToTheOrder(ArrayList<OrderItem> order, int orderIndex, int quantity) {
        order.add(new OrderItem(quantity, productsForSale.get(orderIndex)));
    }

    private static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for (var orderItem: order) {
            orderItem.products().printPricedItem(orderItem.quantity());
            salesTotal += orderItem.products().getASalesPrice(orderItem.quantity());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }

    private static void printProductDetails() {
        for (var p : productsForSale) {
            System.out.println("-".repeat(30));
            p.showDetails();
        }
    }

}
