package LambdasMore;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge2 {
    public static void main(String[] args) {

       // Supplier<String> iLoveJava = () -> "I love java!";

        Supplier<String> iLoveJava = () -> {
            return "I love java!";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


        System.out.println(lambdaFunction.apply("1234567890"));
        System.out.println(everySecondChar(lambdaFunction, "1234567890"));
    }

    /*
    public static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();

        for(int i=0; i< source.length(); i++) {
            if(i%2 ==1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }
    */

    public static String everySecondChar(Function<String, String> function, String string) {
        return function.apply(string);
    }

    public static Function<String, String> lambdaFunction = s -> {
        StringBuilder returnVal = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();
    };
}
