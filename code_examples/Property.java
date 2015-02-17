public class Property extends Asset implements Insurable
{

    public Property(double v)
    {
        value = v;
    }

    public double getPremium()
    {
        // insurance premium is 5% of the value
        return value * 0.05;
    }

}
