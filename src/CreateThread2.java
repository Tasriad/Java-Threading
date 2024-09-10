class NewThread implements Runnable{

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " exiting");
    }
}
public class CreateThread2{
    public static void main(String[] args) {
        Runnable r = new NewThread();
        Thread t = new Thread(r);
        t.start();
        for (int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
