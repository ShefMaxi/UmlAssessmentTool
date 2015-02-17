import java.util.*;

public class AlgTest
{
    public static void main(String[] args)
    {
        java.util.List<Person> lPeople = new LinkedList<Person>();

        lPeople.add(new Person("Austen", "Jane"));
        lPeople.add(new Person("Eliot", "George"));
        lPeople.add(new Person("Bronte", "Charlotte"));
        lPeople.add(new Person("Bronte", "Anne"));
        lPeople.add(new Person("Bronte", "Emily"));
        lPeople.add(new Person("Eliot", "TS"));
        lPeople.add(new Person("Keats", "John"));
        lPeople.add(new Person("Shelley", "Percy"));
        lPeople.add(new Person("Shelley", "Mary"));
        lPeople.add(new Person("Browning", "Elizabeth Barrett"));
        lPeople.add(new Person("Browning", "Robert"));
        lPeople.add(new Person("Byron", "Lord"));
        lPeople.add(new Person("Tennyson", "Alfred Lord"));
        lPeople.add(new Person("Wordsworth", "William"));
        lPeople.add(new Person("Coleridge", "Samuel"));
        lPeople.add(new Person("Tolstoy", "Leo"));
        lPeople.add(new Person("Chekhov", "Anton"));

        java.util.List<Person> aPeople = new ArrayList<Person>(lPeople);
        Collections.reverse(aPeople);
        System.out.println("Construct l, copy construct a, reverse a");
        System.out.println(lPeople);
        System.out.println(aPeople);

        // copy a into l
        System.out.println("copy a into l");
        Collections.copy(lPeople, aPeople);
        System.out.println(lPeople);
        System.out.println(aPeople);

        System.out.println("Maximum element is: " + Collections.max(aPeople));

        System.out.println("Sort by surname, firstName");
        Collections.sort(aPeople);
        System.out.println(aPeople);

        System.out.println("Sort in reverse");
        Collections.sort(aPeople, Collections.reverseOrder());
        System.out.println(aPeople);

        System.out.println("Sort by first name");
        Collections.sort(aPeople, new Comparator<Person>()
        {
            public int compare(Person a, Person b)
            {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });
        System.out.println(aPeople);

        System.out.println("Sort by surname, firstName, then find tolstoy");
        Collections.sort(aPeople);
        int indx;
        indx = Collections.binarySearch(aPeople, new Person("Tolstoy", "Leo"));

        System.out.println(indx);

        System.out.println("Search for Dickens, insert if failure");
        Person p = new Person("Dickens", "Charles");
        indx = Collections.binarySearch(aPeople, p);

        if (indx < 0)
            aPeople.add(-indx - 1, p);

        System.out.println(aPeople);

        System.out.println("Sort by first name, search for dickens");
        Collections.sort(aPeople, new Comparator<Person>()
        {
            public int compare(Person a, Person b)
            {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });
        System.out.println(aPeople);

        indx = Collections.binarySearch(aPeople, p, new Comparator<Person>()
        {
            public int compare(Person a, Person b)
            {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });

        System.out.println(indx);

        System.out.println("Search for Pushkin, insert if failure");
        Person newp = new Person("Pushkin", "Alexander");
        indx = Collections.binarySearch(aPeople, newp, new Comparator<Person>()
        {
            public int compare(Person a, Person b)
            {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });
        if (indx < 0)
            aPeople.add(-indx - 1, newp);

        System.out.println(aPeople);
    }

}
