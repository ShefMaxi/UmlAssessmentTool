/**
 * Demonstration of a linked list Written by: Guy J. Brown First written:
 * 26/3/2000 Last rewritten: 26/3/2000 Modify to make generic: 02/2006 (JPB)
 */

public class ListDemo
{

    public static void main(String args[])
    {

        // one way to make a list

        List<String> p = new List<String>();
        p = p.add("fox");
        p = p.add("pig");
        p = p.add("hen");

        // this way is easier

        List<String> q = new List<String>().add("hen").add("emu").add("yak")
                .add("cat").add("dog");

        List<Integer> x = new List<Integer>().add(5).add(4).add(3).add(2)
                .add(1);
        // print the lists

        System.out.println(p);
        System.out.println(q);
        System.out.println(x);

        // membership

        System.out.println(p.member("yak"));
        System.out.println(q.member("yak"));
        System.out.println(x.member(2));

        // length

        // System.out.println(List.length(p));
        // System.out.println(List.length(q));

        // reversal

        // System.out.println(List.reverse(p));
        // System.out.println(List.reverse(q));

    }
}
