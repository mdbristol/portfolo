import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   An icon that has the shape of a plane
*/
public class PlaneIcon implements Icon
{
   /**
      Constructs a plane of a given width.
      @param width the width of the plane
   */
   public PlaneIcon(int aWidth)
   {
      width = aWidth;
   }
   /**
    * Sets the Iconwidth
    * @param x is the users inputed width
    */
   public void setIconWidth(int x)
   {
   	width=x;
   	
   }
   /**
    * returns the width
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    * Returns the Height
    */
   public int getIconHeight()
   {
      return width / 2;
   }
   /**
    * Gets the currentColor 
    * @return color of the shape 
    */
   public Color getColor()
   {
	   return color;
   }
   /**
    * Sets the color of the shape
    * @param c is the color the user has inputed
    */
   public void setColor(Color c)
   {
	   color=c;
	   
   }
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
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
      
      //draws the car
      g2.setColor(color);
      g2.fill(body);
      g2.draw(leftWing);
      g2.draw(rightWing);
      g2.draw(bottomleftWing);
     g2.draw(bottomrightWing);
      
    
   }

   private int width;
   private Color color = Color.red;

}


