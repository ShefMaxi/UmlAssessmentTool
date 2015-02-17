import java.io.*;

public class HelloWorld
{
    public static void main(String[] args)
    {
        try
        {
            PrintWriter outfile = new PrintWriter(new FileWriter("hello.txt"));
            outfile.println("Hello world");
            outfile.close();
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
