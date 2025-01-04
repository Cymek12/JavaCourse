package watki.sumaTablicy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tab = new int[1000];
        int threads = 2;

        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1;

        }

//        Thread thread1 = new Thread(new MyThread(tab, 0, 500));
//        Thread thread2 = new Thread(new MyThread(tab, 500, 1000));

        MyThread myThread1 = new MyThread(tab, 0, 500);
        MyThread myThread2 = new MyThread(tab, 500, 1000);

        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();

        int sum = myThread1.getThreadSum() + myThread2.getThreadSum();
        System.out.println(sum);


    }
}
