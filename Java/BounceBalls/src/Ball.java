import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Ball implements Runnable {
	private JPanel box;  
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;
	
	/**
	      Constructs a ball in the upper left corner
	     @c the component in which the ball bounces
	   */
	  public Ball(JPanel b) 
	  { 
		  box = b; 
	  };
	 	/**
	       Draws the ball at its current position
	      @param g2 the graphics context
	    */
	    public void draw()
	    {
	    	Graphics g = box.getGraphics();
	    	g.fillOval(x,y,XSIZE,YSIZE);
	    	g.dispose();
	    }
	 
	    /**
	       Moves the ball to the next position, reversing direction
	       if it hits one of the edges
	    */
	    public void move()
	    {
	    	Graphics g = box.getGraphics();
	    	g.setXORMode(box.getBackground());
	    	g.fillOval(x,y,XSIZE,YSIZE);
	    	
	       x += dx;
	       y += dy;
	       Dimension d = box.getSize(); 
	       if (x < 0)
	       { 
	          x = 0;
	          dx = -dx;
	       }
	       if (x + XSIZE >= d.getWidth())
	      {
	          x = (int) (d.getWidth() - XSIZE); 
	          dx = -dx; 
	       }
	       if (y < 0)
	       {
	          y = 0; 
	          dy = -dy;
	       }
	       if (y + YSIZE >= d.getHeight())
	       {
	          y = (int) (d.getHeight() - YSIZE);
	          dy = -dy; 
	       }
	       g.fillOval(x,y,XSIZE,YSIZE);
	       g.dispose(); 
	      
	    }
	 
	    public void bounce() {
	    	draw();
	    	for (int i=1;i<=1000;i++) {
	    		move();
	    		try {Thread.sleep(5); }
	    		catch (InterruptedException e){}
	    	}
	    }
		@Override
		public void run() {
			bounce();
			
			
		}
	    		
	    		
	    	
	    
	   
}
