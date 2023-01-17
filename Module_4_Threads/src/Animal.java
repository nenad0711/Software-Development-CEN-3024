/**
 * @author Nenad Jovanovic
 * Class: COP 3330C OO Programming
 * Description: Working with Threads
 */

public class Animal implements Runnable{
    String name;
    int position;
    int restMax;
    int speed;
    static boolean winner = false;
    Food foo;

    public Animal(String name,int restMax,int speed,Food foo){
        this.name = name;
        this.restMax = restMax;
        this.speed = speed;
        this.foo = foo;
    }

    @Override
    public void run() {

        while (!winner) {
            position += speed;
            System.out.println(name + " on position: " + position);
            if (position >= 120) {
                winner = true;
                System.out.println(name + " is the winner!");
                break;
            }
                foo.eat();
            }
        }
// Main Method

    public static void main(String[] args) {
        Animal hare = new Animal("Hare",220,9,new Food());
        Animal tortoise = new Animal("Tortoise",165,5,new Food());
        Thread t1 = new Thread(hare);
        Thread t2 = new Thread(tortoise);
        t1.setName("Hare");
        t2.setName("Tortoise");
        t1.start();
        t2.start();
    }
}