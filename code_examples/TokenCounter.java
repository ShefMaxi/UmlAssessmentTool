import java.io.*;
import java.util.regex.*;

public class TokenCounter
{
    static int countTokens(File f) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        int tokens = 0;
        String line;
        Pattern p = Pattern.compile("\\s+");
        while ((line = in.readLine()) != null)
        {
            for (String token : p.split(line))
                ++tokens;
        }
        System.out.println(f.getName() + ": " + tokens);
        return tokens;
    }

    static int countTokensFromFiles(File[] files)
    {
        int total = 0;
        for (File f: files)
        {
            try {
                total += countTokens(f);
            } catch (IOException e) {} // ignore
        }
        return total;
    }

    static public void main(String[] args)
    {
        File currentDir = new File(".");
        int tokens = countTokensFromFiles(currentDir.listFiles());
        System.out.println("Total " + tokens);
    }
}
