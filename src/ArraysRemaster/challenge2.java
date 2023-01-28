package ArraysRemaster;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class challenge2 {
    public static void main(String[] args) {
        System.out.println(findMin(readIntegers()));
    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Please enter an integers, if you want to stop enter \"done\"");
        int count = 0;
        boolean flag = true;
        String s;
        while (flag){
            s = scanner.nextLine();
            if(s.equals("done")) {
                flag = false;
            } else {
                stringBuilder.append(s);
                stringBuilder.append(",");
                count++;
            }
        }
        String[] stringArray = stringBuilder.toString().split(",");
        int[] array = new int[count];
        for (int i = 0; i<count; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }

    private static int findMin(int[] array) {

        int min = Integer.MAX_VALUE;

        for (int j : array) {
            if (min > j) {
                min = j;
            }
        }
        return min;
    }

}
