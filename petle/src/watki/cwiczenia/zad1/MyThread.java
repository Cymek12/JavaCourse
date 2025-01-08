package watki.cwiczenia.zad1;

import static java.lang.Thread.sleep;

public class MyThread implements Runnable{
    private int x;

    public MyThread(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = this.x; i <= 10; i += 2) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
