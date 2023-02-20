package LinkedListRemaster;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Challenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        boolean flag = true;

        var roadTrip = new LinkedList<Town>();
        loadData(roadTrip);
        var iterator = roadTrip.listIterator();

        printActions();
        while (!exit) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "F" -> {
                   flag = moveForward(iterator, flag);

                }
                case "B" -> {
                    flag = moveBackward(iterator, flag);

                }
                case "L" -> {
                    listOfPlace(roadTrip);
                }
                case "M" -> {
                    printActions();
                }
                case "Q" -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Error. Wrong command");
                }
            }

        }

    }

    private static void printActions() {
        String textBlock = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)its Places
                (M)enu
                (Q)uit""";

        System.out.println(textBlock);
    }

    private static void loadData(LinkedList<Town> list) {
        list.add(new Town("Syndey", "0"));
        list.add(new Town("Melbourne", "877"));
        list.add(new Town("Brisbane", "917"));
        list.add(new Town("Adelaide", "1374"));
        list.add(new Town("Alice Springs", "2771"));
        list.add(new Town("Perth", "3923"));
        list.add(new Town("Darwin", "3972"));
    }

    private static void listOfPlace(LinkedList<Town> list) {
        System.out.println("*".repeat(14));
        System.out.println("List of towns:");
        for (Town town : list) {
            System.out.println(town.name());
        }
        System.out.println("*".repeat(14));
    }

    private static boolean moveForward (ListIterator<Town> iterator, boolean isPreviousMoveForward) {
        if (!isPreviousMoveForward) {
            iterator.next();
            isPreviousMoveForward = true;
        }

        if(iterator.hasNext()) {
            System.out.println("You are in " + iterator.next().name());
        } else {
            System.out.println("Available rout only backward");
        }

        return isPreviousMoveForward;
    }

    private static boolean moveBackward (ListIterator<Town> iterator, boolean isPreviousMoveForward) {
        if (isPreviousMoveForward) {
            iterator.previous();
            isPreviousMoveForward = false;
        }

        if(iterator.hasPrevious()) {
            System.out.println("You are in " + iterator.previous().name());
        } else {
            System.out.println("Available rout only forward");
        }

        return isPreviousMoveForward;
    }
}
