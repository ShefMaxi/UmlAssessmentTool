public class Hanoi
{

    static void moveOneDisc(int disc, char fromPeg, char toPeg)
    {
        System.out.println("Move disc " + disc + " from peg " + fromPeg
                + " to peg " + toPeg);
    }

    static void moveTower(int n, char fromPeg, char toPeg, char sparePeg)
    {
        if (n == 1)
            moveOneDisc(n, fromPeg, toPeg);
        else
        {
            moveTower(n - 1, fromPeg, sparePeg, toPeg);
            moveOneDisc(n, fromPeg, toPeg);
            moveTower(n - 1, sparePeg, toPeg, fromPeg);
        }
    }

    public static void main(String[] args)
    {
        moveTower(5, 'A', 'B', 'C');
    }
}
