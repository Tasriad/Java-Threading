class NewThread6 implements Runnable{
    BlockCounter bc;
    Thread t;
    NewThread6(BlockCounter bc, String name)
    {
        this.bc = bc;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        synchronized (bc){
            bc.count2();
        }
    }
}
public class SynchronizedStatement {
    public static void main(String[] args) {
        BlockCounter bc = new BlockCounter();
        NewThread6 ob1 = new NewThread6(bc, "T1");
        NewThread6 ob2 = new NewThread6(bc, "T2");
        NewThread6 ob3 = new NewThread6(bc, "T3");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
