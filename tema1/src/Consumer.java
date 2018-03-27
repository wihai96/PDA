public class Consumer {

    public synchronized void consume()
    {
        if (App.count > 10) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // sterg element
        for(int i=0; i<App.count-1; i++){
            App.coada[i] = App.coada[i+1];
            App.count--;
        }

        notify(); // Notify the producers which are waiting.
    }

}
