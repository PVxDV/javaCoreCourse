package ThreadsChallenge;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    // third way to synchronize operations with ReentrantLock
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    // first way to synchronize operations with keyword "synchronize"
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    // second way to synchronize operations with keyword "synchronize"
//    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

    // third way to synchronize operations with ReentrantLock with using method lock()
//    public void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

//    // forth way to synchronize operations with ReentrantLock with using method tryLock()
//    public void deposit(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                try {
//                    balance += amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public void withdraw(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                try {
//                    balance -= amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }

    // Six challenge. We add a status variable
    public void deposit(double amount) {

        boolean status = false;

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {

        boolean status = false;

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Transaction status = " + status);
    }

    // don`t need synchronization because this method only read and not update fields
    public String getAccountNumber() {
        return accountNumber;
    }

    // don`t need synchronization because this method only read and not update fields
    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
