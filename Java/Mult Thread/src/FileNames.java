import java.util.*;
public class FileNames 
{
	boolean test = true;
		public void setFileNames()
		{	
			System.out.println("Enter a filename for a .txt or .java file.");
				
			in = new Scanner(System.in);
				
			filename = in.nextLine();
			
			
			while(filename.equals(test))
			{
				System.out.println("If you would like to exit, please enter exit at the command prompt.\n" +
						                "Please re-enter a filename for a .txt or .java file.");
				
				in = new Scanner(System.in);
					
				filename = in.nextLine();
				
				if(filename.equalsIgnoreCase("exit"))
				{
					test=false;
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
		
		private Scanner in;
		private String filename;
		private String token[];
		private int count;
		private int i;

		
	}




