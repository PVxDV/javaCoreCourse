package ControlFlowStatements;

public class TheForStatement {

    public static void main(String[] args) {

      /*  System.out.println("10,000 at 2% interest = " +
                calculateInterest(10000.0,2.0));
        System.out.println("10,000 at 3% interest = " +
                calculateInterest(10000.0,3.0));
        System.out.println("10,000 at 4% interest = " +
                calculateInterest(10000.0,4.0));
        System.out.println("10,000 at 5% interest = " +
                calculateInterest(10000.0,5.0));*/

        for(int i = 0; i < 5; i++){
            System.out.println("Loop " + i + " hello!");
        }

        for(double i = 2.0; i < 9.0; i++) {
            System.out.println("10,000 at " + i + "% interest = " +
                    String.format("%.2f",calculateInterest(10000.0,i)));
        }

        for(int i = 8; i > 1 ; i-- ) {
            System.out.println("10,000 at " + i + "% interest = " +
                    String.format("%.2f",calculateInterest(10000.0,i)));
        }

        int score = 0;

        for(int i = 10; i < 50; i++) {
            if(isPrime(i)) {
                System.out.println("This is a prime number " + i);
                score++;
                if(score==7) {
                    break;
                }
            }
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return(amount * (interestRate/100));
    }

    public static boolean isPrime(int n) {

        if(n == 1) {
            return false;
        }

        for(int i=2; i <= (long) Math.sqrt(n); i++) {
            System.out.println("Looping " + i);
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
