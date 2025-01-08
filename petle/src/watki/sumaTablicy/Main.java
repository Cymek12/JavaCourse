package watki.sumaTablicy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Long[] tab = new Long[10000000];
        int[] threads = {1, 2, 4, 8, 16};

        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1L;
        }

        for (int thread : threads) {
            MyThread.resetThreadSum();
            System.out.println("Wątki: " + thread);

            List<Thread> threadList = new ArrayList<>();
            int range = tab.length / thread;
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < thread; i++) {
                int start = i * range;
                int end = start + range;
                threadList.add(new Thread(new MyThread(tab, start, end)));

            }

            for (Thread thread1 : threadList) {
                thread1.start();
            }

            for (Thread thread1 : threadList) {
                thread1.join();
            }

            long endTime = System.currentTimeMillis();

            System.out.println("Suma: " + MyThread.getThreadSum());
            System.out.println("Czas: " + (endTime - startTime));
            System.out.println();
        }

    }
}
