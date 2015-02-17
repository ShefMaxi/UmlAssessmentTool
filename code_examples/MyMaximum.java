import java.util.*;

public class MyMaximum
{
    public static Object arrayMax(Comparable[] a)
    {
        if (a.length == 0)
            throw new NoSuchElementException();
        Comparable largest = a[0];
        for (int i = 1; i < a.length; i++)
            if (largest.compareTo(a[i]) < 0)
                largest = a[i];
        return largest;
    }

    public static Object linkedListMax(LinkedList l)
    {
        if (l.isEmpty())
            throw new NoSuchElementException();
        Iterator iter = l.iterator();
        Comparable largest = (Comparable) iter.next();
        while (iter.hasNext())
        {
            Comparable nxt = (Comparable) iter.next();
            if (largest.compareTo(nxt) < 0)
                largest = nxt;
        }
        return largest;
    }

    public static Object genericMax(Collection c)
    {
        if (c.isEmpty())
            throw new NoSuchElementException();
        Iterator iter = c.iterator();
        Comparable largest = (Comparable) iter.next();
        while (iter.hasNext())
        {
            Comparable nxt = (Comparable) iter.next();
            if (largest.compareTo(nxt) < 0)
                largest = nxt;
        }
        return largest;
    }
}
