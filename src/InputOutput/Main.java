package InputOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static int startPosition = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTH-EAST", "NE");
        vocabulary.put("SOUTH-EAST", "SE");
        vocabulary.put("SOUTH-WEST", "SW");
        vocabulary.put("NORTH-WEST", "NW");
        vocabulary.put("DOWN", "D");
        vocabulary.put("UP", "U");

        while(true) {
            System.out.println(locations.get(startPosition).getDescription());

            if(startPosition == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(startPosition).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                startPosition = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}