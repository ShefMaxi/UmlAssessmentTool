import java.io.BufferedReader;

class ReadNumbers
{
    private BufferedReader file;

    public int readNextNumber() throws java.io.IOException
    {
        String line = file.readLine();
        Integer num = Integer.parseInt(line);
        return num;
    }

    void main(String[] args)
    {
        ReadNumbers rn = new ReadNumbers();
        // rn.file ...
        int total = 0;
        try
        {
            total += rn.readNextNumber();
        }
        catch (java.io.IOException e)
        {
            // error
        }
        catch (NumberFormatException e)
        {
            // warning
        }
    }
}
