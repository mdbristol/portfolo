/** 
Michael Bristol

AlienEntity

This class will represent the entity of one of the aliens

*/


public class AlienEntity extends Entity
{


	private double moveSpeed = 75;//horizontal speed
	private GameGUI game;//game in extityexists
	private Sprite[] frames = new Sprite[4];// animation frames
	private long lastFrameChange;// last frame time
	private long frameDuration=250;///frame duration
	private int frameNumber;//current frame of animation

	/**
	 * Creates a alien entity
	 * @param Game The game where the entity is created
	 * @param x intial x location
	 * @param y intial y location
	 */

	public AlienEntity(GameGUI game, int x, int y)
	{
		super("alien.gif",x,y);

	frames[0]=sprite;//animation frames
	frames[1]=SpriteStore.get().getSprite("alien2.gif");
	frames[2]=sprite;
	frames[3]=SpriteStore.get().getSprite("alien3.gif");

	this.game =game;
	dx= -moveSpeed;
	}

	/**
	 * Method to have alien move based on time elapsed
	 * @param delta Time that has elapsed since last move
	 */
	public void move(long delta)
	{
		lastFrameChange +=delta;
		
		if(lastFrameChange > frameDuration)
			{
			lastFrameChange = 0;
			frameNumber++;
			if(frameNumber>=frames.length)
				{
				frameNumber=0;
				}
		
			
			sprite = frames[frameNumber];
			}
		if((dx<0) && (x<10))
		{
			game.updateLogic();
		}

		if((dx>0) && (x>750))
		{
			game.updateLogic();
		}
		
		super.move(delta);
	}

	/**
	 * Update gamelogic
	 */

	public void doLogic()
	{
		dx=-dx;
		y += 10;
		
		if(y>570)
			game.notifyDeath();
	}

	/**
	 * Notifiy of collided entity
	 * @param other the entity that collided with alien
	 */
	public void collidedWith(Entity other)
	{
	}
}
