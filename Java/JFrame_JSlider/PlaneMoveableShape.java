import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A plane that can be moved around.
*/
public class PlaneMoveableShape implements MoveableShape
{
   /**
      Constructs a plane e item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public PlaneMoveableShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }

   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void draw(Graphics2D g2)
   {
	   
	      Rectangle2D.Double body
	            = new Rectangle2D.Double(x, y + width / 6, 
	                  width - 1, width / 6);
	      

	      // Left side of wing
	      Point2D.Double r1
	            = new Point2D.Double(x + width / 6, y + width / 6);
	      // The connecting point of the wing
	     Point2D.Double r2
	         = new Point2D.Double(x + width / 3, y);
	     
	  
	      // Right side of wing
	      Point2D.Double r4
	            = new Point2D.Double(x + width / 2 , y + width / 4);

	      Line2D.Double leftWing
	            = new Line2D.Double(r1, r2);
	      Line2D.Double rightWing
	            = new Line2D.Double(r2, r4);
	   
	      //bottom wing
	      Point2D.Double b1 = new Point2D.Double(x + width /(1.1), (y + width /(1.1)));
	      //center of bottom wing 
	      Point2D.Double b2 = new Point2D.Double(x - width /(4.9), y + width/6);
	      
	     Point2D.Double b3= new Point2D.Double( x  , (y ));
	      
	      Line2D.Double bottomleftWing = new Line2D.Double(b1,b2);
	      
	      Line2D.Double bottomrightWing= new Line2D.Double(b2,b3);
	      
	      
	     
	      g2.draw(body);
	      g2.draw(leftWing);
	      g2.draw(rightWing);
	      g2.draw(bottomleftWing);
	     g2.draw(bottomrightWing);
   }
   
   private int x;
   private int y;
   private int width;
}
