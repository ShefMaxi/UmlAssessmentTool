import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep 
{
	static public void main(String[] args) 
	{
		if (args.length < 2) 
		{
			System.err.println("Error: must specify pattern and at least one input file");
			System.exit(1);
		}
		
		Pattern pattern = Pattern.compile(args[0]);
        System.err.println("Pattern is: '" + args[0] + "'");

		for (int i = 1; i < args.length; ++i)
		{
            System.err.println("File is: " + args[i]);
			File file = new File(args[i]);
			if (!file.exists())
				System.err.println("Warning: file " + file + " not found; ignoring.");
			else
			{
				try {
					BufferedReader infile = new BufferedReader(new FileReader(file));
					String line;
					while ((line = infile.readLine()) != null) 
					{
						Matcher matcher = pattern.matcher(line); 
						if (matcher.find())
							System.out.println(file + ": " + line);
					}
				} catch (IOException e) {
					System.err.println("Error reading file " + file + ": " + e.getMessage());					
				}
			}
		}
	}
}
