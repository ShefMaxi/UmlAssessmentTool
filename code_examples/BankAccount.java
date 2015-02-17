public class BankAccount extends Asset implements InterestBearing, Insurable
{

    public BankAccount(double v)
    {
        value = v;
    }

    public double getInterestRate()
    {
        return 5.2;
    }

    public double getPremium()
    {
        // insurance premium is 1% of the value
        return value * 0.01;
    }

}
