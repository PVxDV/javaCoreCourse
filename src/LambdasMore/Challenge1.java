package LambdasMore;

public class Challenge1 {
    public static void main(String[] args) {
        /*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let`s split this up into array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        */

        Runnable runnable1 = () -> {
            String myString = "Let`s split this up into array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        new Thread(()-> {
            String myString = "Let`s split this up into array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        }).start();



    }
}
