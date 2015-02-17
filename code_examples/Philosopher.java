// demonstrates naive solution to dining philosophers' problem
// will deadlock if given long enough

public class Philosopher implements Runnable
{
    public Philosopher(String name, Object left, Object right)
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
                // hungry -- pick up chopsticks
                System.out.println(name + " is hungry");
                synchronized (leftChopstick) {
                    System.out.println(name + " has left chopstick");
                    synchronized (rightChopstick) {
                        // eating
                        System.out.println(name + " is eating");
                        Thread.sleep((int) (10 * Math.random()));
                        // done -- put chopsticks back down
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during dinner - leaving the table");
        }
    }

    private String name;
    private Object leftChopstick;
    private Object rightChopstick;

    public static void main(String[] args)
    {
        Integer[] chopsticks = new Integer[] { 1, 2, 3 };

        Philosopher[] phils = new Philosopher[] {
            new Philosopher("Aristotle", chopsticks[0], chopsticks[1]),
            new Philosopher("Descartes", chopsticks[1], chopsticks[2]),
            new Philosopher("Epicurus", chopsticks[2], chopsticks[0])
        };

        // start them all going
        for (Philosopher phil: phils)
        {
            Thread thread = new Thread(phil);
            thread.start();
        }
    }
}
