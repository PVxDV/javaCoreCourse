package ArrayListChallengeRemaster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;


public class GroceryList {
    private ArrayList<String> list = new ArrayList<>();

    public GroceryList() {
    }

    public void addItem(String input){
        String[] data = input.split(",");

        for (int i=0; i<data.length; i++) {
            if(list.contains(data[i])) {
                System.out.format("%s already exists. %n", data[i].toUpperCase(Locale.ROOT));
            } else {
                list.add(data[i].trim());
            }
        }

        list.sort(Comparator.naturalOrder());

        System.out.println("Grocery list contains:");
        System.out.println(list);
    }

    public void removeItem(String input) {
        String[] data = input.split(",");

        for (int i=0; i<data.length; i++) {
            if(list.contains(data[i].trim())) {
                list.remove(data[i]);
            } else {
                System.out.format("%s was not found. %n", data[i].toUpperCase());
            }
        }

        list.sort(Comparator.naturalOrder());

        System.out.println("Grocery list contains:");
        System.out.println(list);
    }

}
