import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ThreadTest3 extends Thread{
    public void run() {
        for(int i = 1;i<=10;i++) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}