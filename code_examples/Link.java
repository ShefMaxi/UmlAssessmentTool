
public class Link<T>
{

    public Link(T obj, Link<T> ptr)
    {
        datum = obj;
        next = ptr;
    }

    public T getDatum()
    {
        return datum;
    }

    public Link<T> getNext()
    {
        return next;
    }

    private T datum;
    private Link<T> next;
}
