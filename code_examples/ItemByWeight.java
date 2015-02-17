
public class ItemByWeight extends Item
{
    double weight;

    public ItemByWeight(String n, double p, double w)
    {
        super(n, p);
        weight = w;
    }

    public double getPrice()
    {
        return weight * price;
    }

    public String toString()
    {
        return name + " (" + weight + "kg @ " + price + "£/kg) = £"
                + getPrice();
    }

}
