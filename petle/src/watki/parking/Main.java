package watki.parking;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        int cars = 15;
        int maxSpots = 5;
        Semaphore parkingSpots = new Semaphore(maxSpots);
        ExecutorService executorService = Executors.newFixedThreadPool(cars);

        for (int i = 1; i <= cars; i++) {
            int car = i;
            executorService.execute(() -> {
                try {
                    System.out.println("samochod " + car + " probuje zaparkowac");
                    parkingSpots.acquire();  //blokuje watek dopoki nie zwolni sie miejsce
                    System.out.println("samochod " + car + " zaparkowal");

                    sleep(2500);

                    System.out.println("samochod " + car + " wyjezdza z parkingu");
                    parkingSpots.release(); //zwalnia miejsce
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        executorService.shutdown();
    }
}
