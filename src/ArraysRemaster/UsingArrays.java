package ArraysRemaster;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class UsingArrays {
    public static void main(String[] args) {

        // Arrays.sort() - method
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        System.out.println("\n" + "=".repeat(15) + "\n");

        // Arrays.fill() - method
        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        System.out.println("\n" + "=".repeat(15) + "\n");

        // Arrays.copy() - method
        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));

        int[] largeArray = Arrays.copyOf(thirdArray, 20);
        System.out.println(Arrays.toString(largeArray));

        System.out.println("\n" + "=".repeat(15) + "\n");

        // Finding match
        // Arrays.binarySearch
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray, "Mark") >=0) {
            System.out.println("Found Mark in the list");
        }

        System.out.println("\n" + "=".repeat(15) + "\n");

        // Arrays.equals()
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};

        if(Arrays.equals(s1,s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }





    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i=0; i< newInt.length; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
