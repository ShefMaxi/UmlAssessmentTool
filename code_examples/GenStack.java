import java.util.LinkedList;

public class GenStack
{
    GenStack(int capacity)
    {
        data = new Object[capacity];
        nitems = 0;
        this.capacity = capacity;
    }

    public void push(Object s)
    {
        if (nitems < capacity)
        {
            data[nitems] = s;
            ++nitems;
        }
    }

    public Object pop()
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

    private Object[] data;
    private int nitems;
    private int capacity;

    public static void main(String[] args)
    {
        GenStack sixtiesGirlGroups = new GenStack(10); 
        sixtiesGirlGroups.push("Vandellas"); 
        sixtiesGirlGroups.push("3");
        sixtiesGirlGroups.push("Chiffons"); 
        sixtiesGirlGroups.push("Shirelles"); 

        while (sixtiesGirlGroups.size() > 0)
        {
            String s = (String) sixtiesGirlGroups.pop();
            System.out.println("pop: " + s);
        }
    }
}
