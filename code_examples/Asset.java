// Note that Asset has been declared abstract because we don't want it
// to be instantiated - even though it doesn't contain any abstract methods

public abstract class Asset
{

    protected double value;

    public double getValue()
    {
        return value;
    }

}
