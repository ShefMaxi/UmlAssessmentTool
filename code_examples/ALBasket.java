import java.util.*;

public class ALBasket
{
    ArrayList items;

    public ALBasket()
    {
        items = new ArrayList();
    }

    public void add(Item i)
    {
        items.add(i);
    }

    public double total()
    {
        double tot = 0.0;
        for (int i = 0; i < items.size(); i++)
            // incorrect: lacks a cast
            // tot += (items.get(i)).getPrice();
            // correct: casts to Item
            tot += ((Item) (items.get(i))).getPrice();
        return tot;
    }

    public String bill()
    {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < items.size(); i++)
            s.append((i + 1) + ": " + items.get(i) + "\n");
        s.append("\n\nTOTAL: £" + total() + "\n");
        return s.toString();
    }

    public static void main(String[] args)
    {
        ALBasket b = new ALBasket();
        b.add(new Item("baked beans", 0.3));
        b.add(new ItemByWeight("bananas", 0.4, 0.7));
        b.add(new Multisave("beer", 1.0, 4, 0.75));

        System.out.println(b.bill());
        // System.out.println("Your total bill is: £" + b.total());
    }
}
