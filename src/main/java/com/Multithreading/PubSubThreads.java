package com.Multithreading;

import java.util.*;

public class PubSubThreads {
    private static volatile int COUNTER = 0;
    private static final Queue<String> queue = new LinkedList<>();
    private static final int capacity = 10;

    public static void main(String... args) {
        Thread prdThd = new Thread(Publisher);
        Thread subThd = new Thread(Subscriber);
        prdThd.start();
        subThd.start();
        System.out.println("Main thread started");
    }

    private static final Runnable Publisher = new Runnable() {
        @Override
        public void run() {
            synchronized (queue) {
                while (COUNTER < 100) {
                    if (queue.size() == capacity) {
                        try {
                            queue.wait();
                            System.out.println("Queue is Full");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        queue.add("O");
                        System.out.println("Task added in Queue | Queue SIZE : " + queue.size());
                        queue.notifyAll();

                        try {
                            Thread.sleep(new Random().nextInt(100) + 100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    COUNTER++;
                    System.out.println("COUNTER : "+ COUNTER);
                }
            }
        }
    };
    public static final Runnable Subscriber = new Runnable() {
        @Override
        public void run() {
            synchronized (queue) {
                while (COUNTER < 100) {
                    if (queue.isEmpty()) {
                        try {
                            queue.wait();
                            System.out.println("Queue is Full");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        queue.remove();
                        System.out.println("Task Removed from Queue | Queue SIZE : " + queue.size());
                        queue.notifyAll();

                        try {
                            Thread.sleep(new Random().nextInt(100) + 100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    COUNTER++;
                    System.out.println("COUNTER : "+ COUNTER);
                }
            }
        }
    };

}
