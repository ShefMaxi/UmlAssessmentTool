import java.io.*;

/**
 * <code>DataIO</code> - helper class for reading and writing fixed length
 * strings
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2001-02-02 16:07:59 GMT (sjr)>
 */

public class DataIO
{
    /**
     * Writes a fixed length string to a <code>DataOutput</code> stream
     * 
     * @param s
     *            <code>String</code> to write out
     * @param size
     *            fixed length of string
     * @param out
     *            <code>DataOutput</code> stream
     * @exception IOException
     *                if an error occurs
     */
    public static void writeFixedLengthString(String s, int size, DataOutput out)
            throws IOException
    {
        for (int i = 0; i < size; i++)
        {
            char c = 0;
            if (i < s.length())
                c = s.charAt(i);
            out.writeChar(c);
        }
    }

    /**
     * Reads a fixed length string from an output stream
     * 
     * @param size
     *            length of string to read (may be terminated early by 0)
     * @param in
     *            <code>DataInput</code> stream
     * @return string read from stream
     * @exception IOException
     *                if an error occurs
     */
    public static String readFixedLengthString(int size, DataInput in)
            throws IOException
    {
        StringBuffer buf = new StringBuffer(size);
        int count = 0;
        boolean done = false;
        while (!done && count < size)
        {
            char c = in.readChar();
            ++count;
            if (c == 0)
                done = true;
            else
                buf.append(c);
        }
        // move to the end of the fixed length input
        in.skipBytes(2 * (size - count));
        return buf.toString();
    }
};
