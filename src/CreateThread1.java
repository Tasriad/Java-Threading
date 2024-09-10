public class CreateThread1 implements Runnable{
    private Thread t;
    private static int count = 0;

    public CreateThread1()
    {
        t = new Thread(this);
        count++;
        t.setName("Child Thread " + count);
        t.start();
    }
    @Override
    public void run() {
        try{
            for(int i=0;i<50;i++)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " exiting");
    }

    public static void main(String[] args) {
        new CreateThread1();
        new CreateThread1();
        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
