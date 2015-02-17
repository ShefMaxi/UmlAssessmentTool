import java.io.*;

public class BinaryNumbersWriter
{
    public static void main(String[] args)
    {
        int[] somePrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        try
        {
            DataOutputStream dout = new DataOutputStream(new FileOutputStream(
                    "numbers.dat"));
            for (int i = 0; i < somePrimes.length; i++)
            {
                dout.writeInt(somePrimes[i]);
            }
            dout.close();
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
