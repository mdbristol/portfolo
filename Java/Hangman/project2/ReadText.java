/**
 * Michael Bristol
 *
 * text reader
 *
 * The Readtext class is going to read in a text file and seprate it into a array of words, it will also have methods that will be called by the GUI class to perform certian tasks
 *
 */


import java.io.FileReader;
import java.util.*;
import java.io.IOException;


public class ReadText  
{
	//instance variables that are declared 
	Scanner scan; 
	Word[] wor = new Word[100];
	String word;
	String def;
	String dash;
	int count;
	int count2;
/** The constructor for the Readtext initalizes the instance variables
 */
public ReadText()
{
scan= new Scanner(System.in);
word="";
def="";
dash="";
count=0;
count2=0;
}
/** The scanText method will scan the actual file and sends the word class the text and defintion 
 */
	public void scanText()
	{

	try
	{	
	FileReader file = new FileReader("datefile.txt");//reads the file
	scan = new Scanner(file);
	}
	catch(IOException e)//if the file is not located 
	{
	System.out.println("File not found");
	}
		while(scan.hasNext())//while there is a line to still scan in
	{
	wor[count2]= new Word(scan.next(), scan.nextLine());//sends the word class first the text and then the rest of the line to be the definition

	count2++;

	}
	}
/** the nextWord method its job is to move on the the next word if the user guess the correct word or the user press the skip button
 */
	public void nextWord()
	{		
		//starts the array at 0
	word=wor[count].getText();//calls the part of the array which count has been set to
	def=wor[count].getDef();
	dash=wor[count].getDashed();
	count++;//increases the count every tine the method is called
	
	}
/** The hintWord method takes the first instance of a dash and sets it back to the character which it was.
 */
	public void hintWord()
	{
	
	
	for(int i = 0; i<dash.length(); i++)//goes through the length of the dash
	{
	if(dash.charAt(i)=='-')//if  a dash
	{
	dash = dash.substring(0,i) + word.charAt(i) + dash.substring(i+1);	
	break;//stops each time a dash is found
	}	
	}

	}
	
			
/** The restart method resets the count variables
 */

	public void restart() 
        {
  		count=0;
		count2=0;
		
        }
	

}
	




