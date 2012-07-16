/**
* Passenger.java
* 
* A class to represent a single passenger including the name, address,
* and phone number of the given passenger
*
* @author J.D. Chase 
* 
*/

public class Passenger
{
	/**
	* a String to represent the name of the Passenger
	*/ 
	protected String name;

	/**
	* a String to represent the address of the Passenger
	*/	
	protected String address;
	
	/**
	* a String to represent the phone number of the Passenger
	*/
	protected String phonenum;

        /**
	* null constructor for the Passenger class
	*/
	public Passenger()
	{
		name = null;
		address = null;
		phonenum = null;
	}

	/**
	* a constructor for the Passenger class that adds the name, address,
	* and phonenum
	*
	* @param _name name of the new passenger
	* @param _address address of the new passenger
	* @param _phonenum phonenum of the new passenger
	*
	*/
	public Passenger(String _name, String _address, String _phonenum)
	{
		name = _name;
		address = _address;
		phonenum = _phonenum;
	}

	/**
	* Returns Passenger name
	* @return The name of the passenger 
	*/
	public String getName()
	{
		return name; 
	}

	/**
	* Returns Passenger address
	* @return The address of the passenger 
	*/
	public String getAddress()
	{
		return address;	
	}

	/**
	* Returns Passenger phone number
	* @return The  passenger's phone number
	*/
	public String getPhonenum()
	{
		return phonenum;
	}

        /**
	* Sets the Passenger name
        * @param _name new name of the Passenger
  	*/
	public void setName(String _name)
	{
		name = _name;
	}

	/**
	* Sets the Passenger address
	* @param _address new address of the Passenger
	*/
	public void setAddress(String _address)
	{
		address = _address;
	}

	/**
	* Sets the Passenger phone number
	* @param _phonenum new phone number of the Passenger
	*/
	public void setPhonenum(String _phonenum)
	{
		phonenum = _phonenum;
	}

	/**
	* Formats an output string representing the Passenger
	* @return a String representing passenger information
	*/
	public String toString()
	{
		String result = name + "\n" + address + "\n" + phonenum;
		return result;
	}
}

