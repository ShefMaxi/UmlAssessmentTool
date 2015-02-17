import java.util.Random;

// illustration of exception-handling
// The example is stimulated by the novel "Anna of the Five Towns"
// by Arnold Bennett. Bennett, though one of England's greatest
// writers of the early 20th century, was wrong about the number
// of towns that constituted his home city (Stoke-on-Trent). The
// author of the code spent much of his early life in the one that
// was missed out, hence this code....

// The example is rather artificial, but illustrates most aspects of
// exception-handling. One of two possible exceptions is thrown in 
// method1. The exceptions are caught non-locally (here, in the main
// method, and are handled separately dependent on which exception
// was thrown.

public class FiveTowns
{

    public static void method1()
    {
        String[] fiveTowns = new String[5];
        Random r = new Random();
        int divisor = 1;
        if (r.nextGaussian() > 0)
            divisor = 0;
        double x = 1 / divisor;
        fiveTowns[0] = "Tunstall";
        fiveTowns[1] = "Burslem";
        fiveTowns[2] = "Hanley";
        fiveTowns[3] = "Stoke";
        fiveTowns[4] = "Fenton";
        fiveTowns[5] = "Longton";
    }

    public static void main(String[] args)
    {

        try
        {
            method1();
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Arnold Bennett was wrong");
        } catch (ArithmeticException e)
        {
            System.out.println("Divide by zero");
            e.printStackTrace();
        }
    }
}
