package watki.sumaTablicy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tab = new int[1000];
        int sum = 0;

        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1;

        }

        Thread thread1 = new Thread(new MyThread(tab, 0, 500));
        Thread thread2 = new Thread(new MyThread(tab, 500, 1000));


        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(MyThread.getThreadSum());



    }
}
