



	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	public class Thread2 implements Runnable
	{
		public Thread2(String fn, Boolean l)
		{
			filename = fn;
			last = l;
		}

		@Override
		public void run() 
		{
			
			tot = new Total();
			
			try
			{

					rf = new Scanner(new File(filename));
					
					while(rf.hasNext())
					{
						rf.next();
						count ++;
					}
					
					
					tot.setTotal(count);
					
					if(last == false)
					{
						System.out.println(filename + ":" + count + "words ");
					}
					else if(last == true)
					{
						System.out.println(filename + ":" + count + "words ");
						
						System.out.println("Total: " + tot.getTotal());
					}
					
					rf.close();
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File " + filename + " was not found.");
			}
		}
		
		private String filename;
		private Boolean last;
		private Scanner rf;
		private int count = 0;
		private Total tot;

	}




