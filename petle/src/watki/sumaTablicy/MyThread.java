package watki.sumaTablicy;

public class MyThread implements Runnable{
    private Long[] tab;
    private int start;
    private int range;
    private Long threadSum = 0L;
    private static Long sum = 0L;
    
    public MyThread(Long[] tab, int start, int range) {
        this.tab = tab;
        this.start = start;
        this.range = range;
    }

    @Override
    public void run() {
        for (int i = start; i < range; i++) {
            threadSum += tab[i];
        }
        synchronized (MyThread.class){
            sum += threadSum;
        }
    }


    public static Long getThreadSum() {
        return sum;
    }

    public static void resetThreadSum(){
        sum = 0L;
    }
}
