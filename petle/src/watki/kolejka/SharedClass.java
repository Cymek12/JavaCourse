package watki.kolejka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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