package ControlFlowStatements;

public class Sum3and5Challenge{
    public static void main(String[] args) {
        int count = 0;
        int sumOfNumbers = 0;
        for(int i = 1; i < 1001; i++) {
            if( (i % 3 == 0) && (i % 5 == 0)) {
                count++;
                sumOfNumbers += i;
                System.out.println("Found number = " + i);
                if(count == 5) {
                    break;
                }
            }
        }
        System.out.println("Sum = " + sumOfNumbers);
    }
}
