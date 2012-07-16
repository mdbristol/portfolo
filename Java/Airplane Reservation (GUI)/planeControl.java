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

public class planeControl 
{


Passenger[][] plane=new Passenger[10][3]; //delcares the 2d array
PassengerGUI pass = new PassengerGUI();

public planeControl()
{
}


/** 
 * The display Plane method job is to display on the screen a picture of the plane and what is avaliable to the user.
 *
 * 
 */



/**
 * The initPlane method job is to initilzie the plane to begin with value.
 */

	public void initPlane()
	{
 

	for(int i =0; i<plane.length; i++)
	{
		for( int j=0; j<plane[0].length; j++)
		{
			plane[i][j]=null;//sets each position in the 2d array to be null
		}
	}
}

/** The isVacant method is to check to see if the place in the array is empty or not.
@param row takes an int from the user
@param col takes an int from the user
@return will return either true or false if something is found 
*/
public boolean isVacant(int row, int col)
{
	if(plane[row][col]==null)
	{
		return true;
	}
	else
		return false;
}
/** The viewseat method shows the information of a passenger
@param row takes an int 
@param col takes an int
@return return the info of a passenger
*/
public String viewseat(int row, int col)
{
	return plane[row][col].toString();
}

/** 
 * The addPassenger method takes in the data from another method and sets those parmeters into the 2d array
 @param row takes in the users row that he indicated
 @param col takes in the users col that he indicated
 */



	public void addPassenger(int row, int col  )
	{
	

	plane[row][col]= new Passenger();
	pass.setPassenger(plane[row][col]);
	pass.display();
	}
/** 
 The serachPassenger method uses a inputed string to search for a certain name inside of the 2d array 
 @param name takes in who the user whated to look for
 @return result will return a string of either the info of the passenger found or return cannot find passenger 
 */



public String searchPassenger(String name)
{
String result="Cannot find Passenger";

int row=0;
int col=0;
for(int i=0; i<plane.length; i++)
{
	for(int j =0; j<plane[0].length; j++)//searches both parts of the 2d array
	{
			if(plane[i][j]!=null)
				if(name.equalsIgnoreCase(plane[i][j].getName()))//tests the users inputed name with the name in the 2d array
				{
					row=i;
					col=j;	
				
					 result= plane[i][j].toString()+ "\nLocated in:"+ row+","+col;				
				}
	
	}
}
	
	return result;
	
		
}		
/** 
 The cancelseat method does the same thing that the addPassenger does but instead of adding the info for each passenger it resets the place in the 2d array back to null
 */
	public void cancelSeat(int row, int col)
	{
		
	
			plane[row][col]=null;//re sets the seat to null
	
	
		}
 
		
		
		

}

















