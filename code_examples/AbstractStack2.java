public abstract class AbstractStack2<T> implements MyStack<T>
{

    AbstractStack2()
    {
        nitems = 0;
    }

    public abstract void push(T obj);

    public abstract T pop();

    public void removeAll()
    {
        while (!isEmpty())
        {
            pop();
        }
    }

    public int size()
    {
        return nitems;
    }

    public void inc_size()
    {
        nitems++;
    }

    public void dec_size()
    {
        nitems--;
    }

    public boolean isEmpty()
    {
        return nitems == 0;
    }

    public String toString()
    {
        return ("Stack of " + nitems);
    }

    private int nitems;
}
