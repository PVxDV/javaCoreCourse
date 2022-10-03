package ProducerConsumer;

import Threads.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;
import static Threads.ThreadColor.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        // Array List is not thread save we have to do some synchronization
        //List<String> buffer = new ArrayList<>();

        // Also we can use Thread Save ArrayBlockingQueue
        // We don`t need buffer lock anymore
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        // create instance of reentrant lock
        // ReentrantLock bufferLock = new ReentrantLock();

        // make a thread pool. we pass number of active threads at the same time as a parameter, others threads will be waiting, while that threads will be terminated
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // MyProducer producer = new MyProducer(buffer, ANSI_YELLOW, bufferLock);
        // MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE, bufferLock);
        // MyConsumer consumer2 = new MyConsumer(buffer, ANSI_CYAN, bufferLock);

        // classic start of threads
        // new Thread(producer).start();
        // new Thread(consumer1).start();
        // new Thread(consumer2).start();

        // start as a thread pool with executor service
        // executorService.execute(producer);
        // executorService.execute(consumer1);
        // executorService.execute(consumer2);

        // start as a thread pool with executor service with anonymous threads
        executorService.execute(new MyProducer(buffer, ANSI_YELLOW));
        executorService.execute(new MyConsumer(buffer, ANSI_PURPLE));
        executorService.execute(new MyConsumer(buffer, ANSI_CYAN));

        // If we need to return value from a thread, we can use submit method
        // Callable object very similar to a Runnable object, except that it can return a value.
        // Value can be returned as an object of type Future
        // In that example we use anonymous Callable class
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_WHITE + "I`m being printed for the Callable class");
                return "This is the callable result";
            }
        });

        // to get the result we need to call the future.get method
        // when we`re calling it from the main thread, our application will be frozen into the results available
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // NOTE! if we start as thread pool, app will be still alive, after all threads will be terminated, we have to terminate app manually by .shutdown method
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    // for synchronizing by entity of ReentrantLock  or by keyword "synchronized"
    //private List<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    // for synchronizing by entity of ReentrantLock  or by keyword "synchronized"
    //public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
    //    this.buffer = buffer;
    //    this.color = color;
    //    this.bufferLock = bufferLock;
    //}

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


// synchronized by keyword "synchronized"
//    public void run() {
//        Random random = new Random();
//        String[] nums = {"1", "2", "3", "4", "5"};
//
//        for(String num: nums) {
//            try {
//                System.out.println(color + "Adding..." + num);
//                synchronized (buffer){
//                    buffer.add(num);
//                }
//                Thread.sleep(random.nextInt(1000));
//            } catch (InterruptedException e) {
//                System.out.println("Producer was interrupted.");
//            }
//        }
//        System.out.println(color + "Adding EOF and exiting...");
//        synchronized (buffer){
//            buffer.add(EOF);
//        }
//    }

    // synchronized by entity of ReentrantLock
//    public void run() {
//        Random random = new Random();
//        String[] nums = {"1", "2", "3", "4", "5"};
//
//        for (String num : nums) {
//            try {
//                System.out.println(color + "Adding..." + num);
//                bufferLock.lock();
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }
//                Thread.sleep(random.nextInt(1000));
//            } catch (InterruptedException e) {
//                System.out.println("Producer was interrupted.");
//            }
//        }
//
//        System.out.println(color + "Adding EOF and exiting...");
//        bufferLock.lock();
//        try {
//            buffer.add(EOF);
//        } finally {
//            bufferLock.unlock();
//        }
//    }

    // synchronized by using Thread Save ArrayBlockingQueue
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    // for synchronizing by entity of ReentrantLock  or by keyword "synchronized"
    // private List<String> buffer;
    private String color;
    // private ReentrantLock bufferLock;

    // for synchronizing by entity of ReentrantLock  or by keyword "synchronized"
    // public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
    //     this.buffer = buffer;
    //     this.color = color;
    //     this.bufferLock = bufferLock;
    // }

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


// synchronized by keyword "synchronized"
//    public void run() {
//        while (true) {
//            synchronized (buffer){
//                if(buffer.isEmpty()) {
//                    continue;
//                }
//                if(buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    break;
//                } else {
//                    System.out.println(color + "Removed " + buffer.remove(0));
//                }
//            }
//        }
//    }

    // synchronized by entity of ReentrantLock
//    public void run() {
//        int counter = 0;
//
//        while (true) {
//            if(bufferLock.tryLock()){
//                try {
//                    if (buffer.isEmpty()) {
//                        continue;
//                    }
//                    System.out.println(color + "The counter =" + counter);
//                    counter=0;
//                    if (buffer.get(0).equals(EOF)) {
//                        System.out.println(color + "Exiting");
//                        break;
//                    } else {
//                        System.out.println(color + "Removed " + buffer.remove(0));
//                    }
//                } finally {
//                    bufferLock.unlock();
//                }
//            } else {
//                counter++;
//            }
//        }
//    }

    // synchronized by using Thread Save ArrayBlockingQueue
    public void run() {

        while (true) {
            // we still need synchronized block because thread may be suspended after .isEmpty and then try to peek empty Queue
            synchronized (buffer){
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}