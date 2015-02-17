import java.util.LinkedList;

public class StringStack
{
    StringStack(int capacity)
    {
        data = new String[capacity];
        nitems = 0;
        this.capacity = capacity;
    }

    public void push(String s)
    {
        // what about throwing a CollectionFullException??
        if (nitems < capacity)
        {
            data[nitems] = s;
            ++nitems;
        }
    }

    public String pop()
    {
        if (nitems > 0)
            return data[--nitems];
        else
            return null;
    }

    public int size()
    {
        return nitems;
    }

    private String[] data;
    private int nitems;
    private int capacity;

    public static void main(String[] args)
    {
        StringStack sixtiesGirlGroups = new StringStack(10); 
        sixtiesGirlGroups.push("Vandellas"); 
        sixtiesGirlGroups.push("Chiffons"); 
        sixtiesGirlGroups.push("Shirelles"); 

        while (sixtiesGirlGroups.size() > 0)
        {
            String s = sixtiesGirlGroups.pop();
            System.out.println("pop: " + s);
        }
    }
}
