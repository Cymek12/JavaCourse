package watki.sumaTablicy;

public class MyThread implements Runnable{
    private int[] tab;
    private int start;
    private int end;
    private int threadSum;


    public MyThread(int[] tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        System.out.println();
    }

    public int getThreadSum() {
        return threadSum;
    }
}
