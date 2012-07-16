/**
 * This class job is to provide the user with the options for the program. The menu will then call certain methods to complete its objective.
 */
import java.util.*;


public class Menu
{
//objects
Scanner scan = new Scanner(System.in);
Products item = new Products();
Coin money = new Coin();
//instance variables
double menuOption;
double amountC =0;
double machineA;
/**
 * Displays the menu for the user. to quit select 7
 */
	public void menu()
	{
		System.out.println("Welcome to Radfords Vending Machine");
		System.out.println("");
		while(menuOption!=7)
		{
			System.out.println("1.List avialable Products");
			System.out.println("2.Add Coins");
			System.out.println("3.Return Coins");
			System.out.println("4.Purchase a Product");
			System.out.println("5.Empty Money Box");
			System.out.println("6.Restock Items");
			System.out.println("7.Exit");
			System.out.print("Please select the following Option(#): ");
			System.out.println("");
			menuOption=scan.nextDouble();
			this.action(menuOption);
		
		}
	
	
		
	}
	/**
	 * This method will take the number selected and call the main methods for it
	 * @param c is a double that is being sent from the menu that the user picked
	 */
	public void action(double c)
		{
		
		if(c==1)
			{
			item.listProducts();//displays list of products
			}
		if(c==2)
			{
		    amountC = money.addCoin();///user adds money
			}
		if(c==3)
			{
			money.returnCoin(amountC);//user is able to get money back
			}
		if(c==4)
			{
		 machineA = item.selectProduct(amountC);///buys a product
			}
		if(c==5)
			{
			money.emptyMachine(machineA);//emptys the machine 
			}
		if(c==6)
			{
			item.restockItem();//restocks items 
			}
		if(c==7)
			{
			System.out.println("Thank you and Good-Bye");
			}
		}
	

	
}
