/** 
 *
 * Michael Bristol
 * 2/3/10
 *
 * Menu class
 * 
 * The Menu class displays the users choices that the user my pick. After the pick the choice is then sent to the Plane class where that choice is excuted by a method.
 */
import java.util.*;
public class Menu

{
Scanner scan = new Scanner(System.in);//allows the users to input data by the keyboard
String choice="";//sets a pre value
Plane plane= new Plane();//declares a object
boolean display = false;//boolean that is used to initlize the displayPlane method only once
public void  displayMenu()
{
System.out.println("------------------------------");
System.out.println("------------------------------");
System.out.println("---Weclome to Joes Airlines---");
System.out.println("------------------------------");

while(!choice.equals("quit"))//if the users does not type quit then display the menu after the command for that option has been completed
	{
if(!display)//makes the boolean false so that it can run once
{
	plane.initPlane();//initlizees the plane 
	display=true;//sets the boolean to true and ends the if statement
}
System.out.println();
System.out.println("Menu");
System.out.println("1. Reserve(Seat)");
System.out.println("2. Cancel(Seat)");
System.out.println("3. Seat(View)"); 
System.out.println("4. Plane(View)");
System.out.println("5. Search(Name)");
System.out.println("6. Quit(System)");

System.out.println("Enter Users Choice: ");
choice = scan.nextLine();
this.action(choice);//sends the users choice to the method below
	}

}
/** 
 * The action classes takes in the usesr choice and then determines the correct response to send to the Plane Clas.
 * @param c takes in a string that is what the user input from the menu to do
 */

public void action(String c)
{
	if(c.equals("reserve"))//if the command was to reserve
			{
				plane.makeReservation();//calls the method
			}
	 if (c.equals("cancel"))//if the commmand was to cancel
		{
		plane.cancelSeat();//calls the method
		}
	 if (c.equals("seat"))//if the command was to view the seat
		{
		plane.displaySeat();//calls the displayseat method
		}
	 if (c.equals("plane"))//if the command was to view the plane
		{
		plane.displayPlane();//calls the displayPlane method
		}
	 if (c.equals("search"))//of the command was to serach for a passanger
		{
		System.out.println("Enter the person you would like to look for. (first name) : ");
		String name= scan.nextLine();
		plane.searchPassenger(name);//sends the name inputed to the plane class
		}
		else if (c.equals("quit"))//if chooice is quit then it ends the program
			System.out.println("Thank you for using Joe's Airline");
}
}
