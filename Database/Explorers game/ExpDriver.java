/**
 * ExpDriver.java -- Driver class for the Explorers game. 
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.util.Scanner; 

public class ExpDriver
{
	public static void main(String[] args)
	{
		// initialize the game 
		ExpDB ds = new ExpDB();
		
		/********************/
		/* Get the Explorer */
		/********************/
		
		Scanner scan = new Scanner(System.in);

		// prompt for the player's username
		System.out.print("\nEnter username: ");
		String username = scan.next(); 

		Explorer exp = ds.getExplorer(username);
		//System.out.println(ds.getNextRoom(1));   ///testing next room but having problem with the private 

		if (exp != null)
		{
           ExpGame game = new ExpGame(exp, ds);
		   game.play();
		}
		else
		   System.out.println("\nERROR: No explorer found for " + username + "\n");
				
		ds.close(); 
	}
}


