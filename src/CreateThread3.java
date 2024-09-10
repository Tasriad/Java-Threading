

public class CreateThread3 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " : " +i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "interrupted.");
                }
            }
        });

        t.start();
        for (int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + "interrupted.");
            }
        }

    }
}
