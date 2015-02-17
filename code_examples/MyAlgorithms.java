import java.util.*;

public class MyAlgorithms
{
    public static void removeIf(Collection c, Predicate func)
    {
        for (Iterator i = c.iterator(); i.hasNext();)
            if (func.pred(i.next()))
                i.remove();

    }
}
