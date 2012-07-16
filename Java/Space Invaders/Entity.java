/** 
Michael Bristol

Entity class

This class is to have an entity represent any element that appears in the game.
Resolves collisions and movements
*/

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{

protected double x; //current x location
protected double y;//current y location
protected Sprite sprite;//sprite that represents the entity
protected double dx;//speed of entity horizonatally
protected double dy;//speed of entity vertically
private Rectangle me = new Rectangle();//collisions
private Rectangle him = new Rectangle();///other collisions


	/**
	 * Contructer that makes a entity 
	 *@param ref Reference to the displayed image
	 @param x inital location x
	 @param y inital location y
	 */

	public Entity(String ref, int x, int y)
	{
		this.sprite= SpriteStore.get().getSprite(ref);
		this.x=x;
		this.y=y;
	}

	/** 
	 * Makes the entity move bases on ammount of time passing
	 * @param delta The amount of time that has passed in milliseconds
	*/
	public void move(long delta) 
	{

		x += (delta * dx)/1000;
		y += (delta * dy)/1000;
	}

	/**
	 * sets the horizontal speed
	 * @param dx Speed of this entity
	 */
	public void setHorizontalMovement(double dx)
	{
		this.dx = dx;
	}

	/**
	 * Sets the verticial speed
	 *@param dy Vertical speed of entity
	 */
	public void setVerticialMovement(double dy)
	{
		this.dy=dy;
	}

	/**
	 * Gets horizontal speed of entity
	 *@return horizonatal speed
	 */
	public double getHorizontalMovement()
	{	
		return dx;
	}

	/**
	 * Gets vertical speed of entity
	 *@return Returns the vertical speed
	 */
	public double getVerticalMovement()
	{
		return dy;
	}

	/**
	 * Draws the entity to the graphics 
	 *@param g Location on which to draw
	 */
	public void draw(Graphics g)
	{

		sprite.draw(g,(int) x, (int) y);
	}
	/** 
	 * Does logic based on game events
	 */
	public void doLogic()
	{

	}
	/**
	 * Gets x location of entity
	 *@returns an int of the location x
	 */
	public int getX()
	{
	return (int) x;
	}
	
	/**
	 * Gets y location of entity
	 *@return an int of the location y
	 */
	public int getY()
	{
	return (int) y;
	}	

	/**
	 * Check for cllision with others
	 * @param other The entity to check collisoin against
	 * @return True if collide with
	 */
	public boolean collidesWith(Entity other) 
	{
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}

	/**
	 * Notify that this entity has collided
	 *@param other Entity with which this entity collided
	 */
	public abstract void collidedWith(Entity other);
}


