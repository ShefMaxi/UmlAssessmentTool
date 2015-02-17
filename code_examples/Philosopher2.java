// demonstrates naive solution to dining philosophers' problem
// will deadlock if given long enough
// equivalent to Philosopher.java, just using wait/notify

class Chopstick
{
    synchronized void get() throws InterruptedException
    {
        while (taken)
            wait();
        taken = true;
    }

    synchronized void put()
    {
        taken = false;
        notifyAll();
    }

    private boolean taken = false;
}

public class Philosopher2 implements Runnable
{
    public Philosopher2(String name, Chopstick left, Chopstick right)
    {
        this.name = name;
        leftChopstick = left;
        rightChopstick = right;
    }

    public void run()
    {
        try {
            while (true)
            {
                // talking
                System.out.println(name + " is talking");
                Thread.sleep((int) (20 * Math.random()));
                // hungry
                System.out.println(name + " is hungry");
                leftChopstick.get();
                System.out.println(name + " has left chopstick");
                rightChopstick.get();
                // eating
                System.out.println(name + " is eating");
                Thread.sleep((int) (10 * Math.random()));
                // done
                leftChopstick.put();
                rightChopstick.put();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during dinner - leaving the table");
        }
    }

    private String name;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public static void main(String[] args)
    {
        Chopstick[] chopsticks = new Chopstick[] { 
            new Chopstick(), new Chopstick(), new Chopstick()
        }; 

        Philosopher2[] phils = new Philosopher2[] {
            new Philosopher2("Aristotle", chopsticks[0], chopsticks[1]),
            new Philosopher2("Descartes", chopsticks[1], chopsticks[2]),
            new Philosopher2("Epicurus", chopsticks[2], chopsticks[0])
        };

        // start them talking/eating etc
        for (Philosopher2 phil: phils)
            new Thread(phil).start();
    }
}
