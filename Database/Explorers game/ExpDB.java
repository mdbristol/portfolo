/**
 * ExpDB.java -- implements a database data source for the Explorers game.
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.sql.*;

public class ExpDB 
{
	Connection conn = null; 

	public ExpDB()
	{
		String user = "mdbristol";
		String pass = "football09";

		try
		{
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",
                                                     user, pass);
		}

		catch (SQLException e){System.out.println ("Could not connect to the db. "+e);}
	}

    /**
     * getExplorer() -- retrieve the explorer 
     *
     * @returns - the explorer associated with username, null if not found.
     */
    public Explorer getExplorer(String username)
	{
		Explorer exp = null;

		String query = " SELECT * FROM Explorer " 
					 + " WHERE username = '" + username + "' ";

		try
		{
			Statement stmt = conn.createStatement ();
        	ResultSet rset = stmt.executeQuery (query);
        	if (rset.next ()) 
			{
				int    id   = rset.getInt("EID");
				String name = rset.getString("Name");
				exp = new Explorer(name, id);
        	}
		}
		catch (SQLException e){System.out.println ("ERROR: Could not get explorer. \n"+e);}

		return exp;
	}
    
    /**
     * getNextRoom() -- retrieves the room connected to the given room. 
     *
     * @param roomNum - number of the room. 
     * @returns room number of the connecting room or -1. 
     */
	 
	 ///had to make public to read in values need to move it back to private
    private int getNextRoom(int roomNum)
	{
		int next= -1; // was set to zero but not set back to what the program was when gotten 2
		String query = " SELECT Next FROM Room Inner Join Explorer On Explorer.Room_Num = Room.rid WHERE Explorer.Room_Num = '" + roomNum + "' ";


		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery (query);
			
			if (rset.next())
			{
				next = rset.getInt("Next");
			}

		}
		catch (SQLException e) {System.out.println ("Error: could not find next Room. \n" +e);}
		return next; 
	
	}

	/**
	 * getExpRoom() -- retrieves the current room for the given explorer. 
	 *
	 * @param expID - identifier of the explorer 
	 * @returns the number of the explorer's current room.  
	 */ 
	public int getExpRoom(int expID)
	{
		int roomNum = -1; 
	
	String query = " SELECT Room_Num FROM Explorer  WHERE eid = '" + expID + "' ";
	//String queryR = "Update Explorer SET Room_Num = 1 WHERE eid = '" + expID + "'";

		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery (query);
			
			if (rset.next())
			{
				roomNum = rset.getInt("Room_Num");
				//if (roomNum == -1)
					
				//	Statement stmt2 = conn.createStatement();
				//	stmt2.executeUpdate(queryR);
			}

		}
		catch (SQLException e) {System.out.println ("Error: could not find User Current Room. \n" +e);}
		return roomNum; 
		
	}

	/**
	 * getExpTresSummary() -- retrieves a summary of the explorer's treasures. 
	 *
	 * @param expID - identifier for the explorer 
	 * @returns a summary of the explorer's treasures. 
	 */
	public String getExpTresSummary(int expID)
	{
		int    count = 0;
		int    value = 0;
		double weight = 0.0; 

		String query1 = " SELECT count(*) from Explorer_Treasure where eid = '" + expID + "'";
		String query2 = " Select Sum(Value) from Treasure Inner Join Explorer_Treasure On Explorer_Treasure.tid = Treasure.tid Inner Join Explorer On Explorer.eid = Explorer_Treasure.eid where Explorer.eid = '" + expID + "'";
		String query3 = 	"Select Sum(Weight)  From Treasure inner join Explorer_Treasure On Explorer_Treasure.tid = Treasure.tid Inner Join Explorer On Explorer.eid = Explorer_Treasure.eid where Explorer.eid = '" + expID + "'";

		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset1 = stmt.executeQuery (query1);
			
			Statement stmt1 = conn.createStatement ();
			ResultSet rset2 = stmt1.executeQuery (query2);
			
			Statement stmt2 = conn.createStatement ();
			ResultSet rset3 = stmt2.executeQuery (query3);
			
			if (rset1.next())
			{
				count  = rset1.getInt("count(*)");
				//if (roomNum == -1)
					
				//	Statement stmt2 = conn.createStatement();
				//	stmt2.executeUpdate(queryR);
			}
			if (rset2.next())
			{
				value = rset2.getInt("Sum(Value)");
			}
			if(rset3.next())
			{
				weight = rset3.getDouble("Sum(Weight)");
			}
			

		}
		catch (SQLException e) {System.out.println ("Error: could not find User Current Room. \n" +e);}			
			
		return ("Treasure count: " + count + "   Total value: " + value + "   Total weight: " + weight + "\n"); 
	}

	/**
	 * getRoomDescr() -- retrieve a description of the given room. 
	 *
	 * @param roomNum - number of the room to be described. 
	 * @returns a description of the given room. 
	 */ 
	public String getRoomDescr(int roomNum)
	{
		String name      = "";
		String descr     = "";
		int    tresCount = 0;
		
		String query = " SELECT count(tid) , Room.Name, Room.Descr FROM Room Inner join Room_Treasure ON Room_Treasure.rid = Room.rid  WHERE Room.rid = '" + roomNum + "' Group by Room.Name , Room.Descr";


		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery (query);
			
			if (rset.next())
			{
				name = rset.getString("Name");
				descr = rset.getString("Descr");
				tresCount = rset.getInt("count(tid)");
			}

		}
		catch (SQLException e) {System.out.println ("Error: Cannot find the room or description of room. \n" +e);}

		return (name + " -- " + descr + "\nTreasure count: " + tresCount + "\n");
	}

    /**
     * move() -- move the given explorer to the next room.
     *  
	 * @param expID - identifier of the explorer to be moved 
     * @returns -- the number of the new room or -1
     */
	 
	 //need to find out how to restart the game ? 
	 
	public int move(int expID)
	{
		int nextRoom = getNextRoom(getExpRoom(expID));

		String query = "Update Explorer SET Room_Num = '" + nextRoom + "' WHERE eid = '" + expID + "'";
		
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			}
			catch (SQLException e) {System.out.println ("Error: cannot move the explorer. \n" +e);}
		return nextRoom;
	}

	/**
	 * makeTreasureList() -- given a result set with treasures, use the Treasure.toString
	 * 						 method to construct one string that lists all of the treasures. 
	 * @param rset -- result set with zero or more treasures.
	 * @returns a string describing zero or more treasures. 
	 
	 */ 
	 
	 
	private String makeTreasureList(ResultSet rset)
	{
		String   tresList = "\n"; 
		Treasure tres     = null; 
		String name = "";
		String descr = "";
		int tid = 0;
		int value = 0;
		Double Weight = 0.0;
		
		//4 local var 
		try
		{
			while (rset.next())
			
			{
					name = rset.getString("Name");
					descr = rset.getString("Descr");
					tid = rset.getInt("tid");
					value = rset.getInt("Value");
					Weight = rset.getDouble("Weight");
					tres = new Treasure(name, descr, value, Weight, tid);
					tresList += tres.getID() + ": " + tres + "\n";
					
			}
		}
		catch (SQLException e) {System.out.println ("Error: Could not loud Treasures \n" +e);}
		return tresList; 
	}

	/**
	 * getRoomTreasures() -- retrieve all of the treasures in the given room and return
	 * 						 a single string that lists the treasures from highest to
	 * 						 lowest value. 
	 * @param roomNum - identifier for the room with the treasures
	 * @returns a string describing zero or more treasures.
	 */ 
	public String getRoomTreasures(int roomNum)
	{
		String tresList = "No Treasure"; 
		

		String query = " SELECT * from Treasure Inner Join Room_Treasure ON Room_Treasure.tid = Treasure.tid Inner Join Room ON Room_Treasure.rid = Room.rid   WHERE Room.rid = '" + roomNum + "' ";


		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery (query);
			
			
				tresList = makeTreasureList(rset); 
				
				
			
			
		}
		catch (SQLException e) {System.out.println ("Error: Cannot find the room or description of room. \n" +e);}	
		
		//tresList = makeTreasureList(tresList);
		return tresList; 
	}

	
	
	/**
	 * getExpTreasures() -- retrieve all of the treasures the given explorer is carying 
	 * 					 	and return a single string that lists the treasures from 
	 * 					 	highest to lowest value. 
	 * @param expID - identifier for the explorer carryingh the treasures
	 * @returns a string describing zero or more treasures.
	 */ 
	public String getExpTreasures(int expID)
	{
		String tresList = "No treasure "; 
		
		
			String query = " SELECT * from Treasure Inner Join Explorer_Treasure ON Explorer_Treasure.tid = Treasure.tid Inner Join Explorer ON Explorer.eid  = Explorer_Treasure.eid   WHERE Explorer.eid = '" + expID + "' ";


		try
		{
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery (query);
			
			tresList = makeTreasureList(rset); 
				
				
			
			
		}
		catch (SQLException e) {System.out.println ("Error: Cannot find the room or description of room. \n" +e);}	
		return tresList; 
	}

	/**
	 * grab() -- remove the given treasure from the given room 
	 *           and put the treasure in the explorer's bag. 
	 *
	 * @param expID  - identifies the explorer 
	 * @param tresID - identifies the treasure to be grabbed 
	 */
	 
	 //transaction
	 //prepare call 
	 //disable auto commit 
	 // need to commit or rollback 
	public void grab(int expID, int tresID)
	{


	

	try 
	{
	 CallableStatement call = conn.prepareCall (" call grab(?,?)");
	 call.setInt(1,expID);
	 call.setInt(2,tresID);
	 call.execute();
	 }
	 
	  catch (SQLException e){System.out.println ("Could not load the db"+e); 
     }
	 

	
			
			
					
	



	}

	/**
	 * close() -- clean up and close the data source.
	 */
	public void close()
	{
		try
		{
			this.conn.close(); 
		}
		catch (SQLException e){System.out.println ("ERROR: Could not close db connection. \n"+e);}
	}
}


