import java.util.LinkedList;

public class Stack
{
    Stack(int capacity)
    {
        data = new Object[capacity];
        nitems = 0;
        this.capacity = capacity;
    }

    public void push(Object s) throws StackFullException
    {
        if (nitems >= capacity)
            throw new StackFullException();
        data[nitems] = s;
        ++nitems;
    }

    public Object pop() throws EmptyStackException
    {
        if (nitems == 0) 
            throw new EmptyStackException();
        return data[--nitems];
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
        Stack sixtiesGirlGroups = new Stack(10); 
        try {
            sixtiesGirlGroups.push("Vandellas"); 
            sixtiesGirlGroups.push("3");
            sixtiesGirlGroups.push("Chiffons"); 
            sixtiesGirlGroups.push("Shirelles"); 

            while (sixtiesGirlGroups.size() > 0)
            {
                String s = (String) sixtiesGirlGroups.pop();
                System.out.println("pop: " + s);
            }
        } catch (EmptyStackException e) {
            System.out.println("ERROR: pop from empty stack");
        } catch (StackFullException e) {
            System.out.println("ERROR: push to full stack");
        }
    }
}
