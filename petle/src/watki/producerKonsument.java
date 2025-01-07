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

public class SharedClass {
    private final Queue<Integer> queue;
    private final int maxSize;
    private final int limit;
    private boolean productionFinished = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SharedClass() {
        this.queue = new LinkedList<>();
        this.maxSize = 5;
        this.limit = 30;
    }

    public void producer(){
        lock.lock();
        int value = 0;
        for (int i = 0; i < limit; i++) {
            while (queue.size() == maxSize) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            queue.offer(value++);
            System.out.println("Dodano: " + (value - 1));
            condition.signal();
        }
        lock.unlock();
    }

    public void consumer(){
        lock.lock();
        while (queue.isEmpty()) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        int value = queue.poll();
        System.out.println("Usunięto: " + value);
        condition.signal();
        lock.unlock();
    }

    public void setProductionFinished(boolean productionFinished) {
        this.productionFinished = productionFinished;
    }

    public boolean isProductionFinished() {
        return productionFinished;
    }
}


public class MyThread implements Runnable {
    private final SharedClass sharedClass;
    private final boolean isProducer;

    public MyThread(SharedClass sharedClass, boolean isProducer) {
        this.sharedClass = sharedClass;
        this.isProducer = isProducer;
    }

    @Override
    public void run() {
        if (isProducer) {
            sharedClass.producer();
            sharedClass.setProductionFinished(true);
        }
        else {
            while (!sharedClass.isProductionFinished()) {
                sharedClass.consumer();
            }
        }
    }
}
   

