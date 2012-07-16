/** Michael Bristol
 * usercheck controller 
 *
 * This class job is to check and break apart the key inputed by the user to determine wheither or not the key is valid.
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class usercheck
{

	private int checkC[]; //creates an array

	private boolean good;// changes if the key is not good

	private String check;

	private Stack<Integer> x;

	private CircularArrayQueue<Integer> y;

	private int checksum;
/** 
 * construter that will initializes all beginning varables
 */	
	public usercheck()
	{
		good = false;//initializes good to false
		check = "";//initializes check to blank
		x = new Stack<Integer>();//initializes the Stack object
		y = new CircularArrayQueue<Integer>();//initializes the Queue object
		checksum = 0;//initializes checksum to 0
	}
	/**
	This method will return weither or not the key imput is good or not 
	@param length the length of the userInput key
	@return returns var good
	*/
	public boolean checkKey(int length)
	{
		for(int i=0; i<length/2; i++)
			{
				if(checkC[i] == checksum)
				{
					good = true;//sets good to true if value in checkC is equal to checksum
				}
				else
				{
					good = false;//sets good to false if value in checkC is NOT equal to checksum
					break;//breaks out of the loop if any value does not equal checksum
				}
			}
		return good;//returns good
	}
	/**
	This method will return the overall result of the check
	@return returns check variable
	*/
	public String result()
	{
		if(good == true)
			check =  "Good Key";//sets check to "Good Key"
		else
			check = "Bad Key";//sets check to "Bad Key"
		
		return check;//returns check
	}
	/**
	This method adds to the stack and queue
	@param length the length of the userInput key
	@param userInput the userInput key
	*/
	public void addToKey(int length, String userInput)
	{
		for(int i=0; i<length; i++)
			{
				char temp = userInput.charAt(i);//creates a char for value at i
				Integer tempInt = new Integer(Integer.parseInt(temp + ""));//parses "temp" to an int
				y.enqueue(tempInt);//adds tempInt to queue each time through the loop
				x.push(tempInt);//adds tempInt to stack each time through the loop
			}
	}
	/**
	This method will take off from the stack and queue and then add together to find if the checksum is correct.
	and adds them together.  The addition is added to the checkC array
	@param length the length of the userInput key
	*/
	public void addComponents(int length)
	{
		checkC = new int[length/2];//initializes array with a lenght of userInput/2
		for(int i =0; i<length/2; i++)
			{
				int b = y.dequeue();//removes elements and sets "b" to that element
				int a = x.pop();//removes elements and sets "a" to that element
				int c = a+b;//adds a and b
				checkC[i] = c;//sets current checkC index to c
				checksum = c;//sets checksum to c
						
			}
	}
	/**
	This method rests the stack and queue
	@param length the length of the userInput key
	*/
	public void resetCollections(int length)
	{
		for(int i = 0; i<length/2; i++)//removes all elements from queue and stack
			{
				y.dequeue();
				x.pop();
			}
	}
}
