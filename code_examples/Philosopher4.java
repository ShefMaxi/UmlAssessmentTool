// djistra's solution to the dining phils problem
// - not all phils select the chopsticks in the same order,
//   using a numbering of the chopsticks and then choosing the lowest
// cannot deadlock, but not very fair!

public class Philosopher4 implements Runnable
{
    public Philosopher4(String name, Integer left, Integer right)
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
                if (leftChopstick < rightChopstick)
                {
                    synchronized (leftChopstick) {
                        System.out.println(name + " has left chopstick");
                        synchronized (rightChopstick) {
                            // eating
                            System.out.println(name + " is eating");
                            Thread.sleep((int) (10 * Math.random()));
                            // done -- put chopsticks back down
                        }
                    }
                } else {
                    synchronized (rightChopstick) {
                        System.out.println(name + " has right chopstick");
                        synchronized (leftChopstick) {
                            // eating
                            System.out.println(name + " is eating");
                            Thread.sleep((int) (10 * Math.random()));
                            // done -- put chopsticks back down
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during dinner - leaving the table");
        }
    }

    private String name;
    private Integer leftChopstick;
    private Integer rightChopstick;

    public static void main(String[] args)
    {
        Integer[] chopsticks = new Integer[] { 1, 2, 3 };

        Philosopher4[] phils = new Philosopher4[] {
            new Philosopher4("Aristotle", chopsticks[0], chopsticks[1]),
            new Philosopher4("Descartes", chopsticks[1], chopsticks[2]),
            new Philosopher4("Epicurus", chopsticks[2], chopsticks[0])
        };

        // start them all going
        for (Philosopher4 phil: phils)
        {
            Thread thread = new Thread(phil);
            thread.start();
        }
    }
}
