import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipNumbersReader
{
    public static void main(String[] args)
    {
        DataInputStream din;
        try
        {
            ZipInputStream zin = new ZipInputStream(new FileInputStream(
                    "morenumbers.zip"));
            while (zin.getNextEntry() != null)
            {
                din = new DataInputStream(zin);
                while (true)
                {
                    try
                    {
                        int i = din.readInt();
                        System.out.println(i);
                    } catch (EOFException eof)
                    {
                        break;
                    }
                }
            }
            zin.close();
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
