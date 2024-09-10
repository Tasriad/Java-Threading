public class ThreadJoin {
    public static void main(String[] args) {
        NewThread2 t1 = new NewThread2("One",1,25);
        NewThread2 t2 = new NewThread2("Two",26,50);
        NewThread2 t3 = new NewThread2("Three",51,75);
        NewThread2 t4 = new NewThread2("Four",76,100);

        try {
            //wait for other threads to end
            t1.t.join();
            t2.t.join();
            t3.t.join();
            t4.t.join();
        }catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println(t1.sum + t2.sum + t3.sum + t4.sum);
    }
}
