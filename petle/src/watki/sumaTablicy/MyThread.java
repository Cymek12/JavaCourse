package watki.sumaTablicy;

public class MyThread implements Runnable{
    private int[] tab;


    public MyThread(int[] tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        System.out.println();
    }
}
