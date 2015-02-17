import java.io.*;
import java.util.*;

/**
 * <code>Lecturer</code> class containing some basic attributes and methods for
 * both text-based and binary I/O
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2001-02-02 17:10:53 GMT (sjr)>
 * @see Serializable
 * @see ContactDetails
 */
public class Lecturer implements Serializable
{

    /**
     * Creates a new <code>Lecturer</code> instance.
     * 
     * @param sn
     *            surname string
     * @param fn
     *            first name string
     * @param em
     *            email address string
     * @param tel
     *            telephone number
     * @param off
     *            office number
     * @param l
     *            floating point teaching load indicator
     */
    public Lecturer(String sn, String fn, String em, int tel, int off, double l)
    {
        surname = sn;
        firstName = fn;
        coordinates = new ContactDetails(em, tel, off);
        normalizedTeachingLoad = l;
    }

    /**
     * Creates a new <code>Lecturer</code> instance from a text-based database
     * 
     * @param rdr
     *            code>BufferedReader</code> attached to text file
     * @exception IOException
     *                if an error occurs in reading
     */
    public Lecturer(BufferedReader rdr) throws IOException
    {
        readData(rdr);
    }

    /**
     * Creates a new <code>Lecturer</code> instance from a binary file
     * 
     * @param din
     *            <code>DataInput</code> stream attached to binary database
     * @exception IOException
     *                if an error occurs in reading
     */
    public Lecturer(DataInput din) throws IOException
    {
        readBinaryData(din);
    }

    /**
     * Return surname as a string
     * 
     * @return the surname string
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Return first name as a string
     * 
     * @return the first name string
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Return the contact details
     * 
     * @return a <code>ContactDetails</code> object
     */
    public ContactDetails getCoordinates()
    {
        return coordinates;
    }

    /**
     * Return floatin point normalized teaching load value
     * 
     * @return the normalized teaching load
     */
    public double getNormalizedTeachingLoad()
    {
        return normalizedTeachingLoad;
    }

    /**
     * Return contact details as a string
     * 
     * @return the string
     */
    public String toString()
    {
        return surname + ":" + firstName + ":" + coordinates + ":"
                + normalizedTeachingLoad;
    }

    /**
     * Indicate if some other object is equal to this one. Compares email,tel
     * number and office number fields
     * 
     * @param obj
     *            object with shich to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Lecturer))
            return false;
        Lecturer l = (Lecturer) obj;
        return surname.equals(l.surname) && firstName.equals(l.firstName)
                && coordinates.equals(l.coordinates)
                && normalizedTeachingLoad == l.normalizedTeachingLoad;
    }

    /**
     * Print attribute values (using <code>toString</code>) to file
     * 
     * @param pw
     *            code>PrintWriter</code> attached to text database file
     * @exception IOException
     *                if an error occurs in writing
     */
    public void writeData(PrintWriter pw) throws IOException
    {
        pw.println(this);
    }

    /**
     * Read attribute values from file using tokenizer
     * 
     * @param pw
     *            code>BufferedReader</code> attached to text database file
     * @exception IOException
     *                if an error occurs in reading
     */
    public void readData(BufferedReader rdr) throws IOException
    {
        String s = rdr.readLine();
        StringTokenizer tok = new StringTokenizer(s, ":");
        surname = tok.nextToken();
        firstName = tok.nextToken();
        String e = tok.nextToken();
        int tel = Integer.parseInt(tok.nextToken());
        int off = Integer.parseInt(tok.nextToken());
        coordinates = new ContactDetails(e, tel, off);
        normalizedTeachingLoad = Double.parseDouble(tok.nextToken());
    }

    /**
     * Write attribute values to binary file using fixed length strings
     * 
     * @param pw
     *            code>DataOutput</code> stream attached to binary database file
     * @exception IOException
     *                if an error occurs in writing
     */
    public void writeBinaryData(DataOutput out) throws IOException
    {
        DataIO.writeFixedLengthString(surname, STRINGSIZE, out);
        DataIO.writeFixedLengthString(firstName, STRINGSIZE, out);
        DataIO.writeFixedLengthString(coordinates.getEmailAddress(),
                STRINGSIZE, out);
        out.writeInt(coordinates.getTelNumber());
        out.writeInt(coordinates.getOffice());
        out.writeDouble(normalizedTeachingLoad);
    }

    /**
     * Read attribute values from binary file
     * 
     * @param pw
     *            code>DataInput</code> stream attached to binary database file
     * @exception IOException
     *                if an error occurs in reading
     */
    public void readBinaryData(DataInput in) throws IOException
    {
        surname = DataIO.readFixedLengthString(STRINGSIZE, in);
        firstName = DataIO.readFixedLengthString(STRINGSIZE, in);
        String e = DataIO.readFixedLengthString(STRINGSIZE, in);
        int tel = in.readInt();
        int off = in.readInt();
        coordinates = new ContactDetails(e, tel, off);
        normalizedTeachingLoad = in.readDouble();
    }

    /**
     * Size of a single record written by <code>writeBinaryData</code>
     * 
     * @return <code>int</code> value of record size
     */
    public static int RECORDSIZE()
    {
        return 3 * STRINGSIZE * 2 + 4 + 4 + 8;
    }

    private String surname;
    private String firstName;
    private ContactDetails coordinates;
    private double normalizedTeachingLoad;

    private static final int STRINGSIZE = 48;
}
