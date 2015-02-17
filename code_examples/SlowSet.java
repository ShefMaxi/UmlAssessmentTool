import java.io.*;
import java.util.*;

public class SlowSet 
{
	public static void main(String[] args)
	{	
		long start = System.currentTimeMillis();
		try 
		{
			Collection<String> wordSet = new LinkedList<String>();
			if (args[1].equals("array"))
				wordSet = new ArrayList<String>();
			else if (args[1].equals("hash"))
				wordSet = new HashSet<String>();
			else if (args[1].equals("tree")) 	
				wordSet = new TreeSet<String>();

			BufferedReader input = new BufferedReader(new FileReader(args[0]));
			String line;	
			int totalTokens = 0;
			while ((line = input.readLine()) != null)
			{
				StringTokenizer tokenizer = new StringTokenizer(line);
				while (tokenizer.hasMoreTokens())
				{
					String word = tokenizer.nextToken();
					if (wordSet.contains(word) == false) 
						wordSet.add(word);
					totalTokens += 1;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Took " + ((end - start) / 1000.0) + " secs to read " + wordSet.size() + " unique words and " + totalTokens + " running words");
			System.out.println("Average time " + ((end - start) / (double) totalTokens) + " ms");
		}
		catch (FileNotFoundException e) 
		{
			System.err.println("Failed to open file: " + args[0] + " message: " + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.err.println("I/O error reading file: " + args[0] + " message: " + e.getMessage());
		}		
	}
}
