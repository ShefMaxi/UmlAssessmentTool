import java.util.*;

/**
 * <code>TreeSetComparator</code> is a test class to demonstrate use of the
 * <code>Comparator</code> interface.
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2006-02-16 13:36:56 GMT (jpb)>
 */
public class TreeSetComparator
{

    // sort by first name
    public static void main(String[] args)
    {

        // uses a concrete class that implements the Comparator interface
        PersonComparator pcomp = new PersonComparator();
        SortedSet<Person> tset1 = new TreeSet<Person>(pcomp);

        tset1.add(new Person("Renals", "Steve"));
        tset1.add(new Person("Bogdanov", "Kirril"));
        tset1.add(new Person("Brown", "Guy"));
        tset1.add(new Person("Cooke", "Martin"));
        tset1.add(new Person("Cooke", "Sam"));
        tset1.add(new Person("Cooke", "Terry"));
        tset1.add(new Person("Cooke", "Charlie"));
        tset1.add(new Person("Guthrie", "Louise"));
        tset1.add(new Person("Holcombe", "Mike"));
        tset1.add(new Person("North", "Siobhan"));

        System.out.println(tset1);

        // now use an anonymous inner class to create a function object
        // on-the-fly
        TreeSet<Person> tset2 = new TreeSet<Person>(new Comparator<Person>()
        {
            public int compare(Person a, Person b)
            {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });

        tset2.add(new Person("Renals", "Steve"));
        tset2.add(new Person("Bogdanov", "Kirril"));
        tset2.add(new Person("Brown", "Guy"));
        tset2.add(new Person("Cooke", "Martin"));
        tset2.add(new Person("Cooke", "Sam"));
        tset2.add(new Person("Cooke", "Terry"));
        tset2.add(new Person("Cooke", "Charlie"));
        tset2.add(new Person("Guthrie", "Louise"));
        tset2.add(new Person("Holcombe", "Mike"));
        tset2.add(new Person("North", "Siobhan"));

        System.out.println(tset2);

    }

}
