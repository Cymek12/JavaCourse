package watki.sumaTablicy;

public class Main {
    public static void main(String[] args) {
        int[] tab = new int[10];

        for (int i = 0; i < 10; i++) {
            tab[i] = i;
        }

        Thread thread1 = new Thread(new MyThread(tab));
        Thread thread2 = new Thread(new MyThread(tab));




    }
}
