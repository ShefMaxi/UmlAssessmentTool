public class LinkedListStack2<T> extends AbstractStack2<T>
{

    LinkedListStack2()
    {
        super();
        head = null;
    }

    public void push(T obj)
    {
        head = new Link<T>(obj, head);
        inc_size();
    }

    public T pop()
    {
        T ret = null;
        if (head != null)
        {
            ret = head.getDatum();
            head = head.getNext();
            dec_size();
        }
        return ret;
    }

    private Link<T> head;

}
