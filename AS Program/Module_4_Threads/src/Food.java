/**
 * @author Nenad Jovanovic
 * Class: COP 3330C OO Programming
 * Description: Working with Threads
 */
import java.util.Random;

public class Food {

    public synchronized void eat() {
        int x;

        Random r = new Random();
        if(Thread.currentThread().getName().equals("Hare")){
            x = r.nextInt(0,220);
        }
        else{
            x = r.nextInt(0,165);
        }

        try {
            Thread.sleep(x);
            System.out.println(Thread.currentThread().getName() + " started eating.");
            System.out.println(Thread.currentThread().getName() + " is done eating.");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}