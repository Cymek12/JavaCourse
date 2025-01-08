package watki.kolejka;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass = new SharedClass();

        Thread producent1 = new Thread(new MyThread(sharedClass, true));
        Thread konsument1 = new Thread(new MyThread(sharedClass, false));
        Thread konsument2 = new Thread(new MyThread(sharedClass, false));
        Thread konsument3 = new Thread(new MyThread(sharedClass, false));

        producent1.start();
        konsument1.start();
        konsument2.start();
        konsument3.start();

        producent1.join();
        konsument1.join();
        konsument2.join();
        konsument3.join();
    }
}





