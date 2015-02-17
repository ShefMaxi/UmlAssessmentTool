public class Item
{

    protected double price;
    protected String name;

    public Item(String n, double p)
    {
        name = n;
        price = p;
    }

    public double getPrice()
    {
        return price;
    }

    public String toString()
    {
        return name + " = £" + price;
    }

}
