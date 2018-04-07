import java.util.concurrent.Semaphore;
 
class MyStack
{
    int item;

    static Semaphore semaphore = new Semaphore(3);
     
    void get()
    {
        try {
            semaphore.acquire();
        } 
        catch(InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        
        System.out.println("Consumer consumed item : " + item);
        
        semaphore.release();
    }

    void put(int item)
    {
        try {
            semaphore.acquire();
        } catch(InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.item = item;
         
        System.out.println("Producer produced item : " + item);

        semaphore.release();
    }
}

class Producer implements Runnable
{
    MyStack myStack;
    Producer(MyStack myStack {
        this.myStack = myStack;
        new Thread(this, "Producer").start();
    }
     
    public void run() {
        for(int i=0; i < 5; i++) 
            myStack.put(i);
    }
}

class Consumer implements Runnable
{
    MyStack myStack;
    Consumer(MyStack myStack){
        this.myStack = myStack;
        new Thread(this, "Consumer").start();
    }
     
    public void run()
    {
        for(int i=0; i < 5; i++) 
            q.get();
    }
}
 
class Application
{
    public static void main(String args[]) 
    {
        MyStack myStack = new MyStack();

        new Consumer(myStack);

        new Producer(myStackq);
    }
}