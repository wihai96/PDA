public class App {

    static int[] coada = new int[10];
    static final int SIZE = 10;
    static int count = 0;

    public static void main(String[] args)
    {
        final Producer producator = new Producer();
        final Consumer consumator = new Consumer();

        Runnable producer = new Runnable() {
            @Override
            public void run()
            {
                for (int i = 0; i < 3; i++) {
                    producator.produce();
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    consumator.consume();
                }
            }
        };

            Thread producerThread = new Thread(producer);
            Thread consumerThread = new Thread(consumer);

            producerThread.start();
            consumerThread.start();
    }
}

