import java.util.*;

/**
 * Class <code>Person</code> is a toy class for illustrating
 * <code>TreeSet</code> and <code>HashSet</code>. It provides the required
 * <code>hashCode</code>, <code>equals</code> and <code>compareTo</code>
 * methods, and implements the <code>Comparable</code> interface.
 * 
 * The attributes of <code>Person</code> are surname and firstName only, and
 * sorting is lexicographic, surname first.
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2006-02-16 13:12:01 GMT (jpb)>
 * @see Comparable
 */
public class Person implements Comparable<Person>
{

    /**
     * Creates a new <code>Person</code> instance.
     * 
     * @param sn
     *            surname <code>String</code>
     * @param fn
     *            first name <code>String</code>
     */
    public Person(String sn, String fn)
    {
        surname = sn;
        firstName = fn;
    }

    /**
     * Computes the hash code for person by combining hash codes for firstname
     * and surname
     * 
     * @return the <code>int</code> hash code.
     */
    public int hashCode()
    {
        return 13 * surname.hashCode() + 17 * firstName.hashCode();
    }

    /**
     * Returns a string of form "firstName Surname"
     * 
     * @return the string
     */
    public String toString()
    {
        return firstName + " " + surname;
    }

    /**
     * Returns true if <code>obj</code> equals this object. Equality is defined
     * as both surname and firstName strings being equal
     * 
     * @param obj
     *            the object to compare with
     * @return true if the objects are equal
     */
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person per = (Person) obj;
        return surname.equals(per.surname) && firstName.equals(per.firstName);
    }

    /**
     * Compares this object with <code>obj</code> lexicographically, surname
     * then firstName
     * 
     * @param obj
     *            the object to compare with
     * @return the value 0 if the argument object is equal to this object; a
     *         value less than 0 if this object is lexicographically less than
     *         the argument (surname then firstName); and a value greater than 0
     *         if this object is lexicographically greater than the argument
     *         (surname then firstName).
     */
    public int compareTo(Person per)
    {
        if (surname.equals(per.surname))
            return firstName.compareTo(per.firstName);

        return surname.compareTo(per.surname);
    }

    /**
     * Return the surname of a <code>Person</code>
     * 
     * @return the surname string
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Return the first name of a <code>Person</code>
     * 
     * @return the first name string
     */
    public String getFirstName()
    {
        return firstName;
    }

    private String surname;
    private String firstName;

}
