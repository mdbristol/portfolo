/** 
 * Michael Bristol
 * 2/3/10
 *
 * Plane Class
 *
 * This class is meant to run all the methods that the user can choose from. The plane class will take in objects from other classes and also will make the 2d array that is going to hold objects of Passengers.
 *
 */

import java.util.*;

public class Plane
{

Scanner scan = new Scanner(System.in);//allows the user to input information by keyboard
Passenger[][] plane; //delcares the 2d array
Passenger pas = new Passenger("blank", "blank", 703 );///sets a pre passenger 

/** 
 * The display Plane method job is to display on the screen a picture of the plane and what is avaliable to the user.
 *
 * 
 */
public void displayPlane()
{	System.out.println("");
	System.out.println("O = Avaliable ");//Prints O for seats that are empty
	System.out.println("X = Unavaliable ");//Prints X for seats that are filled
	System.out.println("");
	for(int i =0; i <plane.length; i++)//goes through the 2d array for the first [] or row 
	{
		for( int j=0; j<plane[0].length; j++)//goes through the 2d array for the second[] or col
		{
			if(plane[i][j]== null)//if the plane has nothing in it or has null which means noting 
			
				System.out.print("O");
			else//if anything but null is printed in
				System.out.print("X");
		}
		System.out.println();
	}

}
/**
 * The initPlane method job is to initilzie the plane to begin with value.
 */

	public void initPlane()
	{
	plane= new Passenger[10][3];//creats the 2d array named plane with the size 

	for(int i =0; i<plane.length; i++)
	{
		for( int j=0; j<plane[0].length; j++)
		{
			plane[i][j]=null;//sets each position in the 2d array to be null
		}
	}
}
/** 
 * The addPassenger method takes in the data from another method and sets those parmeters into the 2d array
 @param row takes in the users row that he indicated
 @param col takes in the users col that he indicated
 */

	public void addPassenger(int row, int col  )
	{
	System.out.println("Enter your name: ");
	String name = scan.nextLine();
	System.out.println("Enter your Address: ");
	String address=scan.nextLine();
	System.out.println("Enter your Phone Number: ");
	int number=scan.nextInt();
	scan.nextLine();
	plane[row][col]= new Passenger(name, address, number);//sets the certain position in the 2d array to the Passengers info
	}
/** 
 * The make Reservation class checks the row and col inputed in the user and sends it to the addPasseger method.
 */
	public void makeReservation()
	{
	System.out.println("Please enter the row you wish to seat in:(1-10) ");
	int row = scan.nextInt();//sets the row
	row--;//sets the row to one less so that the user can not worry about the computer language
	System.out.println("Please enter the col you wish to seat in:(1-3) ");
	int col= scan.nextInt();
	scan.nextLine();
	col--;///sets the col by one less
		if(row>9 || col>2 || row<0 || col<0)//tests the bounds of the 2d array 
		{
			System.out.println("Please choose a new seat, seat is not there");
		}
		else if(!(plane[row][col] ==null))//if the seat is not set to null then a passager is already there
		{
			System.out.println("Seat is taken");
		}
		else
		{
			
			this.addPassenger(row,col	);//sends the row, col, and info that the users inputed to the other medthod			 
		}
	}
/**
 The serachPassenger method uses a boolean(true or false) to search for a certain name inside of the 2d array and when found returns true to stop the search
 @param name takes in who the user whated to look for
 @return found gets either true or false that will end or start the search call
 */
public boolean searchPassenger(String name)
{
Boolean found = false;//starts the search at false
for(int i=0; i<plane.length; i++)
{
	for(int j =0; j<plane[0].length; j++)//searches both parts of the 2d array
	{
		if(plane[i][j] !=null)//if the seat has anyhting but null
				if(name.equals(plane[i][j].getName()))//tests the users inputed name with the name in the 2d array
				{
					System.out.println(plane[i][j].getName()+ " is in seat");
					System.out.print(i+1+ ",");//sets the row by +1
					System.out.println(j+1);//sets the col by +1
					System.out.println("Address: " + plane[i][j].getAddress());
					System.out.println("Phone Number: " + plane[i][j].getNumber());
					found=true;//stops the search if found
				}
	}
}
if(!found)//if not found in the 2d array
System.out.println("Name is not on plane");
return found;
}
/** 
 The cancelseat method does the same thing that the addPassenger does but instead of adding the info for each passenger it resets the place in the 2d array back to null
 */
	public void cancelSeat()
	{
		System.out.println("Enter row of seat: (1-10) ");
		int row = scan.nextInt();
		row--;//sets the row by one less
		System.out.println("Enter col of seat:(1-3) ");
		int col = scan.nextInt();
		scan.nextLine();
		col--;//sets the col by one less
		if(row>9 || col>2|| row<0 || col<0)//tests the boundries of the 2d array
		{
			System.out.print("Seat is not on Plane!");
		}
		else if(plane[row][col]==null)//if the seat has nothing in it or null
			{
			System.out.println("Seat is already empty");
			}
			else
			{
			plane[row][col]=null;//re sets the seat to null
			System.out.println("Reservation is now Canceled ");	
	 		}	
	
		}
/** 
 * The displaySeat method displays the place and information of a seat that the user would like to see. Almost like the displayPlane method only that in stead of using a 2d array and displaying X or O it displays the information in that certain spot in the 2d array.
 */
		
		public void displaySeat()
	{
		System.out.println("Enter row of seat: (1-10)");
		int row=scan.nextInt();
		row--;//sets on less to the row
		System.out.println("Enter col of seat: (1-3)");
		int col=scan.nextInt();
		scan.nextLine();
		col--;//sets one less to the col
		if(row>9 || col>2||row<0 || col<0)//checks the boundries of the 2d array
		{
			System.out.println("Seat is not on Plane");
		}

		else if(plane[row][col] != null)//if the 2d array is not set to null
		{
			System.out.println("Passenger in " + (row+1) + "," +( col+1) + " is " + plane[row][col].getName());//gets the name of the passenger from the Passenger Class and also resets the row and col up by one
			System.out.println("Address: " + plane[row][col].getAddress());//gets the address from the Passenger class
			System.out.println("Phone Number: " + plane[row][col].getNumber());//gets the number from the passenger class
		}
		else//if nothing else true 
		{
			System.out.println("No passenger is in that seat");
		}
	}	

}

















