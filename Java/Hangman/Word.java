/** 
Michael Bristol

Word class

The word class creates instance of a line and creates it into a text and a defintion
Sets three private variables that are to only to be set in the code.
*/


public class Word
{

	private String text;//declares the variables 
	private String def;

/**
 	The constructor for the Word class that initializes the private fields
	@param user_text name of the new text being sent in
	@param user_def name of the texts definition being sent in
*/
	public Word(String user_text, String user_def)
	{
		text= user_text;
		def= user_def;
	}

/** Returns the information in the private string text
 	@return text is the text name
*/
	public String getText()
	{
	return text;
	}

/**	Returns the information in the private string def
 	@return def is the definition of the text
*/

 	public String getDef()
	{
	return def;
	}
/** Sets the text name
 	@param user_text makes a new name of the text
*/
	public void setText( String user_text)
	{
	text = user_text;
	}
/** Sets the defintion name
 	@param user_def makes a new name of the definition
*/
	public void setDef( String user_def)
	{
	def= user_def;
	}
/** Makes the text name into a set of dashes to be return instead of the text itself
	@return dash returns a string of dashes
*/
	public String getDashed()
	{
		String dash="";
		char[] das = new char[text.length()];//makes a array of char and sets the size of the array by the length of the text

		for(int i = 0; i<text.length(); i++)//goes through each spot in the array
		{	
			das[i]='-';//sets each char in the array with a -
		}
		for(int j=0; j<das.length;j++)//replaces the actual text with the -
		{
			dash=dash+das[j];
		}

		return dash;
	}

/** Returns a formated output string representing the two objects together
 	@return result returns a string of the text and def
*/
			
		
	public String toString()
	{
	String result= text + "-" + def;
	return result;
	}
}
