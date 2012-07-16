/** Michael Bristol

SpriteStore class

Controller for the sprites in the game. Gets the game resources fro this class.

*/

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class SpriteStore
{
	private static SpriteStore single = new SpriteStore();//single instance of this class

	/**
	 * Gets the single instance of this class
	 * @return The single instance
	 */
	public static SpriteStore get()
	{
		return single;
	}
	
	private HashMap sprites = new HashMap();//cached sprite map

	/**
	 * Retrieves a sprite from the store
	 * @param ref The reference to the image being used for the sprite
	 * @return Returns a Sprite instance 
	 */

	public Sprite getSprite(String ref)
	{
		if(sprites.get(ref) !=null)
		{
		return (Sprite) sprites.get(ref);
		}

		BufferedImage sourceImage = null;
		try
		{
		
		URL url= this.getClass().getClassLoader().getResource(ref);

		if(url==null)
			fail("Can't find ref: "+ref);
		
		sourceImage=ImageIO.read(url);
		}

		catch (IOException e)
		{
			fail("Failed to load: " + ref);
		}
		//creates an accelerated image of the right size to store our sprite in
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(),sourceImage.getHeight(),Transparency.BITMASK);
	
		//draws image into the accelerated image
		image.getGraphics().drawImage(sourceImage,0,0,null);

		Sprite sprite = new Sprite(image);
		sprites.put(ref,sprite);
			
		return sprite;
	}

	/**
	 * Utility method to handle the resource loading failure
	 * @param message The message to display failure
	 */
	private void fail(String message)
	{
	System.err.println(message);
	System.exit(0);
	}
}






