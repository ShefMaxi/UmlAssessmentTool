
public class NoisyCharSequenceDemo
{
    public static void main(String[] args)
    {

        NoisyCharSequence s = new NoisyCharSequence(args[0], 0.05);
        // NoisyCharSequence s = new
        // NoisyCharSequence("Write a class that implements the CharSequence interface found in the java.lang package.",
        // 0.05);

        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }

}
