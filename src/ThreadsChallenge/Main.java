package ThreadsChallenge;

public class Main {
    public static void main(String[] args) {
        final BankAccount bankAccount = new BankAccount(1000, "12345-678");

        // first variant to start threads
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                bankAccount.deposit(300.00);
//                bankAccount.withdraw(50.00);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                bankAccount.deposit(203.75);
//                bankAccount.withdraw(100.00);
//            }
//        }).start();

        //second variant to start threads
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                bankAccount.deposit(300.00);
                bankAccount.withdraw(50.00);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100.00);
            }
        };

        thread1.start();
        thread2.start();
    }
}
