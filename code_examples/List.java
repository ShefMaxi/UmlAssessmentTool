public class List<T>
{

    private T head;
    private List<T> tail;

    public List()
    {
        head = null;
        tail = null;

    }

    private List(T h, List<T> t)
    {
        head = h;
        tail = t;
    }

    public List<T> add(T s)
    {
        return new List<T>(s, this);
    }

    public T getHead()
    {
        return head;
    }

    public List<T> getTail()
    {
        return tail;
    }

    public String toString()
    {
        List h = this;
        String s = "";
        while (h.head != null)
        {
            s = s + h.head + " ";
            h = h.tail;
        }
        return s;
    }

    public boolean member(T s)
    {
        if (head == null)
            return false;
        else if (s.equals(head))
            return true;
        else
        {
            return tail.member(s);
        }
    }

}
