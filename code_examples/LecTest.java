import java.io.*;
import java.util.*;

/**
 * class <code>LecTest</code> - testing wrapper for data storage example using
 * text files and string tokenization, fixed length strings, random access files
 * and object serialization
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2001-02-02 16:50:59 GMT (sjr)>
 * 
 */
public class LecTest
{

    /**
     * main method to test storage and retireval, including object serialization
     * 
     * @param args
     *            not used
     */
    public static void main(String[] args)
    {

        System.out.println("Create a lecturer and store data in text format");
        Lecturer lec = new Lecturer("Renals", "Steve", "sjr", 21836, 105, 3.12);
        System.out.println(lec);
        try
        {
            PrintWriter outfile = new PrintWriter(new FileWriter("lec.txt"));
            lec.writeData(outfile);
            // this would do the same thing
            // outfile.println(lec);
            outfile.close();

        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        }

        System.out.println("Read and parse the text format data");
        try
        {
            Lecturer lec2 = new Lecturer(new BufferedReader(new FileReader(
                    "lec.txt")));
            System.out.println(lec2);
        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        }

        System.out.println("Now test writing out data in binary format");
        Vector staff = new Vector();
        staff.add(new Lecturer("Renals", "Steve", "sjr", 21836, 105, 3.12));
        staff.add(new Lecturer("Brown", "Guy", "guy", 21821, 145, 3.25));
        staff.add(new Lecturer("Gotoh", "Yoshi", "yg", 21908, 115, 2.5));
        for (int i = 0; i < staff.size(); i++)
            System.out.println(staff.get(i));

        try
        {
            DataOutputStream staffout = new DataOutputStream(
                    new FileOutputStream("staff.dat"));
            for (int i = 0; i < staff.size(); i++)
                ((Lecturer) (staff.get(i))).writeBinaryData(staffout);
            staffout.close();
        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        }

        System.out.println("Now test random access to the binary file");
        Vector reverseStaff = new Vector();
        try
        {
            RandomAccessFile staffin = new RandomAccessFile("staff.dat", "r");
            int nrecords = (int) (staffin.length() / Lecturer.RECORDSIZE());
            System.out.println(nrecords + " Records");
            for (int i = nrecords - 1; i >= 0; i--)
            {
                staffin.seek(i * Lecturer.RECORDSIZE());
                reverseStaff.add(new Lecturer(staffin));
            }
            for (int i = 0; i < staff.size(); i++)
                System.out.println(reverseStaff.get(i));

        } catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(1);
        }

        System.out.println("Now test writing using object serialization");
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("serialstaff.dat"));
            for (int i = 0; i < staff.size(); i++)
                oos.writeObject(staff.get(i));
            oos.close();
        } catch (Exception e)
        {
            System.out.println(e);
            System.exit(1);
        }

        System.out.println("Now test reading using object serialization");
        try
        {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(
                    "serialstaff.dat"));
            Vector oosStaff = new Vector();
            while (true)
            {
                try
                {
                    oosStaff.add(oos.readObject());
                } catch (EOFException eofe)
                {
                    break;
                }
            }
            oos.close();
            for (int i = 0; i < staff.size(); i++)
                System.out.println(oosStaff.get(i));
        } catch (Exception e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
