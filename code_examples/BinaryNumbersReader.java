import java.io.*;

public class BinaryNumbersReader
{
    public static void main(String[] args)
    {
        DataInputStream din;
        try
        {
            din = new DataInputStream(new FileInputStream("numbers.dat"));
            while (true)
            {
                try
                {
                    int i = din.readInt();
                    System.out.println(i);
                } catch (EOFException eof)
                {
                    din.close();
                    break;
                }
            }
        } catch (FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
            System.out
                    .println("Run BinaryWriter first to create file numbers.dat");
            System.exit(1);
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
