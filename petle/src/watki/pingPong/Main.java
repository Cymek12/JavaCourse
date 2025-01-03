package watki.pingPong;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread("Ping"));
        Thread thread2 = new Thread(new MyThread("Pong"));

        thread1.start();
        sleep(500);
        thread2.start();
    }
}
