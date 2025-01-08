package watki.kolejka;


public class MyThread implements Runnable {
    private final SharedClass sharedClass;
    private final boolean isProducer;

    public MyThread(SharedClass sharedClass, boolean isProducer) {
        this.sharedClass = sharedClass;
        this.isProducer = isProducer;
    }

    @Override
    public void run() {
        if (isProducer) {
            sharedClass.producer();
            sharedClass.setProductionFinished(true);
        }
        else {
            while (!sharedClass.isProductionFinished()) {
                sharedClass.consumer();
            }
        }
    }
}