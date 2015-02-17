import java.io.*;

public class OfficeReader
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader infile = new BufferedReader(new FileReader(
                    "office.txt"));
            String s;
            while ((s = infile.readLine()) != null)
            {
                System.out.println(s);
            }
        } catch (FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
            System.out
                    .println("Run OfficeWriter first to create file office.txt");
            System.exit(1);
        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        }
    }
}
