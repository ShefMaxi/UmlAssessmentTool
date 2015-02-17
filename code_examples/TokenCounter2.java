import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TokenCounter2
{
    TokenCounter2(File[] files)
    {
        this.files = files;
    }

    void countAllFiles()
    {
        ArrayList<Thread> ts = new ArrayList<Thread>();
        for (final File f: files)
        {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        // this is a race condition; may lose some counts 
                        total += countTokens(f);
                    }
                    catch (IOException e) {} // quash error
                }
            });
            ts.add(t);
            t.start();
        }

        for (Thread t: ts)
        {
            try {
                t.join();
            }
            catch (InterruptedException e) {} // not sure what to do
        }

        System.out.println("Total " + total);
    }

    File[] files;
    int total = 0;

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

    static public void main(String[] args)
    {
        File currentDir = new File(".");
        TokenCounter2 tc = new TokenCounter2(currentDir.listFiles());
        tc.countAllFiles();
    }
}
