import java.io.*;

public class NumbersWriter
{
    public static void main(String[] args)
    {
        try
        {
            PrintWriter outfile = new PrintWriter(new FileWriter("numbers.txt"));
            outfile.println(100);
            outfile.println(101);
            outfile.println(102);
            outfile.println(103);
            outfile.close();
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
