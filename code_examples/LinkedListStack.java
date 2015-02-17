
public class LinkedListStack<T> implements MyStack<T>
{
    LinkedListStack()
    {
        head = null;
    }

    public void push(T obj)
    {
        head = new Link<T>(obj, head);
    }

    public T pop()
    {
        T ret = null;
        if (head != null)
        {
            ret = head.getDatum();
            head = head.getNext();
        }
        return ret;
    }

    public int size()
    {
        int ret = 0;
        Link l = head;
        while (l != null)
        {
            ++ret;
            l = l.getNext();
        }
        return ret;
    }

    private Link<T> head;

}
