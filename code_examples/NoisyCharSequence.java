
public class NoisyCharSequence implements CharSequence
{

    private String s; // Holds the characters
    private double p; // probability of corruption

    public NoisyCharSequence(String s, double p)
    {
        this.s = s;
        this.p = p;
    }

    public int length()
    {
        return s.length();
    }

    public char charAt(int i)
    {
        char x = s.charAt(i);
        if (isCorrupt())
        {
            char y;
            do
            {
                y = randChar();
            } while (y == x);
            x = y;
        }
        return x;
    }

    public CharSequence subSequence(int start, int end)
    {
        String x = new String();
        for (int i = start; i < end; ++i)
            x += charAt(i);
        return x;
    }

    public String toString()
    {
        return subSequence(0, s.length()).toString();
    }

    private boolean isCorrupt()
    {
        return (Math.random() < p);
    }

    // Generate a random lower case character
    private char randChar()
    {
        char x = (char) (Math.random() * 26.0);
        return (char) ('a' + x);
    }

}
