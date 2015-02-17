public interface MinMax<T extends Comparable<T>>
{
    public T min();
    public T max();
}

abstract class MyClass<T extends Comparable<T>> implements MinMax<T>
{
}
