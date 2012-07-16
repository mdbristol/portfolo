/**
Michael Bristol

Sprite classs
This class is to display the sprite on the screen. A sprite has no information it is just an image.
*/

import java.awt.Graphics;
import java.awt.Image;


public class Sprite
{

	private Image image;//image to be drawn for this sprite

	/**
	 * Contructer will create and initalize a new sprite
	 * @param image The iage of this sprite
	 */

	public Sprite(Image image)
	{
		this.image=image;
	}
	
	/** 
	 * Gets the width of image
	 * @return Returns an integer of the width
	 */
	public int getWidth()
	{
		return image.getWidth(null);
	}


	/**
	 * Gets the height of the image
	 * @return Returns an integer of the height
	 */
	public int getHeight()
	{
		return image.getHeight(null);
	}

	/**
	 * Draws the sprite of the infomration provided 
	 * @param g Gets a graphic context
	 * @param x Gets the x location to draw sprite at
	 * @param y Gets the y location to draw sprite at
	 */
	public void draw(Graphics g, int x, int y)
	{
		g.drawImage(image,x,y,null);
	}
}
	


