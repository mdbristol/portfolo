/**
 * This class has to do with everything dealing with the products
 */
import java.util.*;

public class Products 
{
	//instance variables 
	double finalAmount=0;
	final int MAX_ITEMS = 5;
	int coke = MAX_ITEMS;
	int dietcoke = MAX_ITEMS;
	int sprit =MAX_ITEMS;
	int mountaindew=MAX_ITEMS;
	String pas;
	
	int item;
	Scanner scan = new Scanner(System.in);
	/** 
	 * This method will display the products 
	 */
	public void listProducts()
	{
		System.out.println("Products to Purchase ");
		System.out.println("Coke");
		System.out.println("Diet Coke");
		System.out.println("Sprit");
		System.out.println("Mountain Dew");
		
		System.out.println("");
		
	}

	
	
/**
 * This class will allow the user to be able to purchase a item
 * @param amountC is a double that is sent from the addMoney method
 * @return double will return final amount of money in the machine 
 */
	 
	 
	public double selectProduct(double amountC)
	{
				
		if(amountC==1.25)
		{
		System.out.println("Products to Purchase($1.25) ");
		System.out.println("1.Coke($1.25)");
		System.out.println("2.Diet Coke($1.25)");
		System.out.println("3.Sprit($1.25)");
		System.out.println("4.Mountain Dew($1.25)");
		System.out.println("Please Select your product(#)");
		item=scan.nextInt();
		 	if(item==1&& coke!=0 )
		 	{
		 		System.out.println("You have purchase a coke");
		 		finalAmount=+1.25;
		 		amountC=0;
		 		coke = (coke-1);
		 	}
		 	
		 	else if(item==2&& dietcoke!=0 )
		 	{
		 		System.out.println("You have purchase a diet coke");
		 		finalAmount=+1.25;
		 		amountC=0;
		 		dietcoke = (dietcoke-1);
		 	}
			else if(item==3&& sprit!=0 )
		 	{
		 		System.out.println("You have purchase a sprit");
		 		finalAmount=+1.25;
		 		amountC=0;
		 		sprit = (sprit-1);
		 	}
			else if(item==4&& mountaindew!=0 )
		 	{
		 		System.out.println("You have purchase a mountaindew ");
		 		finalAmount=+1.25;
		 		amountC=0;
		 		mountaindew = (mountaindew-1);
		 	}
			else
				System.out.println("Product not available");
		 	
	    }
		else 
			System.out.println("Not enouch money");
			return finalAmount;
}
	
	/**
	 * Will restock the machine when the items are not full
	 */
	
	public void restockItem()
	{
		
			boolean restockItems = true;
			
			System.out.println();
			System.out.print("Please put in pass-code: ");
			String code = scan.nextLine();
			
			if(code.equals("openopen"))
			{
				if(coke < MAX_ITEMS || dietcoke < MAX_ITEMS || sprit < MAX_ITEMS || mountaindew < MAX_ITEMS)
				{
					while(restockItems)
					{
						System.out.println();
						System.out.println("Select a beverage to restock");
						System.out.println();
						System.out.println("1. Coke: " + coke);
						System.out.println("2. Diet Coke: " + dietcoke);
						System.out.println("3. Sprit: " + sprit);
						System.out.println("4. Mountain Dew: " + mountaindew);
						System.out.println();
						System.out.print("Select an option: ");
						int choice = scan.nextInt();
				
						if(choice ==1)
						{
								if (coke < MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Coca-Cola has been restocked");
									coke = MAX_ITEMS;
								}
								else if(coke == MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Coca-Cola stock is full");
								}
								restockItems = false;
						}
							
						else if(choice ==2)
						{
								if (dietcoke < MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Diet Coke has been restocked");
									dietcoke = MAX_ITEMS;
								}
								else if(dietcoke == MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Diet Coke stock is full");
								}
								restockItems = false;
						}
								
						else if(choice ==3)
						{
								if (sprit < MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Sprite has been restocked");
									sprit = MAX_ITEMS;
								}
								else if(sprit == MAX_ITEMS)
								{
									System.out.println();
									System.out.println("Sprite stock is full");
								}
								restockItems = false;
						}
						else if(choice ==4)
						{
								if (mountaindew< MAX_ITEMS)
								{
									System.out.println();
									System.out.println("mountain dew has been restocked");
									mountaindew = MAX_ITEMS;
								}
								else if(mountaindew == MAX_ITEMS)
								{
									System.out.println();
									System.out.println("mountain dew stock is full");
								}
								restockItems = false;
						}
						else
						{
								System.out.println();
								System.out.println("INVALID OPTION");
						}
								
						}
					
					}
			
				else
				{
					System.out.println();
					System.out.println("Machine is full");
				}
				
				}
			else
			{
				System.out.println();
				System.out.println("ACCESS DENIED");
			}
			}
		
		}
