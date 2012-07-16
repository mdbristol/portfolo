/** 
*Michael Bristol
*2/1/2009
*
*Passenger class

The Passenger class job is to make mult objects of passengers to be used in a 2d array.

*/
import java.util.*;

public class Passenger
{

private String  name ;//creates a String that is private so that name cannot be changed from the outside
private String address ;
private int  number ;//Creates a integer that is private 
Scanner scan = new Scanner(System.in);//allows users to input data from the keyboard
/** The Passenger is a constructer for the Passenger class that initailzies the private variables
 * @param nameP takes a String from another class
 * @param addressP takes a String from another class
 * @param phone takes a integer from another class
 */
public Passenger(String nameP, String addressP,int phone)
{
name=nameP;//this is done because the variable is prviate it is copyed so that the real value is not changed
address=addressP;//copyed variable
number=phone;//copyed variable
}

/** 
 * getName returns the name of the Passenger when called
 * @return name returns a string
 */
public String getName()
{
	return name;
}
/**
 * getAddress returns the address of the Passenger when called
 *@return address returns a String
 */

public String getAddress()
{
	return address;
}

/** 
 *getNumber returns the number of the Passenger when called
 @return number returns a integer
 */
public int getNumber()
{
	return number;
}
/** 
 * The enterInfo method asks information for each of the passengers created from this class

*/
/*
public void  enterInfo()
{
System.out.println("Enter your name: ");
name=scan.nextLine();
System.out.println("Enter your Address: ");
address=scan.nextLine();
System.out.println("Enter your Phone Number: ");
number=scan.nextInt();
scan.nextLine();
}
*/













}

