package ArrayListChallengeRemaster;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                Enter a number for which action you want to do:""";

        String error = "Error. Available actions only \"0\", \"1\" and \"2\"";
        String massage = "Write items(s) to %s [separate items by comma]: ";

        while (!exit) {
            System.out.print(textBlock + " ");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0 -> {
                    exit = true;
                    System.out.println("You exit program");
                    scanner.close();
                }
                case 1 -> {
                    System.out.format(massage, "add");
                    groceryList.addItem(scanner.nextLine());
                }
                case 2 -> {
                    System.out.format(massage, "delete");
                    groceryList.removeItem(scanner.nextLine());
                }
                default -> System.out.println(error);
            }
        }
    }


}


