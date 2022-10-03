package Threads;

import static Threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        // create thread as named class
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread ==");
        anotherThread.start();

        // create thread as anonymous class. It has to be start immediately
        new Thread() {
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous class thread.");
            }
        }.start();

        // create thread base on class which implements Runnable interface. Paste this class into constructor
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        // create thread base on anonymous class which implements Runnable interface
        Thread myRunnableAnonymousThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class`s implementation of run()");
                try{
                    // sleep, wake up after anotherTread will be terminated
                    // anotherThread.join();

                    // sleep, wake up after anotherTread will be terminated or after 2 seconds
                    anotherThread.join(2000);
                    System.out.println(ANSI_GREEN + "AnotherThread terminated or timed out, so I`m running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "I could`t wait after all. I was interrupted");
                }
            }
        });
        myRunnableAnonymousThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
