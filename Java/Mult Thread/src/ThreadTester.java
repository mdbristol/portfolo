
public class ThreadTester {


		
		public static void main(String[] args)
		{
			final int count;
			
			String fileName;
			
			FileNames fn = new FileNames();
			
			fn.setFileNames();
			
			count = fn.count();
			
			for(int i = 0; i <= count; i ++)
			{
				fileName = fn.getFileNames(i);
				
				if(i != (count))
				{
					Runnable r = new Thread2(fileName, false);
					
					Thread t = new Thread(r);
					
					t.start();
					
				}
				else
				{
					Runnable r = new Thread2(fileName, true);
					
					Thread t = new Thread(r);
					
					t.start();
				}
			}
		}
	}



