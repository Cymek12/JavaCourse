package watki.cwiczenia.zad1;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread(0));
        Thread thread2 = new Thread(new MyThread(1));

        thread1.start();
        sleep(500);
        thread2.start();

    }
}
