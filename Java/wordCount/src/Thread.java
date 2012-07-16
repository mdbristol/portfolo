
	import java.io.BufferedWriter;
import java.io.File;
	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;
public class Thread implements Runnable 
{
	public static FileOutputStream Output;
	public static PrintStream file;
		final String output = "output.txt";
		
		BufferedWriter out; 
		private String filename;	
	
		private Scanner in;
		private int count = 0;	
		private int totalcount = 0;
	
	
		
		
			
			public void run ()
			{
				
				//ReadAndWriteFile rw = new ReadAndWriteFile(); 
			//	out = new BufferedWriter(new FileWriter(output)); 
				
				// Set up scanner to read from file. 
			
				try 
				{
					in = new Scanner(new File(filename));
			
					
					while (in.hasNext())
						{
						String s = in.next(); 
						count++;
						
						}
						totalcount=totalcount + count;
						in.close();
				}
						
						
				
				catch(FileNotFoundException e)
					{
					System.out.println("Could not load file");
					}
				
				try
				{
					Output = new FileOutputStream("output.txt");
					file = new PrintStream(Output);
				}
				catch(Exception e)
				{
					System.out.println("Could not load file");
				}
				
		
				// Close the output file
				file.println("The " + filename + " has: " + count + " words");
				
				
				
			}
	}



