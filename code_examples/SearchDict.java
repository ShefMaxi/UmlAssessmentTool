import java.io.*;

public class SearchDict
{

    static int MAXENTRIES = 20;

    static void fillArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            a[i] = (int) Math.round(Math.random() * 100.0);
    }

    static void displayArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void sortArray(int a[])
    {
        int atEnd, atPosnOfMax, here, temp;
        for (atEnd = a.length - 1; atEnd > 0; atEnd--)
        {
            atPosnOfMax = atEnd;
            for (here = atEnd - 1; here > -1; here--)
                if (a[here] > a[atPosnOfMax])
                    atPosnOfMax = here;
            if (atPosnOfMax != atEnd)
            {
                temp = a[atEnd];
                a[atEnd] = a[atPosnOfMax];
                a[atPosnOfMax] = temp;
            }
        }
    }

    static int binarySearch(int[] a, int soughtValue, int i, int j)
    {
        int midpos;

        if (j < i)
            return 0; // soughtValue not found
        else
        {
            midpos = (i + j) / 2;
            if (a[midpos] < soughtValue)
                return binarySearch(a, soughtValue, midpos + 1, j);
            else if (a[midpos] > soughtValue)
                return binarySearch(a, soughtValue, i, midpos - 1);
            else
                return midpos;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));
        boolean invalidInput = false;
        int searchValue = 0;
        int[] numbers = new int[MAXENTRIES];
        int position = 0;

        fillArray(numbers);
        displayArray(numbers);
        sortArray(numbers);
        displayArray(numbers);

        do
        {
            try
            {
                System.out.print("Value to search for? ");
                System.out.flush();
                String line = input.readLine().trim();
                searchValue = Integer.parseInt(line);
                System.out.println("Search value is " + searchValue);
                invalidInput = false;
            } catch (NumberFormatException e)
            {
                invalidInput = true;
                System.err.println("ERROR: retype integer");
            }
        } while (invalidInput);

        position = binarySearch(numbers, searchValue, 0, numbers.length - 1);

        if (position != 0)
            System.out.println("Search value " + searchValue
                    + " found at index position: " + position);
        else
            System.out.println("Search value not found");

    }
}
