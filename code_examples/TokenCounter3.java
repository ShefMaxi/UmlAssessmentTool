import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TokenCounter3
{
    TokenCounter3(File[] files)
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
                        int c = countTokens(f);
                        System.out.println(f.getName() + ": " + c);
                        synchronized (TokenCounter3.this) {
                            total += c;
                        }
                    }
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
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
            catch (InterruptedException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
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
        return tokens;
    }

    static public void main(String[] args)
    {
        File currentDir = new File(".");
        TokenCounter3 tc = new TokenCounter3(currentDir.listFiles());
        tc.countAllFiles();
    }
}
