/**
 * Michael Bristol
 *
 * List class
 */

public class List
{
	int score=0;


	public boolean match(String[] name, String[] def )
	{
	for(int i = 0; i<name.length; i++)
	{
		for(int j = 0; j<def.length; i++)
		{
			if(name[i].equals(def[i]))
			return true;
		}
	}
	return false;
	}

	public void grade(int count)
	{
		if( count ==0);
			{
				score=+5;
			}
		else if ( count ==2);
			{
				score=+3;
			}
	}

	}


}
