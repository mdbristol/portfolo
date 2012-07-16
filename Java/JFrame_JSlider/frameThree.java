
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
/**
 * 
 * @author Michael Bristol
 *FrmaeThree only job is to display the current color and (x,y) cord of the shape
 */

public class frameThree extends JFrame 
{
	//variables 
	frameTwo f2;
	
	public JTextArea color, cord;
	private JPanel  panel1, panel2;
	 private static final JLabel colorLabel = new JLabel("Color:");
	 private static final JLabel cordLabel = new JLabel("Cord(x,y):");

	 /**
	  * Creates frame3 
	  */
	public frameThree()
	{
		setSize(300,200);
		setTitle("Frame 3");
		
		
		 color = new JTextArea(6, 20);
		   color.setMargin(new Insets(5,5,5,5));
		   color.setEditable(false);
		   
		  cord = new JTextArea(6, 20);
		   cord.setMargin(new Insets(5,5,5,5));
		 cord.setEditable(false);
		 
		panel1 = new JPanel();
		panel1.add(colorLabel);
		panel1.add(color);
		this.getContentPane().add(panel1, BorderLayout.CENTER);
		
		panel2 = new JPanel();
		panel2.add(cordLabel);
		panel2.add(cord);
		this.getContentPane().add(panel2, BorderLayout.SOUTH);
		
		color.setText("red");
		
		
	}
	
	
	
	public void setSubjectFrame(frameTwo something)
	{
		f2=something;
	}
	
	public void stateChanged(ChangeEvent e)
	{
		
	}
	
}
