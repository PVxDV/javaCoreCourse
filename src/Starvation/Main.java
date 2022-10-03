package Starvation;

import java.util.concurrent.locks.ReentrantLock;

import static Threads.ThreadColor.*;

public class Main {
    // for starvation simulation
    // private static Object lock = new Object();

    // solution - use reentrant lock with parameter true(Fair lock) = first come, first served for getting a lock
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1= new Thread(new Worker(ANSI_RED), "Priority 10");
        Thread t2= new Thread(new Worker(ANSI_BLUE), "Priority 8");
        Thread t3= new Thread(new Worker(ANSI_GREEN), "Priority 6");
        Thread t4= new Thread(new Worker(ANSI_CYAN), "Priority 4");
        Thread t5= new Thread(new Worker(ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t5.start();
        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }

    // for starvation simulation
//    private static class Worker implements Runnable {
//        private int runCount = 1;
//        private String threadColor;
//
//        public Worker(String threadColor) {
//            this.threadColor = threadColor;
//        }
//
//        @Override
//        public void run() {
//            for(int i=0; i<100;i++) {
//                synchronized (lock) {
//                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
//                    // execute critical section of code
//                }
//            }
//        }
//    }


    // solution - use reentrant lock with parameter true(Fair lock)
    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0; i<100;i++) {
                lock.lock();
                try{
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
