import java.util.*;

/**
 * Class <code>PersonTest</code> is a test class <code>TreeSet</code> and
 * <code>HashSet</code> using <code>Person</code>.
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2006-02-16 13:12:00 GMT (jpb)>
 */
public class PersonTest
{

    public static void main(String[] args)
    {
        Set<Person> per_hset = new HashSet<Person>();

        per_hset.add(new Person("Renals", "Steve"));
        per_hset.add(new Person("Bogdanov", "Kirril"));
        per_hset.add(new Person("Brown", "Guy"));
        per_hset.add(new Person("Cooke", "Martin"));
        per_hset.add(new Person("Cooke", "Terry"));
        per_hset.add(new Person("Cooke", "Charlie"));
        per_hset.add(new Person("Cooke", "Sam"));
        per_hset.add(new Person("Guthrie", "Louise"));
        per_hset.add(new Person("Holcombe", "Mike"));
        per_hset.add(new Person("North", "Siobhan"));

        System.out.println(per_hset);

        // duplicate add will fail
        per_hset.add(new Person("Cooke", "Martin"));
        System.out.println(per_hset);

        Set<Person> per_tset = new TreeSet<Person>();

        per_tset.add(new Person("Renals", "Steve"));
        per_tset.add(new Person("Bogdanov", "Kirril"));
        per_tset.add(new Person("Brown", "Guy"));
        per_tset.add(new Person("Cooke", "Martin"));
        per_tset.add(new Person("Cooke", "Sam"));
        per_tset.add(new Person("Cooke", "Terry"));
        per_tset.add(new Person("Cooke", "Charlie"));
        per_tset.add(new Person("Guthrie", "Louise"));
        per_tset.add(new Person("Holcombe", "Mike"));
        per_tset.add(new Person("North", "Siobhan"));

        System.out.println(per_tset);

        // duplicate add will fail
        per_tset.add(new Person("Cooke", "Martin"));
        System.out.println(per_tset);
    }

}
