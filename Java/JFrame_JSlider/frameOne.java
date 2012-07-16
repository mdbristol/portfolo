
import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.BorderLayout;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;

/**
 * 
 * @author Michael Bristol
 *FrameOne is to make display and have it so its able to show color,movement, and increase in size. 
 */
public class frameOne extends JFrame 
{
	//variables 
	CarIcon car ;
	PlaneIcon plane = new PlaneIcon(100);
	frameTwo f2;
	private JPanel panel1;
	public JLabel  icon, icon2;
	 private Timer t;
	
	final JLabel sliderLabel = new JLabel("0");
	
	
	public void setSubjectFrame(frameTwo something)
	{
		f2=something;
	}
	
	int min=1;
	int max=4;
	int initSize = 100;
	int init = 1;
	int x=1;
	int y =0;
	final JSlider exampleSlider = new JSlider(JSlider.HORIZONTAL, min,max,init);
	 final MoveableShape shape= new CarMoveableShape(0, 0, initSize, Color.red );
	 final MoveableShape shape2= new PlaneMoveableShape(0,0,initSize);
	 ShapeIcon icon21;

	 
	 
	
	public frameOne  ()
	{
		setSize(300,200);
		setTitle("Frame 1");
	
	//sets up a panel for slider
	panel1 = new JPanel();
	panel1.add(exampleSlider);
	panel1.add(sliderLabel);
	this.getContentPane().add(panel1, BorderLayout.SOUTH);
	//sets up panel for icon

	
	icon = new JLabel();
	
	icon.setIcon(car = new CarIcon(initSize));
	
	
	
	this.getContentPane().add(icon, BorderLayout.CENTER);


	
	//displays the slider and what happens when the slider is increased or decreased 
	
	exampleSlider.addChangeListener(new ChangeListener()
	{
		public void stateChanged(ChangeEvent e)
		{
			// what is the current value of slider?
		
			int currentValue = exampleSlider.getValue(); 
			if(currentValue==1)
			{
				
		
			
			car.setIconWidth(100);
			plane.setIconWidth(100);
			icon.repaint();
			}
			else if (currentValue==2)
			{
			
				
				car.setIconWidth(200);
				plane.setIconWidth(200);
				icon.repaint();
			}
			else if (currentValue==3)
			{
				
				car.setIconWidth(300);
				plane.setIconWidth(300);
				icon.repaint();
			}
			else if (currentValue==4)
			{
				
				car.setIconWidth(400);
				plane.setIconWidth(400);
				icon.repaint();
			}
					
			// convert the int value to String.
			String textToDisplay = String.valueOf(currentValue); 
			// set the string on the label sliderLabel.
			sliderLabel.setText(textToDisplay);
			// Make sure to repaint the panel1! 
			
			panel1.repaint();
			

		}
	
	});
	

	}
	/**the stateChanged method is involved when frametwo sends frame one information that something has changed 
	 * 
	 * @param e takes the information being sent to match it up with the IF statements below
	 */
	
	public void stateChanged(ChangeEvent e) 
	{
		String currentEvent = f2.getCurrentEvent();
		if (currentEvent.equals("morph")) {
			if (f2.getCurrentShape().equals("plane")) 
			{
				icon.setIcon(plane = new PlaneIcon(plane.getIconWidth()));
				icon.repaint(); 
				}
			else if (f2.getCurrentShape().equals("car"))
			{
				icon.setIcon(car = new CarIcon(car.getIconWidth()));
				icon.repaint();
			}
		}
		else if (currentEvent.equals("color")){
			if(f2.getCurrentColor().equals("blue"))
			{
			
				car.setColor(Color.blue);
				plane.setColor(Color.blue);
				icon.repaint();
				
			}
			else if (f2.getCurrentColor().equals("black"))
			{
				car.setColor(Color.black);
				plane.setColor(Color.black);
				icon.repaint();
			}
			else if (f2.getCurrentColor().equals("green"))
			{
				car.setColor(Color.green);
				plane.setColor(Color.green);
				icon.repaint();
			}
			else if (f2.getCurrentColor().equals("yellow"))
			{
				car.setColor(Color.yellow);
				plane.setColor(Color.yellow);
				icon.repaint();
			}
			
			}
		else if (currentEvent.equals("reset")){
			if(f2.getOrgObject().equals("Orginal"))
			{
				
					icon.setIcon(car = new CarIcon(initSize));
					car.setColor(Color.red);
					init = 1;	
					icon.repaint();
			}
		}
		else if (currentEvent.equals("animate")){
			if(f2.getCurrentMove().equals("start"))
					{
				t = new Timer(100, new ActionListener()
			    {
			       public void actionPerformed(ActionEvent event)
			       {
			    	   if(f2.getCurrentShape().equals("car"))
			    	   {
			    		   icon21 = new ShapeIcon(shape, 200, 300);
			    	   icon.setIcon(icon21);
			          shape.translate(1, 0);
			          icon.repaint();
			    	   }
			    	   else if(f2.getCurrentShape().equals("plane"))
			    	   {
			    		   icon21 = new ShapeIcon(shape2, 200, 300);
				    	   icon.setIcon(icon21);
				          shape2.translate(x, y);
				          icon.repaint();
			    	   }
			       }
			    });
				
					t.start();
					//when the shape reaches the max length it should reset to zero
					if(x==5)
					{
						x=0;
					}
				
					}
			else if(f2.getCurrentMove().equals("stop"))
			{	
						t.stop();
				  
				  	
						
						
				
			}
		}
		
    	
         
      }
			
			
			}
				
			
		
			
	
	
	
	


