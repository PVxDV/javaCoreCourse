package ArraysRemaster;

import java.util.Arrays;
import java.util.Random;

public class challenge {
    public static void main(String[] args) {
        int[] intArray = randomArrayGenerator();
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(sortAndReverse(intArray)));
    }

//    private static int[] sortAndReverse(int[] inputArray) {
//        int[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
//        Arrays.sort(sortedArray);
//
//        int[] result = new int[sortedArray.length];
//        for (int i = 0; i < sortedArray.length; i++) {
//            result[i] = sortedArray[sortedArray.length - i - 1];
//        }
//        return result;
//    }

    private static int[] sortAndReverse(int[] inputArray) {
        int[] array = Arrays.copyOf(inputArray, inputArray.length);
        int temp;
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i=0; i<array.length-1; i++){
                if(array[i] < array[i+1]) {
                    temp = array [i];
                    array[i] = array [i+1];
                    array [i+1] = temp;
                    flag = true;
                }
            }
        }

        return array;
    }


    private static int[] randomArrayGenerator() {
        Random random = new Random();
        int[] array = new int[random.nextInt(20)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
