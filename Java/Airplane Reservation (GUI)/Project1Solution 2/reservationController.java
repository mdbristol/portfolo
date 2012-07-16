/**
* reservationController.java
* 
* A class that represents the Controller for the Reservation system
*
* @author J.D. Chase 
* 
*/

public class reservationController 
{
	/**
	* represents the View for the reservation system
	*/
	protected reservationView view;

	/**
	* represents the Airplane for the reservation system
	*/
	protected Airplane plane;

        /**
	* constructor for the reservationController class
	*/
	public reservationController()
	{
		view = new reservationView();
		plane = new Airplane();
	}

	/**
	* primary controller method for the reservation system 
	*/
	public void reserve()
	{
		String choice;
		boolean done = false;

		choice = view.displayMenu(plane);
		while (!done)
		{
			
			if (choice.equals("R"))
				reserveSeat();
			else if (choice.equals("C"))
				cancelSeat();
			else if (choice.equals("VS"))
				viewSeat();
			else if (choice.equals("VP"))
				view.viewPlane(plane);
			else if (choice.equals("Q"))
				done = true;
			else
				view.invalidInput();

			if (!done)
				choice = view.displayMenu(plane);
		}
			
	}

	/**
	* cancel a seat on the plane 
	*/
	private void cancelSeat()
	{
		int row, column;

		row = view.getValidRow(plane.MAX_ROWS);
		column = view.getValidColumn(plane.MAX_COLUMNS);
		
		if (!(plane.isVacant(row, column)))
		{
			plane.vacateSeat(row, column);
		}
		else
			view.notOccupiedSeat();
	}


        /**
        * reserve a seat on the plane
        */
        private void reserveSeat()
        {
                int row, column;
                String name, address, phonenum;

                row = view.getValidRow(plane.MAX_ROWS);
                column = view.getValidColumn(plane.MAX_COLUMNS);
                
                if (plane.isVacant(row, column))
                {
                        name = view.getName();
                        address = view.getAddress();
                        phonenum = view.getPhonenum();
                        plane.setPassenger(row, column, name, address, phonenum);
                }
                else
                        view.occupiedSeat();
        }

        /**
        * view a seat on the plane 
        */
        private void viewSeat()
        {
                int row, column;

                row = view.getValidRow(plane.MAX_ROWS);
                column = view.getValidColumn(plane.MAX_COLUMNS);

                if (!(plane.isVacant(row, column)))
                {
                        view.displayPassenger(plane.getPassenger(row, column));
                }
                else
                        view.notOccupiedSeat();
        }

}

