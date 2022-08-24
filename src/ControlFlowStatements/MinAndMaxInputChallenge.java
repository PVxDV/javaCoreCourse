package ControlFlowStatements;

/*
-Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered.
 -Before the user enters the number, print the message ЃgEnter number:Ѓh
        -If the user enters an invalid number, break out of the loop and print the minimum and maximum number.

        Hint:
        -Use an endless while loop.

        Bonus:
        -Create a project with the name MinAndMaxInputChallenge.
 */


import java.util.Scanner;

public class MinAndMaxInputChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        //  boolean first = true;
        while (true) {
            System.out.println("Enter number:");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt) {

                int number = scanner.nextInt();
//                if(first) {
//                    first = false;
//                    minNumber = number;
//                    maxNumber = number;
//                }
                if(number > maxNumber) {
                    maxNumber = number;
                }
                if(number < minNumber) {
                    minNumber = number;
                }

            } else {
                break;
            }

            scanner.nextLine(); // handle end of the line (enter key)

        }

        System.out.println("Minimum number is " + minNumber + " and maximum nubmer is " + maxNumber);

        scanner.close();

    }
}
