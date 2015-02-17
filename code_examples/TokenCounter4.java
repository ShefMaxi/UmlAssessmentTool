import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.concurrent.*;

public class TokenCounter4
{
    TokenCounter4(File[] files)
    {
        this.files = files;
    }

    void countAllFiles()
    {
        ArrayList<Future<Integer>> fs = new ArrayList<Future<Integer>>();
        for (final File f: files)
        {
            FutureTask<Integer> future =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() {
                        try {
                            return countTokens(f);
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
            fs.add(future);
            Thread t = new Thread(future);
            t.start();
        }

        int total = 0;
        for (Future<Integer> f: fs)
        {
            try {
                total += f.get();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total " + total);
    }

    File[] files;

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
        TokenCounter4 tc = new TokenCounter4(currentDir.listFiles());
        tc.countAllFiles();
    }
}
