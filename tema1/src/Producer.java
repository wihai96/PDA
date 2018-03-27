public class Producer
{
    public synchronized void produce()
    {
        int value = 8;

        if (App.count > 10) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        App.coada[App.count++] = value; // Produced
        notify(); // Notify the consumers which are waiting
    }
}