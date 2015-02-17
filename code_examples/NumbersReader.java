import java.io.*;

public class NumbersReader
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader infile = new BufferedReader(new FileReader(
                    "numbers.txt"));
            String s;
            while ((s = infile.readLine()) != null)
            {
                int n = Integer.parseInt(s);
                System.out.println(n);
            }
        } catch (FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
            System.out
                    .println("Run NumbersWriter first to create file numbers.txt");
            System.exit(1);
        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        } catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
            System.exit(1);
        }
    }
}
