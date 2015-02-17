import java.util.*;

public class LotteryTest
{

    public static void main(String[] args)
    {
        Integer[] numbersArray = {34, 49, 12, 13, 23};

        java.util.LinkedList<Integer> numbersLinkedList = new LinkedList<Integer>();
        numbersLinkedList.add(34);
        numbersLinkedList.add(49);
        numbersLinkedList.add(12);
        numbersLinkedList.add(13);
        numbersLinkedList.add(23);

        java.util.List<Integer> numbersList = new LinkedList<Integer>();
        numbersList.add(34);
        numbersList.add(49);
        numbersList.add(12);
        numbersList.add(13);
        numbersList.add(23);

        System.out.println(numbersLinkedList);

        MyAlgorithms.removeIf(numbersLinkedList, new GreaterThan<Integer>(20));
        MyAlgorithms.removeIf(numbersList, new GreaterThan<Integer>(20));
        System.out.println(numbersLinkedList);

        System.out.println(MyMaximum.arrayMax(numbersArray));

        System.out.println(MyMaximum.linkedListMax(numbersLinkedList));
        System.out.println(MyMaximum.genericMax(numbersLinkedList));

        // System.out.println(MyMaximum.linkedListMax(numbersList));
        System.out.println(MyMaximum.genericMax(numbersList));

    }

}