package watki.sumaTablicy;

public class MyThread extends Thread{
    private int[] tab;
    private int start;
    private int range;
    private int threadSum;
    
    public MyThread(int[] tab, int start, int range) {
        this.tab = tab;
        this.start = start;
        this.range = range;
    }

    @Override
    public void run() {
        for (int i = start; i < range; i++) {
            threadSum += tab[i];
        }
    }

    public int getThreadSum() {
        return threadSum;
    }
}
