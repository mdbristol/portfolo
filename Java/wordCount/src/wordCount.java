

public class wordCount 
{

	public static void main(String[] args) 
	{
		
		Runnable r = new Thread (args[0]);
		Thread t = new Thread(r);
		t.start();
		Runnable r2 = new Thread (args[1]);
		Thread t2 = new Thread(r2);
		t2.start();
		
		
	}
	
	
}
