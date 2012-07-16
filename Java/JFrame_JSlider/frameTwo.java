import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;


import javax.swing.event.*;
import java.util.*;


/**
 * 
 * @author Michael Bristol
 * frametwo acts as the main source of action of the program. It contains the buttons that will change the state of the icon being displayed.
 * 
 */
public class frameTwo extends JFrame
{
	//variables
	CarIcon car ;
	frameOne f1;
	frameThree f3;
	String currentShape;
	
	public void setFrame1(frameOne f)
	{
		f1=f;
	}
	public void setFrame3(frameThree f)
	{
		f3=f;
	}
	private JButton state, morphCar, morphPlane, colorBlue, colorYellow, colorGreen, colorBlack, start, reset, stop;
	private JPanel panel1, panel2, panel3; 
	

	public frameTwo()
	{
		
		//creates the buttons to be used 
		morphCar = new JButton("Change to Car");
	    morphCar.addActionListener(new carListener());
		morphPlane = new JButton("Change to Plane");
		morphPlane.addActionListener(new planeListener());
		colorBlue = new JButton("Blue");
		colorBlue.addActionListener(new blueListener());
		colorYellow = new JButton("Yellow");
		colorYellow.addActionListener(new yellowListener());
		colorGreen = new JButton("Green");
		colorGreen.addActionListener(new greenListener());
		colorBlack = new JButton("Black");
		colorBlack.addActionListener(new blackListener());
		start = new JButton("Start");
		start.addActionListener(new startListener());
		stop = new JButton("Stop");
		stop.addActionListener(new stopListener());
		reset = new JButton("reset");
		reset.addActionListener(new resetListener());
		setSize(300,200);
		setTitle("Frame 2");
		
		//adds buttons to panel1
		panel1 = new JPanel();
		panel1.add(morphCar);
		panel1.add(morphPlane);
		panel1.add(start);
		panel1.add(stop);
		panel1.add(reset);
		this.getContentPane().add(panel1, BorderLayout.CENTER);//adds panel1 to frame 
		
		//adds buttons to panel2
		panel2 = new JPanel();
		panel2.add(colorBlue);
		panel2.add(colorBlack);
		panel2.add(colorGreen);
		panel2.add(colorYellow);
		
		this.getContentPane().add(panel2, BorderLayout.SOUTH);//adds panel2 to frame
		
		
	
		
	
		
	}
	
	 private class carListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
	    	currentShape="car";
			currentEvent = "morph";
			f1.stateChanged(new ChangeEvent(this));

	    }
	  }
	 //more variables for the ActionListeners 
	 public String getCurrentShape() { return currentShape;};
	 public String getCurrentColor() { return currentColor;};
	 public String getCurrentEvent() { return currentEvent;};
	 public String getCurrentMove() { return currentAnimate;};
	 public String getOrgObject() { return resetP;};
	 public String currentEvent, currentColor, currentAnimate, resetP;
	 private class planeListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
			currentShape="plane";
			currentEvent = "morph";
		
			f1.stateChanged(new ChangeEvent(this));

	    }
	  }
	 private class blueListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
	   	currentColor="blue";
	   	currentEvent = "color";
	   	f1.stateChanged(new ChangeEvent(this));
	   	f3.color.setText("blue");
	    	
	    }
	  }
	 private class greenListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
	   	currentColor="green";
	   	currentEvent = "color";
	   	f1.stateChanged(new ChangeEvent(this));
	   	f3.color.setText("green");
	    	
	    }
	  }
	 private class yellowListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
	   	currentColor="yellow";
	   	currentEvent = "color";
	   	f1.stateChanged(new ChangeEvent(this));
	   	f3.color.setText("yellow");
	    	
	    }
	  }
	 private class blackListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
			currentColor="black";
			currentEvent = "color";
			f1.stateChanged(new ChangeEvent(this));
			f3.color.setText("black");
	    }
	  }
	 private class startListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
			currentAnimate = "start";
			currentEvent = "animate";
			f1.stateChanged(new ChangeEvent(this));

	    }
	  }
	 private class stopListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
			currentAnimate = "stop";
			currentEvent = "animate";
			f1.stateChanged(new ChangeEvent(this));

	    }
	  }
	 private class resetListener implements ActionListener
	  {
	    public void actionPerformed (ActionEvent event)
	    {
			currentEvent="reset";
			resetP = "Orginal";
			f1.stateChanged(new ChangeEvent(this));
			f3.color.setText("red");
	    }
	  }

}
