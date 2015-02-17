public class Multisave extends Item
{
    int number;
    double discount;

    public Multisave(String n, double p, int num, double disc)
    {
        super(n, p);
        number = num;
        discount = disc;
    }

    public double getPrice()
    {
        return number * price * discount;
    }

    public String toString()
    {
        return name + " = £" + getPrice() + " (multisave saving of £"
                + (1 - discount) * number * price + ")";
    }

}
