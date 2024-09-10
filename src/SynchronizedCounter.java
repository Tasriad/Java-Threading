class NewThread4 implements Runnable{
    SharedCounter sharedCounter;
    Thread t;
    public NewThread4(SharedCounter s, String name)
    {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        sharedCounter.synccount();
    }
}
public class SynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        NewThread4 ob1 = new NewThread4(sharedCounter, "T1");
        NewThread4 ob2 = new NewThread4(sharedCounter, "T2");
        try {
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(sharedCounter.getCounter());
    }
}
