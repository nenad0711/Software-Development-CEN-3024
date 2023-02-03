
public class ThreadTest extends Thread {
    int n;

    public ThreadTest(int x) {

        n=x;
    }

    @Override
    public void run() {
        for(int i =1;i<=5;i++) {
            System.out.println(i +" Thread "+n);

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<=5;i++) {
            ThreadTest thread = new ThreadTest(i);
            thread.start();
            try {
                thread.join();
            }
            catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}




/**public static void main(String[] args) {
 Thread t1 = new Thread (new TestThread("one"));
 Thread t2 = new Thread (new TestThread("two"));
 Thread t3 = new Thread (new TestThread("three"));
 Thread t4 = new Thread (new TestThread("four"));
 t1.start();
 t2.start();
 t3.start();
 t4.start();

 }

 }*/

