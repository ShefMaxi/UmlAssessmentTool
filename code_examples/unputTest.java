import java.io.*;

public class unputTest
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("test");
            PushbackInputStream pbin = new PushbackInputStream(
                    new FileInputStream("unputTest.java"));
            while (true)
            {
                int i = pbin.read();
                char b = (char) i;
                System.out.print(b);
                if (b == '{')
                    pbin.unread(i);
            }
        } catch (Exception e)
        {
        }

    }

}