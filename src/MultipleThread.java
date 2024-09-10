import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

class NewThread2 implements Runnable{
    public Thread t;
    public String name;
    public int start;
    public int end;
    public int sum = 0;

    public NewThread2(String name, int start, int end)
    {
        this.name = name;
        this.start = start;
        this.end = end;
        t = new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
            for(int i=start;i<=end;i++)
            {
                sum+=i;
            }
    }
}
public class MultipleThread {
    public static void main(String[] args) {
        NewThread2 t1 = new NewThread2("One",1,25);
        NewThread2 t2 = new NewThread2("Two",26,50);
        NewThread2 t3 = new NewThread2("Three",51,75);
        NewThread2 t4 = new NewThread2("Four",76,100);
        System.out.println(t1.sum + t2.sum + t3.sum + t4.sum); // wrong output
    }
}
