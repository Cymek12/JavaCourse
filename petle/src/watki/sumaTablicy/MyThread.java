package watki.sumaTablicy;

public class MyThread implements Runnable{
    private int[] tab;
    private int start;
    private int range;
    private int threadSum;
    private static Integer sum = 0;
    private static final Object lock = new Object();
    
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
        synchronized (lock){
            sum += threadSum;
        }
    }


    public static int getThreadSum() {
        return sum;
    }
}
