/**
 * Represents a single explorer in the Explorer's game.
 * 
 * @author  Jeff Pittges 
 * @version Jun-2011
 */
public class Explorer
{
    // instance variables 
	private int      id;			// this explorer's unique identifier 
    private String   name;          // the name of this explorer 

    /**
     * Constructs one Explorer 
     */
    public Explorer(String _name, int _id)
    {
        // initialize instance variables
		this.id   = _id; 
        this.name = _name; 
    }

	public int getID()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String _name)
	{
		this.name = _name;
	}

    public String toString()
    {
        String explorer = "";
        explorer += "Explorer: " + this.name + "\n";
        
        return explorer;
    }
}


