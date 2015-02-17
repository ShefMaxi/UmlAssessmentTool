// demonstrates nicer solution to dining philosophers' problem
// where there is a 'waiter' who judges whether each phil
// can start eating, so the chopsticks are allocated together
// rather than individually.
// Cannot deadlock 

import java.util.Set;
import java.util.HashSet;

public class Philosopher3 implements Runnable
{
    public Philosopher3(String name, String left, String right)
    {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    void startEating() throws InterruptedException
    {
        synchronized (eating)
        {
            while (eating.contains(left) || eating.contains(right))
                eating.wait();
            eating.add(name);
        }
    }

    void endEating() {
        synchronized (eating)
        {
            eating.remove(name);
            eating.notifyAll();
        }
    }

    public void run()
    {
        try {
            while (true)
            {
                // talking
                System.out.println(name + " is talking");
                Thread.sleep((int) (20 * Math.random()));
                // hungry -- pick up chopsticks
                System.out.println(name + " is hungry");
                startEating();
                // eating
                System.out.println(name + " is eating");
                Thread.sleep((int) (10 * Math.random()));
                // done 
                endEating();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during dinner - leaving the table");
        }
    }

    private String name, left, right;
    private static Set<String> eating = new HashSet<String>();

    public static void main(String[] args)
    {
        Philosopher3[] phils = new Philosopher3[] {
            new Philosopher3("Aristotle", "Descartes", "Epicurus"),
            new Philosopher3("Descartes", "Aristotle", "Epicurus"),
            new Philosopher3("Epicurus", "Descartes", "Aristotle")
        };

        // start them all going
        for (Philosopher3 phil: phils)
        {
            Thread thread = new Thread(phil);
            thread.start();
        }
    }
}
