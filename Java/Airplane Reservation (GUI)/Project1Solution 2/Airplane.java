/**
* Airplane.java
* 
* A class to represent the seating on an airplane 
*
* @author J.D. Chase 
* 
*/

public class Airplane 
{
	/**
	* a 2-D array of Passengers
	*/ 
	protected Passenger[][] plane;

        /**
	* constant to represent the number of rows on the plane
	*/
	public static final int MAX_ROWS = 20;

	/**
	* constant to represent the number of columns on the plane
	*/
	public static final int MAX_COLUMNS = 6;

        /**
	* null constructor for the Airplane class
	*/
	public Airplane()
	{
		plane = new Passenger[MAX_ROWS][MAX_COLUMNS];
	}

	/**
	* Returns a String representing a particular Passenger 
	* @return The passenger
	* @param row the row of the passenger to be returned
	* @param column the column of the passenger to be returned 
	*/
	public String getPassenger(int row, int column)
	{
		return plane[row][column].toString(); 
	}

	/**
	* Assigns a seat on the plane to a particular Passenger
	* @param row the row of the Passenger to be assigned
	* @param column the column of the Passenger to be assigned
	* @param name the name of the Passenger to be assigned
	* @param address the address of the Passenger to be assigned
	* @param phonenum the phone number of the Passenger to be assigned
	*/
	public void setPassenger(int row, int column, String name, String address, String phonenum)
	{
		plane[row][column] = new Passenger(name, address, phonenum);
	}

	/**
	* Determines whether a particular seat is vacant 
	* @return whether the particular seat is vacant 
	*/
	public boolean isVacant(int row, int column)
	{
		return (plane[row][column] == null);
	}

        /**
	* Vacates the given seat 
        * @param row the row of the seat to be vacated
	* @param column the column of the seat to be vacated 
  	*/
	public void vacateSeat(int row, int column)
	{
		plane[row][column] = null;
	}

	/**
	* View the entire plane
	*/
	public String viewPlane()
	{
		String result = "";
		for (int i=0; i < plane.length; i++)
		{
			for (int j=0; j < plane[0].length; j++)
			{
				if (plane[i][j] == null)
					result = result + " ";
				else
					result = result + "X";
			}
			result = result + "\n";
		}
		return result;
	}
}

