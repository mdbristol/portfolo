import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BounceFrame extends JFrame {
	
	
    private JPanel canvas;
    
   
    /**
        Constructs the frame with the canvas for showing the
        bouncing ball and Start and Close buttons
     */
   public BounceFrame()
   {
        setSize(300,200);
        setTitle("Bounce");
  
    
      canvas = new JPanel(); // create a JPanel. We will add the ball and buttons to this
      this.getContentPane().add(canvas, BorderLayout.CENTER); // add it to the frame.
     
      // Create another JPanel this time to store the buttons
      JPanel buttonPanel = new JPanel();
      // create two buttons start and stop
      JButton start = new JButton("Start"); 
      start.addActionListener(
            new ActionListener()
            {  
                public void actionPerformed(ActionEvent evt)
                {
                	//BallThread b = new BallThread(canvas);
                	Ball b = new Ball(canvas);//Runnable object
                	//convert now to a runnable Thread
                	Thread t = new Thread(b);//make runnable object a thread
                	t.start();
                    //b.bounce();
                 
                 }

				
            }
       ); // end of actionlistener for start button.
      
      JButton close = new JButton("close");
      close.addActionListener(
    		  new ActionListener()
              {
                public void actionPerformed(ActionEvent evt)
                {
                    System.exit(0);
                }
             }
    		  
      ); // End of close button.
      
      // Add the buttons to the panel
      buttonPanel.add(start);
      buttonPanel.add(close);
      
// finall add the button panel to the frame.          
   this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
     }
  
     /**
        Adds a button to a container.
        @param c the container
       @param title the button title
        @param listener the action listener for the button
     */
    
    /**
        Adds a bouncing ball to the canvas and makes 
        it bounce 1,000 times.
     */
     public void addBall()
     {
           BallThread b = new BallThread(canvas);
           b.start();
        
     }
  

 }