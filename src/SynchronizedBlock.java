class BlockCounter{
    public void count()
    {
        synchronized (this){
            for(int i=0;i<20;i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            System.out.println(Thread.currentThread().getName() + " exiting");
        }
    }
    public void count2()
    {
            for(int i=0;i<20;i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            System.out.println(Thread.currentThread().getName() + " exiting");
    }
}
class NewThread5 implements Runnable{
    BlockCounter bc;
    Thread t;
    NewThread5(BlockCounter bc, String name)
    {
        this.bc = bc;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        bc.count();
    }
}
public class SynchronizedBlock {
    public static void main(String[] args) {
        BlockCounter bc = new BlockCounter();
        NewThread5 ob1 = new NewThread5(bc, "T1");
        NewThread5 ob2 = new NewThread5(bc, "T2");
        NewThread5 ob3 = new NewThread5(bc, "T3");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
