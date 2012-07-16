

//This program reads strings from a file input.txt and writes into the file 
//output.txt

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReadAndWriteFile {
	public static FileOutputStream Output;
	public static PrintStream file;

		// file to be read from.
		final String input1 = "test.txt";
		final String input2 = "test2.txt";
		// file to be written into.
		final String output = "output.txt";
		Scanner in; 
		BufferedWriter out; 
		static int count =0; 
		static int count2 = 0;
		static int totalcount = 0;
		
		public static void main(String[] args) throws IOException {
			ReadAndWriteFile rw = new ReadAndWriteFile(); 
			ReadAndWriteFile rw2 = new ReadAndWriteFile(); 
			
			// Set up scanner to read from file. 
			rw.in = new Scanner(new File(rw.input1));
			rw2.in = new Scanner(new File(rw2.input2));
			
			
			// Set up BufferedWriter to write into a file
			rw.out = new BufferedWriter(new FileWriter(rw.output)); 
			rw2.out = new BufferedWriter(new FileWriter(rw2.output)); 
			
			// Loop through the input file reading each string 
			
			while (rw.in.hasNext()) {
				String s = rw.in.next(); 
				count++;
				
			}
			while (rw2.in.hasNext()) {
				String s = rw2.in.next(); 
				count2++;
				
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
			
			totalcount = count + count2;
			// Close the output file
			file.println("The file1 has: " + count + " words");
			file.println("The file2 has: " + count2 + " words");
			file.println("Total count of words: " + totalcount);
			rw.out.close(); 
			
		}
}

