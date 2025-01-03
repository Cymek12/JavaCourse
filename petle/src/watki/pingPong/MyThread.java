package watki.pingPong;

import static java.lang.Thread.sleep;

public class MyThread implements Runnable{
    private String action;

    public MyThread(String action) {
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(action);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
