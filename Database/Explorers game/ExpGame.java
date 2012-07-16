/**
 * ExpGame.java -- plays the explorers game
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.util.Scanner;
public class ExpGame
{
	private final int    NO_TREASURE = -1;

	private final String PLAY_MENU = "0. Quit\n" 
								   + "1. Grab treasure\n"
								   + "2. Move to next room\n"
								   + "3. List treasures in room\n"
								   + "4. List explorer's treasures\n";

	ExpDB 	  ds   = null;		// data source 
	Scanner   scan = null; 		// user input 
	Explorer  exp  = null;		// explorer for this game 

	public ExpGame(Explorer _exp, ExpDB _ds)
	{
		this.ds   = _ds;
        this.exp  = _exp;
		this.scan = new Scanner(System.in);
	}

	private void displayState()
	{
		int roomNum  = ds.getExpRoom(this.exp.getID());
		System.out.println(roomNum);  //testing if getting current room num 
		System.out.println("\n" + this.exp.getName() + " is in " + ds.getRoomDescr(roomNum));
		System.out.println(this.exp.getName() + "'s " + ds.getExpTresSummary(this.exp.getID()));
	}

	private int getTresID()
	{
		int roomNum = ds.getExpRoom(this.exp.getID());
		System.out.println(ds.getRoomTreasures(roomNum));

		System.out.print("Enter the number of the treasure to grab, 0 to cancel: ");
		int tresID = this.scan.nextInt();
		System.out.println();

		return tresID; 
	}

	/**
	 * play() -- play one game until the user quits. 
	 */
	public void play()
	{
		int     roomNum = -1;
		boolean done = false;

		this.displayState();

		while (!done)
		{
			System.out.println(PLAY_MENU);
			System.out.print("Enter choice: ");
			int userChoice = scan.nextInt();
			System.out.println();

			switch (userChoice)
			{
				case 0: done = true;
					    break; 

				case 1: int tresID = this.getTresID();
						if (tresID != 0)
						   ds.grab(this.exp.getID(), tresID);
					    break;

				case 2: roomNum = ds.move(this.exp.getID());
						if (roomNum != -1)
						   System.out.println(this.exp.getName() + " has entered " + ds.getRoomDescr(roomNum));
						else
						{
						   System.out.println(this.exp.getName() + " has exited the game\n"); 
						   System.out.println("Game Over!\n");
						   done = true; 
						}
					    break;

				case 3: roomNum = ds.getExpRoom(this.exp.getID());
						System.out.println(ds.getRoomTreasures(roomNum));
						break;

				case 4: int expID = this.exp.getID();
						System.out.println(ds.getExpTreasures(expID));
						System.out.println(ds.getExpTresSummary(expID));
						break; 

				default: System.out.println("Invalid input\n");
			}
		}
	}
}


