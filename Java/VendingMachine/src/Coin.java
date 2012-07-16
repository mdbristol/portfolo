/**
 * This class will have to do will everything having to do with money
 */
import java.util.*;


public class Coin 
{
	//instance variables 
	double amount;
	int choice;
	String pas;
	
	Scanner scan = new Scanner(System.in);
	Products item = new Products();
	
	/**
	 * This method will allow the user to add money into the machine 
	 * @return double amount will give the user the amount of money he or she has entered
	 */
	public double addCoin()
	{
		boolean amountTotal =true;
		System.out.println("Please enter the amount of money: ");
		amount=scan.nextDouble();
	
	while(amountTotal)
	{
		if(amount==1.25)
		{
			System.out.println("You can now purchase a drink");
		
			amountTotal=false;
		}
		else if (amount>1.25)
		{
			System.out.println("You have change" + (amount-1.25));
			amount=1.25;
			amountTotal =false;
			
		}
		else if (amount<1.25)
		{
			System.out.println("Please add more money, You need" + (1.25-amount));
			amount+=scan.nextDouble();
			
		}
		
		
		
		
	}
	return amount; 
	
	
}
	/**
	 * This class will allow the user to try to get his money back
	 * @param c takes in the amount the user has entered
	 */
	public void returnCoin(double c)
	{
		boolean returnC = true;
		while(returnC)
		{
		System.out.println("Would you like your coints return?");
		System.out.println("yes or no");
		String rCoin = scan.nextLine();
		
		if(rCoin.equals("yes")&& c!=0)
		{
			System.out.println("You have recived: " + amount + " back");
			amount=0;
			returnC= false;
			
		}
		else 
		{
			System.out.println("You have not entered any coins");
			returnC=false;
		}
	}
	}
	/**
	 * This method will allow the user to empty all the money out of the machine 
	 * @param machineA takes in the total amount of money in the machine 
	 */
	public void emptyMachine(double machineA)
	{
	
		
		System.out.println("Please enter pass-code");
		 pas = scan.nextLine();
		
		  if(pas.equals("openopen"))
		  {
				if(machineA !=0)
				{
					System.out.println();
					System.out.println("Money box amount: " + "$" + machineA);
					System.out.println("Would you like to empty the money box?");
						System.out.println();
						System.out.println("1. YES");
						System.out.println("2. NO");
						System.out.println();
						System.out.print("Select an option(#): ");
						choice = scan.nextInt();
				}
				if(choice == 1)
				{
					System.out.println("Box has been emptyed");
					machineA=0;
				}
				else
					System.out.println("There is no money in the box,please have a nice day");
		 
		  }
		  else
				 System.out.println("Incorrect password");
}
}