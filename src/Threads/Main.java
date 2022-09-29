package Threads;

import static Threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        // create thread as named class
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        // create thread as anonymous class. It has to be start immediately
        new Thread() {
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous class thread.");
            }
        }.start();



        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
