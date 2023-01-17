import java.util.Random;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

// TESTTING THREADS WITH PRIORITY ADDED

/**public class TestThread extends JFrame {
    JLabel counter1Label = new JLabel("Priority 10");
    JLabel counter2Label = new JLabel("Priority 1");

    class CounterThread extends Thread {
        JLabel counterLabel;

        public CounterThread(JLabel counterLabel) {
            super();
            this.counterLabel = counterLabel;
        }
        public void run() {
            int count = 0;
            while (true) {
                try {
                    sleep(1);
                }
                catch (InterruptedException e) {
                }
                if (count == 50000)
                    count = 0;
                counterLabel.setText(Integer.toString(count++));
            }
        }
    }
    public TestThread(String title) {
        super(title);
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(counter1Label);
        this.add(counter2Label);
        this.pack();
        this.setVisible(true);
        CounterThread thread1 = new CounterThread(counter1Label);
        thread1.setPriority(10);
        CounterThread thread2 = new CounterThread(counter2Label);
        thread2.setPriority(1);
        thread2.start();
        thread1.start();
    }
    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        TestThread frame = new TestThread(
                "Thread Priority Test");
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}
*/












public class TestThread implements Runnable {
 String name;
 int time;
 Random r = new Random();


   public TestThread(String x) {
 name = x;

 }
 @Override
    public void run() {
     for(int j =0;j<5;j++) {
         time = r.nextInt(1000);
         System.out.printf("%s is sleeping for %d\n", name, time);
         try {
             Thread.sleep(time);
         } catch (InterruptedException e) {

             e.printStackTrace();
         }
     }
       System.out.printf("%s is done sleeping\n", name);
 }

 public static void main(String[] args) {
        TestThread t = new TestThread("My Thread");
        Thread t5 = new Thread(t);
        t5.start();
        

 }



}

