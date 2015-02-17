import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipNumbersWriter
{
    public static void main(String[] args)
    {
        int[] somePrimes = {29, 31, 37, 41, 43, 47, 53, 59, 61};
        try
        {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(
                    "morenumbers.zip"));
            ZipEntry ze = new ZipEntry("morenumbers.dat");
            zout.putNextEntry(ze);
            DataOutputStream dout = new DataOutputStream(zout);
            for (int i = 0; i < somePrimes.length; i++)
            {
                dout.writeInt(somePrimes[i]);
            }
            zout.closeEntry();
            zout.close();
        } catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
