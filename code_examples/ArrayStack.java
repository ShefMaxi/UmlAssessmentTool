public class ArrayStack<T> implements MyStack<T>
{
    public ArrayStack()
    {
        capacity = 100;
        data = (T[]) new Object[capacity];
        nitems = 0;
    }

    ArrayStack(int cap)
    {
        capacity = cap;
        data = (T[]) new Object[capacity];
        nitems = 0;
    }

    public void push(T obj)
    {
        // what about throwing a CollectionFullException??
        if (nitems < capacity)
        {
            data[nitems] = obj;
            ++nitems;
        }
    }

    public T pop()
    {
        if (nitems > 0)
        {
            return data[--nitems];
        }
        return null;
    }

    public int size()
    {
        return nitems;
    }

    private T[] data;
    private int nitems;
    private int capacity;
}
