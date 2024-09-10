public class CreateThread4 {
    public static void main(String[] args) {
        CreateThread4 ct4 = new CreateThread4();
        new Thread(ct4::func, "T1").start();

        for (int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }

    void func()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}
