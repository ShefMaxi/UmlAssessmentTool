import java.util.*;

/**
 * <code>Comparator</code> object for a <code>TreeSet</code>. Don't usually use
 * this, but use an anonymous inner class instead.
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2006-02-16 13:25:54 GMT (jpb)>
 * @see Comparator
 */
public class PersonComparator implements Comparator<Person>
{
    public int compare(Person a, Person b)
    {
        return a.getFirstName().compareTo(b.getFirstName());
    }
}
