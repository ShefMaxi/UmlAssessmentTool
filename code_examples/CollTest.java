import java.util.*;

public class CollTest
{

    public static void main(String[] args)
    {
        MyStack<String> sixtiesGirlGroups = new ArrayStack<String>();
        sixtiesGirlGroups.push("Vandellas");
        sixtiesGirlGroups.push("Crystals");

        String s;
        while ((s = (String) sixtiesGirlGroups.pop()) != null)
        {
            System.out.println(s);
        }

        MyStack<String> seventiesProgGroups = new LinkedListStack<String>();
        seventiesProgGroups.push("Pink Floyd");
        seventiesProgGroups.push("Yes");
        seventiesProgGroups.push("Emerson, Lake and Palmer");
        while ((s = (String) seventiesProgGroups.pop()) != null)
        {
            System.out.println(s);
        }

        Collection<String> eightiesNewRomanticGroups = new LinkedList<String>();
        eightiesNewRomanticGroups.add("A Flock of Seagulls");
        eightiesNewRomanticGroups.add("Spandau Ballet");
        eightiesNewRomanticGroups.add("Duran Duran");
        collPrint(eightiesNewRomanticGroups);
        System.out.println(eightiesNewRomanticGroups);
        Iterator<String> iter = eightiesNewRomanticGroups.iterator();
        while (iter.hasNext())
        {
            String grp = iter.next();
            if (grp.equals("Spandau Ballet"))
                iter.remove();
            else
                System.out.println(grp);
        }
        collPrint(eightiesNewRomanticGroups);
        System.out.println(eightiesNewRomanticGroups);
    }

    private static void collPrint(Collection c)
    {
        System.out.print("[ ");
        Iterator iter = c.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("]");
    }

}
