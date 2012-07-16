/** 

Michael  Bristol

ShotEntity class

A class that is going to represent an entity of a shot from the ship

*/

public class ShotEntity extends Entity
{

	private double moveSpeed= -500;//vertical speed at which shot moves
	private GameGUI game;//game of entity
	private boolean used = false;//True if shot has been used

	/** 
	 * Create a new shot from ship
	 * @param game The game where the shot is created
	 * @param sprite The sprite representing the shot
	 * @param x the initial x location
	 * @param y the initial y location 
	 */

	public ShotEntity(GameGUI game, String sprite, int x, int y)
	{
		super(sprite,x,y);
		this.game=game;
		dy=moveSpeed;
	}

	/**
	 *  shot moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */

	public void move(long delta)
	{
		super.move(delta);

		if(y<-100)
		{
		game.removeEntity(this);
		}
	}
	
	/**
	 * Notification that this shot has collided with another
	 * entity
	 * 
	 * @parma other The other entity with which we've collided
	 */
	public void  collidedWith(Entity other)
	{
		if(used)
			return;
		if(other instanceof AlienEntity)
			{
			game.removeEntity(this);
			game.removeEntity(other);
			game.notifyAlienKilled();
			used = true;

			}
		
	}
}
