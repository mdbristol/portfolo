/** 
Michael Bristol

ShipEntity class

The entity that is the players ship

*/

public class shipEntity extends Entity
{

	private GameGUI game;//game in which the ship exists

	/**
	 * Constructer makes a new entity for the ship
	 * @param game The game in which the ship is created
	 * @param ref The reference for the ship
	 * @paran x The initial x location of ship
	 * @param y The initial y location of ship
	 */
	public shipEntity(GameGUI game, String ref, int x, int y)
	{
		super(ref,x,y);
		this.game = game;
	}


	/**
	 * Makes the ship move itself based on ammount of time elapsed
	 * @param delta The time elapsed 
	 */

	public void move(long delta)
	{
		if((dx<0) && (x<10))
		{
			return;
		}
		
		if((dx>0) && (x > 750))
		{
			return;
		}

		super.move(delta);
	}

	/**
	 * Notify that the ship has collided with something
	 * @param other The entity at whcih collided with ship
	 */
	public void collidedWith(Entity other)
	{

		if(other instanceof AlienEntity)
			game.notifyDeath();
	}
}
