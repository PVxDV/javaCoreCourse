package AutoboxingRemasted;

import LinkedListRemaster.Challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15); // preferred but unnecessary
        Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9
        int unboxedInt = boxedInt.intValue(); // unnecessary

        //Automatic
        Integer autoboxed = 15;
        int autoUnboxed = autoboxed;

        System.out.println(autoboxed.getClass().getName());
       // System.out.println(autoUnboxed.getClass().getName());

        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrappedArray = new Integer[5];
        wrappedArray[0] = 50;
        System.out.println(Arrays.toString(wrappedArray));

        System.out.println(wrappedArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        System.out.println(getList(1,2,3,4,5));


    }

    private static ArrayList<Integer> getList(int... varargs) {
        var aList = new ArrayList<Integer>();
        for (int i: varargs) {
            aList.add(i);
        }
        return aList;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.0;
    }

}
