package watki.cwiczenia.zad2;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread("thread1"));
        Thread thread2 = new Thread(new MyThread("thread2"));
        Thread thread3 = new Thread(new MyThread("thread3"));

        thread1.start();
        sleep(500);
        thread2.start();
        sleep(500);
        thread3.start();
    }
}
