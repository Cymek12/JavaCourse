package watki.kolejka;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass = new SharedClass();
        
        Thread producent1 = new Thread(new MyThread(sharedClass, true));
        Thread konsument1 = new Thread(new MyThread(sharedClass, false));
        Thread konsument2 = new Thread(new MyThread(sharedClass, false));
        Thread konsument3 = new Thread(new MyThread(sharedClass, false));

        producent1.start();
        konsument1.start();
        konsument2.start();
        konsument3.start();

        producent1.join();
        konsument1.join();
        konsument2.join();
        konsument3.join();
    }
}

class SharedClass {
    private final Queue<Integer> queue;
    private int maxSize;

    public SharedClass() {
        this.queue = new LinkedList<>();
        this.maxSize = 5;
    }

    public void producer(int value){
        synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                queue.offer(value);
                System.out.println("Producent dodał: " + value);
                queue.notifyAll();
            }
    }
    
    public void consumer(){
        synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                int value = queue.poll();
                System.out.println("Konsument usunął: " + value);
                queue.notifyAll();
        }
    }
    
}


class MyThread implements Runnable {
    private final SharedClass sharedClass;
    private final boolean isProducer;
    private final int limit;

    public MyThread(SharedClass sharedClass, boolean isProducer) {
        this.sharedClass = sharedClass;
        this.isProducer = isProducer;
        this.limit = 30;
    }

    @Override
    public void run() {
        if (isProducer) {
            int value = 0;
            for (int i = 0; i < limit; i++) {
                sharedClass.producer(value++);
            }
        } 
        else {
            while (true) {
                sharedClass.consumer();
            }
        }
    }
}
   

