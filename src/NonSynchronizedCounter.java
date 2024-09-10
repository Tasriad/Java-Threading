class SharedCounter {
    private int counter;

    public SharedCounter()
    {
        this.counter = 0;
    }
    public int getCounter()
    {
        return this.counter;
    }
    public void increment()
    {
        counter++;
    }
    public void nonsynccount()
    {
        for (int i=0;i<20;i++)
        {
            increment();
            System.out.println(Thread.currentThread().getName() + " : " + counter);
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
    public synchronized void synccount()
    {
        for (int i=0;i<20;i++)
        {
            increment();
            System.out.println(Thread.currentThread().getName() + " : " + counter);
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
class NewThread3 implements Runnable{
    SharedCounter sharedCounter;
    Thread t;
    public NewThread3(SharedCounter s, String name)
    {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        sharedCounter.nonsynccount();
    }
}
public class NonSynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        NewThread3 ob1 = new NewThread3(sharedCounter, "T1");
        NewThread3 ob2 = new NewThread3(sharedCounter, "T2");
        try {
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(sharedCounter.getCounter());
    }
}
