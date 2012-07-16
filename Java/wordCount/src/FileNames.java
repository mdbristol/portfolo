import java.util.Scanner;
import java.util.StringTokenizer;


public class FileNames {

	private Scanner in;
	private String filename;
	private String token[];
	private int count;
	private int i;
	
		public void setFileNames()
		{	
			
				
			in = new Scanner(System.in);
				
			filename = in.nextLine();
			
			while(filename.equals(""))
			{
				
				
				in = new Scanner(System.in);
					
				filename = in.nextLine();
				
				if(filename.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				
			}
			
			StringTokenizer st = new StringTokenizer(filename);
			
			count = st.countTokens();
			
			token = new String[count];
			
			i = 0;
			
			while(st.hasMoreTokens())
			{
				token[i] = st.nextToken();
				i++;
			}
			
			in.close();

		}
			
		public String getFileNames(int i)
		{
			return token[i];
		}
		
		public int count()
		{
			return (token.length - 1);
		}
		
	

		
	}



