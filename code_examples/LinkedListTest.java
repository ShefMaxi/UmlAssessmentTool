import java.util.*;

public class LinkedListTest
{

    public static void main(String[] args)
    {
        LinkedList<String> sixtiesGirlGroups = new LinkedList<String>();
        sixtiesGirlGroups.add("Vandellas");
        sixtiesGirlGroups.add("Chiffons");
        sixtiesGirlGroups.add("Shirelles");

        System.out.println("reset iter and iterate forwards: "
                + sixtiesGirlGroups);
        ListIterator<String> iter = sixtiesGirlGroups.listIterator();
        System.out.println("next: " + iter.next());
        System.out.println("add Supremes");
        iter.add("Supremes");
        System.out.println("add Ronettes");
        iter.add("Ronettes");
        System.out.println(sixtiesGirlGroups);
        System.out.println("next: " + iter.next());

        System.out.println("move iter to end and iterate backwards: "
                + sixtiesGirlGroups);
        // reset the iterator
        iter = sixtiesGirlGroups.listIterator(sixtiesGirlGroups.size());
        System.out.println("previous: " + iter.previous());
        System.out.println("previous: " + iter.previous());
        System.out.println("add Chantels");
        iter.add("Chantels");
        System.out.println("add Shangri-Las");
        iter.add("Shangri-Las");
        System.out.println(sixtiesGirlGroups);
        System.out.println("previous: " + iter.previous());
        System.out.println("previous: " + iter.previous());

        System.out.println("reset iter and iterate forwards: "
                + sixtiesGirlGroups);
        iter = sixtiesGirlGroups.listIterator();
        System.out.println("next: " + iter.next());
        System.out.println("remove");
        iter.remove();
        System.out.println(sixtiesGirlGroups);
        System.out.println("add Crystals");
        iter.add("Crystals");
        System.out.println(sixtiesGirlGroups);
        System.out.println("next: " + iter.next());
        System.out.println("next: " + iter.next());
        System.out.println("remove");
        iter.remove();
        System.out.println("next: " + iter.next());
        System.out.println("remove");
        iter.remove();
        System.out.println(sixtiesGirlGroups);
        System.out.println("previous: " + iter.previous());

        System.out.println("move iter to end and iterate backwards: "
                + sixtiesGirlGroups);
        // reset the iterator
        iter = sixtiesGirlGroups.listIterator(sixtiesGirlGroups.size());
        System.out.println("previous: " + iter.previous());
        System.out.println("previous: " + iter.previous());
        System.out.println("remove");
        iter.remove();
        System.out.println(sixtiesGirlGroups);
        System.out.println("previous: " + iter.previous());
        System.out.println("remove");
        iter.remove();
        System.out.println(sixtiesGirlGroups);
        System.out.println("previous: " + iter.previous());
        System.out.println("previous: " + iter.previous());

    }

}
