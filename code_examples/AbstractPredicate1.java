import java.util.*;

public abstract class AbstractPredicate1<T> implements Predicate<T>
{
    AbstractPredicate1(T arg)
    {
        data = arg;
    }

    public abstract boolean pred(T o);

    T data;
}
