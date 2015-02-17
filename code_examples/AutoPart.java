import java.util.*;

/**
 * Class <code>AutoPart</code> is a toy class for illustrating
 * <code>TreeSet</code> and <code>HashSet</code>. It provides the required
 * <code>hashCode</code>, <code>equals</code> and <code>compareTo</code>
 * methods, and implements the <code>Comparable</code> interface.
 * 
 * Its only attribute is an integer partID
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2005-02-13 11:06:17 GMT (jpb)>
 * @see Comparable
 */
public class AutoPart implements Comparable<AutoPart>
{

    /**
     * Creates a new <code>AutoPart</code> instance.
     * 
     * @param pt
     *            an <code>int</code> for the part ID
     */
    public AutoPart(int pt)
    {
        partID = pt;
    }

    /**
     * Returns a string of form "<partid>"
     * 
     * @return the string
     */
    public String toString()
    {
        return Integer.toString(partID);
    }

    /**
     * Computes the hash code based on partID
     * 
     * @return the <code>int</code> hash code.
     */
    public int hashCode()
    {
        return 13 * partID;
    }

    /**
     * Returns true if <code>obj</code> equals this object. Equality is defined
     * asthe partID numbers being equal
     * 
     * @param obj
     *            the object to compare with
     * @return true if the objects are equal
     */
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass())
            return false;
        AutoPart part = (AutoPart) obj;
        return partID == part.partID;
    }

    /**
     * Compares this object with <code>obj</code> using partID
     * 
     * @param obj
     *            the object to compare with
     * @return the value 0 if the partIDs of the objects are equal a value less
     *         than 0 if the partID of this object is less than the partID of
     *         the argument; and a value greater than 0 if the partID of this
     *         object is greater than that of the argument.
     */
    public int compareTo(AutoPart part)
    {
        return partID - part.partID;
    }

    private int partID;

    // test framework
    public static void main(String[] args)
    {

        // first store in an unordered hash set
        Set<AutoPart> auto_hset = new HashSet<AutoPart>();
        auto_hset.add(new AutoPart(13));
        auto_hset.add(new AutoPart(109));
        auto_hset.add(new AutoPart(24));
        auto_hset.add(new AutoPart(3));
        auto_hset.add(new AutoPart(33));
        auto_hset.add(new AutoPart(113));
        auto_hset.add(new AutoPart(1));
        auto_hset.add(new AutoPart(71));
        auto_hset.add(new AutoPart(88));
        System.out.println(auto_hset);

        // duplicate add will fail
        auto_hset.add(new AutoPart(1));
        System.out.println(auto_hset);

        // now store in an ordered tree set
        Set<AutoPart> auto_tset = new TreeSet<AutoPart>();
        auto_tset.add(new AutoPart(13));
        auto_tset.add(new AutoPart(109));
        auto_tset.add(new AutoPart(24));
        auto_tset.add(new AutoPart(3));
        auto_tset.add(new AutoPart(33));
        auto_tset.add(new AutoPart(113));
        auto_tset.add(new AutoPart(1));
        auto_tset.add(new AutoPart(71));
        auto_tset.add(new AutoPart(88));
        System.out.println(auto_tset);

        // duplicate add will fail
        auto_tset.add(new AutoPart(1));
        System.out.println(auto_tset);
    }
}
