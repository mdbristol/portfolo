/**
 * Treasure.java -- Represents a single treasure in the Explorer's game.
 * 
 * @author  Jeff Pittges 
 * @version Jun-2011
 */
public class Treasure
{
    // instance variables 
	private int    id;				// Treasure identifier 
    private String name;            // Name of this treasure 
    private String description;     // A short description of this treasure
    private int    value;           // How much is this treasure worth? 
    private double weight;          // How much does this treasure weigh?  

    /**
     * Constructor for objects of class Treasure
     */
    public Treasure(String _name, String _descr, int _val, double _weight, int _id)
    {
        // initialize instance variables
		this.id   = _id;
        this.name = _name;
        this.description = _descr;
        this.value  = _val;
        this.weight = _weight; 
        
    }

	public String getName()
	{
		return this.name;
	}

	public int getID()
	{
		return this.id;
	}

    /**
     * toString() -- Return a string representation of a treasure. 
     * 
     * @return     a string that describes the treasure  
     */
    public String toString()
    {
        String tres = this.name + " -- "; 
        tres += this.description + "\n";
        tres += "value: " + this.value + "  weight: " + this.weight + "\n";
        
        return tres; 
    }
}









