/** 
 * Michael Bristol
 * 
 *
 * CipherControl
 *
 * This class job is to generate a random number betweeen many conditions from the users inputed key length
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cipherControl 
{
	private int inputDigits[];
	private int checksum;
	private Random rand;
	private String result;
	private String inputValue;
	private int value;
	private int lastinputDigits[];
	private int count;
/** 
 * Construter intializes the variables and declares them
 */

public cipherControl()
{
	value=0;
	inputValue="";
	result="";
	rand=new Random();

}

/** 
 * This method asks for the the of the desired key length and makes sure it follows the conditions
 */
public void checkInput()
{

inputValue= JOptionPane.showInputDialog("Enter a length between 2-16 that is an even number for the desired length of your key");

value=Integer.parseInt(inputValue);///parses the inputValue to an Integer

	while(value %2 !=0 || value < 2 || value > 16)//if true run an error screen
	{
		inputValue= JOptionPane.showInputDialog("You have not reached the required conditions please enter again an length between 2-16 that is even.");
		value=Integer.parseInt(inputValue);
	}
}

/**
 * This method will generate the random check sum number that when two numbers are added together will equal this check sum.
@return will return an integer
*/

public int getCheckSum()
{

checksum=rand.nextInt(15)+2;//generates a random number

return checksum;
}

/** This method job will be to determine the first half of the numbers needed for the certain length
 */
public void firstHalf()
{
	inputDigits = new int[value];
	int randomC = 0;
	int min = 0;
	int max = 0;
	for (int i=0; i<value-1; i++)
	{
		if(checksum >=10)
		{
			max=9;
			min= checksum-max;
			randomC= rand.nextInt(max-min +1)+ min;
			inputDigits[i]=randomC;
		}
		else
		{
			randomC=rand.nextInt(checksum);
			inputDigits[i]=randomC;
		}
	}
}


/** 
 * This method will detemine the last numbers of the keys length
 */

public void secondHalf()
{
	lastinputDigits= new int[value/2];
	for(int i =0; i<value/2; i++)
	{
		lastinputDigits[i]= checksum - inputDigits[i];
	}
}

/** 
 * This method combines the first and second half methods together.
 */
public void full()
{
	count= (value/2)-1;
	for(int i=(value/2); i<value; i++)
	{
		inputDigits[i]=lastinputDigits[count];
		count--;
	}
}

/** 
 * This method will convert everything into a string to be printed out.
 *@return will return a String
 */

public String toString()
{
	for(int i=0; i<value; i++)
	{
		result = result + inputDigits[i] + "";
	}
	return result;
}
public void clear()
{
	result= "";
}



}
