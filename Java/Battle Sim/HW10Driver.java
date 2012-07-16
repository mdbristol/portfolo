import java.util.*;
/** This class is to going to act as the main driver where it is going to call and pass information to other classes. It also determines the command input from the user to  begin this battle.
This program as a whole is using a total of 4 classes to make and store pokemon and Trainers in arrays by inputing mult varables for those arrays. From the trianers will then battle with there pokemon.
*/
public class HW10Driver
{
	public static void main (String[] args)
	{
	Scanner scan = new Scanner(System.in);//creates an object 
	String command;//pre sets
	command=scan.nextLine();//asks for a command from the user
	HW10Trainer[] people = new HW10Trainer[10];//sets a max number in the array that can hold the trianers 
	int numTrainer=0; //sets a count up for the real ammount of trainers used
	HW10Battle time = new HW10Battle();//makes an object from the other classe to be used in the driver to be able to pass infomration to it
	
	while(!command.equals("quit"))//runs the program intill user typs quit
	{
		if (command.equals("addTrainer"))
		{
			people[numTrainer]=new HW10Trainer();//helps set up the array to hold mult trainers
			people[numTrainer].readInfo(scan);//read the readInfo of the trainer class
			numTrainer++;//goes up by one for every trainer added
			
		}
		
		else if (command.equals("battle"))
		{
			
			time.Beginattack(people,numTrainer,scan);//sends information to the battle class 
			
		}
		command=scan.nextLine();//re reads the command line
	

	}
	
	}
}
	
	

	
	
