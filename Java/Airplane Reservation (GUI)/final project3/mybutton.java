/** Michael Bristol

mybutton class
The mybutton class will extend a Jbutton and hold the row and column of a button
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class mybutton extends JButton
{
private int row;
private int column;

/**
The constructer for my button that requires an two int to be passed in. Also sets the row and column from the row_ and col set by the user.
*/
	public mybutton(int row_, int col)
	{
	row= row_;
	column=col;
	}
/** getRow returns the row
@return will return an int
*/
	public int getRow()
	{
	return row;
	}
/** getCol returns the col
@return  will return an int
*/
	public int getCol()
	{
	return column;
	}
/**
The to toString() will combine both the row and column to be used as a string
@return result will return a string of a row +column
*/
	public String toString()
	{
		String result= row + "," + column;
		return result;
	}
}
