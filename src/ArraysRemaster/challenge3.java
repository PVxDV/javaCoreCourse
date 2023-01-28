package ArraysRemaster;

import java.util.Arrays;

public class challenge3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverse(array)));

        System.out.println("\n" + "=".repeat(20) + "\n");

        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(reverseEffective(array1)));

        System.out.println("\n" + "=".repeat(20) + "\n");

        int[] array2 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(reverseEffective(array2)));

        System.out.println("\n" + "=".repeat(20) + "\n");

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(reverseSolution(array1)));

        System.out.println("\n" + "=".repeat(20) + "\n");

        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(reverseSolution(array2)));
    }

    private static int[] reverse(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    private static int[] reverseEffective(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int j = result.length / 2 - 1;
        int temp;
        if (result.length % 2 == 0) {
            for (int i = result.length / 2; i < result.length; i++, j--) {
                temp = result[i];
                result[i] = result[j];
                result[j] = temp;
            }
        } else {
            for (int i = result.length / 2 + 1; i < result.length; i++, j--) {
                temp = result[i];
                result[i] = result[j];
                result[j] = temp;
            }
        }
        return result;
    }

    private static int[] reverseSolution (int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        int temp;

        for (int i = 0; i < halfLength; i++){
            temp = array[i];
            array[i] = array[maxIndex-i];
            array[maxIndex-i] = temp;
        }
        return array;
    }
}
