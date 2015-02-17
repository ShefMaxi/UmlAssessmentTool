import java.io.*;

public class OfficeWriter
{
    public static void main(String[] args)
    {
        String name = "Martin Cooke";
        int officeNum = 141;
        try
        {
            // open using append and autoflush modes
            PrintWriter outfile = new PrintWriter(new FileWriter("office.txt",
                    true), true);
            outfile.print(name);
            outfile.print(": ");
            outfile.println(officeNum);
            outfile.close();
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
