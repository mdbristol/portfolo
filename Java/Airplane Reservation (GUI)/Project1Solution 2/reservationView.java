/**
* reservationView.java
* 
* A class to represent the view for the reservation system 
*
* @author J.D. Chase 
* 
*/
import java.util.*;

public class reservationView 
{

        /**
	* null constructor for the reservationView class
	*/
	public reservationView()
	{

	}

	/**
	* displays the main menu for the reservation system
	* @param plane represents the Airplane for the reservation system
	* @return a string representing the user's choice  
	*/
	public String displayMenu(Airplane plane)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(plane.viewPlane()); 
		System.out.println();
		System.out.println("Press R to reserve a seat");
		System.out.println("Press C to cancel a reservation");
		System.out.println("Press VS to view a seat");
		System.out.println("Press VP to view the plane");
		System.out.println("Press Q to quit");
		return scan.nextLine();
	}

	/**
	* get a valid row from the user
	* @param maxrow the number of valid rows
	* @return a valid row from the user 
	*/
	public int getValidRow(int maxrow)
	{
		int result = 1000;
		Scanner scan = new Scanner(System.in);

		do
		{
			System.out.println("Enter row between 0 and " + (maxrow-1) + ":");
			result = scan.nextInt();
			if ((result<0) || (result >= maxrow))
				invalidInput();
		} while ((result < 0) || (result >= maxrow));	
		scan.nextLine();
		return result;
	}

       /**
        * get a valid column from the user
	* @param maxcolumn the number of valid columns
	* @return a valid column from the user
        */        
	public int getValidColumn(int maxcolumn)
        {
                int result = 1000;
                Scanner scan = new Scanner(System.in);
                
                do
                {
                        System.out.println("Enter column between 0 and " + (maxcolumn-1) + ":");
                        result = scan.nextInt();
                        if ((result<0) || (result >= maxcolumn))
                                invalidInput();
                } while ((result < 0) || (result >= maxcolumn));
		scan.nextLine();
		return result;

        }


	/**
	* reports that the requested seat is occupied 
	*/
	public void occupiedSeat()
	{
		System.out.println("Requested seat is occupied");
	}

        /**
        * reports that the requested seat is not occupied   
        */
        public void notOccupiedSeat()
        {
                System.out.println("Requested seat is not occupied");
        }


	/**
	* reports invalid input to the user
	*/
	public void invalidInput()
	{
		System.out.println("Invalid Input");
	}

       	/**
        * displays a passenger as a string
	* @param info information about a given passenger
        */
        public void displayPassenger(String info)
        {
                System.out.println(info);
        }

        /**
        * displays a plane 
        * @param plane the plane to be displayed
        */
        public void viewPlane(Airplane plane)
        {
                System.out.println(plane.viewPlane());
        }

       /**
        * get a Passenger name from the user
        * @return a Passenger name from the user
        */
        public String getName()
        {
		String name;                
		Scanner scan = new Scanner(System.in);

                System.out.println("Enter the Passenger's name: ");
                name = scan.nextLine();
                
		return name;

        }

       /**
        * get a Passenger address from the user
        * @return a Passenger address from the user
        */
        public String getAddress()
        {
                String address;
                Scanner scan = new Scanner(System.in);

                System.out.println("Enter the Passenger's address: ");
                address = scan.nextLine();
                
                return address;

        }

       /**
        * get a Passenger phone number from the user
        * @return a Passenger phone number from the user
        */
        public String getPhonenum()
        {
                String phonenum;
                Scanner scan = new Scanner(System.in);

                System.out.println("Enter the Passenger's phone number: ");
                phonenum = scan.nextLine();
                
                return phonenum;

        }



}

