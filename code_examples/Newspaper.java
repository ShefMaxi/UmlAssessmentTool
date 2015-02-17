public class Newspaper extends ReadingMatter
{
    String headline;

    public Newspaper(String ti, int pc, String hl)
    {
        super(ti, pc);
        headline = hl;
    }

    public String toString()
    {
        return title + " (Current headline: " + headline + ").";
    }

    public String superToString()
    {
        return super.toString();
    }

    public static void main(String[] args)
    {
        Newspaper n = new Newspaper("Guardian", 128, "Spelling Mistale");

        // prints out using Newspaper's toString method
        System.out.println(n);

        // prints using ReadingMatter's toString method
        System.out.println(n.superToString());
    }
}
