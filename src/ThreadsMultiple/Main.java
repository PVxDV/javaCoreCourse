package ThreadsMultiple;

import static Threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();


        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i;
    // add synchronized key word to prevent race condition (first method)
    // public synchronized void doCountdown(){
    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ANSI_CYAN;
                break;
            case "Thread 2":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }

        // add synchronized key word to prevent race condition (first method)
        synchronized (this) {
            for(i = 10; i>0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }


    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
       threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}