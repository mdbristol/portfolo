/** 
Michael Bristol

GameGUI class
The GUI creates the display and central mediator for the game logic.

*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * GameGUI extends Canvas allows us to use a different way of ordering.
 */
public class GameGUI extends Canvas 
{

private BufferStrategy strategy; //allows accelerate page flipping
private boolean gameRunning;  // If we are planing the game or not
private ArrayList entities; //list of entities going to be used 
private ArrayList removeList;//removes entitees
private Entity ship;//player
private double moveSpeed;//move speed of ship 
private long lastFire; //time of shot from last shot
private long firingInterval;//time between allowed shots
private int alienCount;//number of aliens left
private String message="";
private boolean waitingForKeyPress;//holds intill key is pressed
private boolean leftPressed;//arrow button
private boolean rightPressed;///right arrow button
private boolean firePressed;///space bar
private boolean logicRequiredThisLoop;//if game logic is required
private long lastFpsTime;//frame rate
private int fps;//current frame rate
private String windowTitle;//title 
private JFrame frame;
private int firecount = 0;//counts up number of shots taken
private int timecount=0;//total time for one game
private int score=0;//total score earned
/** 
 *The contructer class will initialize all the private variables and make the window for the game
*/
	 public GameGUI()
	{

	gameRunning = true;
	entities= new ArrayList();
	removeList = new ArrayList();
	moveSpeed= 300;
	lastFire=0;
	firingInterval = 325;
	waitingForKeyPress = true;
	leftPressed =false;
	rightPressed= false;
	firePressed = false;
	logicRequiredThisLoop = false;
	windowTitle="Space Invaders";
	
	frame= new JFrame("Space Invaders");

	//sets up frame and resolution
	JPanel panel = (JPanel) frame.getContentPane();
	panel.setPreferredSize(new Dimension(800,600));
	panel.setLayout(null);
	setBounds(0,0,800,600);//sets up bounds of frame
	panel.add(this);
	setIgnoreRepaint(true);

	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) //exits the game
			{
			System.exit(0);
			}
		});

	addKeyListener(new KeyInputHandler());
	requestFocus();
	createBufferStrategy(2);
	strategy=getBufferStrategy();
	initEntities();



	
	}
	/** 
	 * Starts a fresh game and clears out all data and beging new set
	 */

	private void StartGame()
	{
	entities.clear();
	initEntities();

	leftPressed=false;
	rightPressed=false;
	firePressed = false;
	}
	
	/**
	 * Initialise the entities of the ship and alien
	 */
	private void initEntities()
	{

	ship= new shipEntity(this, "ship.gif",370,550);//gets the pic of the ship
	entities.add(ship);

	alienCount = 0;
	for (int row=0; row<5; row++) //creates a 5 by 12 chart of aliens 
		{
		for(int x=0; x<12; x++)
			{
			Entity alien= new AlienEntity(this,100+(x*50),(50) + row*30);
			entities.add(alien);
			alienCount++;
			}
		}
	}	
	
	/**
	 * Should run the logic of game
	 */
	public void updateLogic()
	{
	logicRequiredThisLoop = true;
	}

	/**
	 * Removes the entify from game
	 * @para, entity is the entity that will be removed
	 */
	public void removeEntity(Entity entity)
	{
	removeList.add(entity);
	}

	/**
	 * Notify when you have died and display results
	 */
	public void notifyDeath()
	{
	message = "YOUR DEAD SORRY, TRY AGAIN  "  + "   Shots Fired:" + firecount + "   Time:" + timecount/100 + "   AlienCount:"  + alienCount  +"  Score:" + score;
	waitingForKeyPress = true;
	}

	/** 
	 * Notify win and display results
	 */
	public void notifyWin()
	{
	
	message= "YOU WIN  " + "   Shots Fired:"+  firecount  + " Time:"  +  timecount/100  + "   AlienCount:" + alienCount  + "  Score:" + score;
	
	waitingForKeyPress = true;
	}

	/**
	 *This method tells us that a alien has been killd
	 */

	public void notifyAlienKilled()
	{
	alienCount--; //reduce alien count if hit
	score=score+100;//increase score if alien is hit
 	if(alienCount == 0)//if no more alien's left you win
		{
		notifyWin();
		}
	for(int i=0;i<entities.size();i++)//if alien are left increase speed
		{
		Entity entity = (Entity) entities.get(i);
	
		if(entity instanceof AlienEntity)
			{
		entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.05);
			}
		}
	}

	/**
	 * Determins if the wait between shots has been made and if so will fire another shot.
	 */

	public void tryToFire()
	{
	
		if(System.currentTimeMillis() - lastFire < firingInterval) 
		{
			return;
		}
		
		lastFire=System.currentTimeMillis();
		ShotEntity shot = new ShotEntity(this, "shot.gif",ship.getX()+10,ship.getY()-30);
		entities.add(shot);
	}

	/**
	 * The main loop of the game. Works out speed of game loop. Moves the entites. Draws screen contents. updates game events. and checks input
	 */
	public void gameLoop()
	{
		long lastLoopTime = SystemTimer.getTime();
		
		//runs intill game ends
		while(gameRunning)
		{
	
		long delta = SystemTimer.getTime() - lastLoopTime;
		lastLoopTime= SystemTimer.getTime();

		lastFpsTime += delta;
		fps++;
		
		if (lastFpsTime >= 1000)
		{
			frame.setTitle(windowTitle+" (FPS: "+fps+"  Shoots Fired: "+firecount+ "  Time: "+timecount/100+ "   AlienCount: "+alienCount+"  Score: "+score+" )");//sets up title
			lastFpsTime =0;
			fps = 0;
		}
		//accelerated graphics
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		
		//entitys move itself
		if(!waitingForKeyPress)
		{
			timecount++;
			for(int i=0;i<entities.size();i++)
				{
					Entity entity = (Entity) entities.get(i);
					entity.move(delta);
				}
		}
		//draws all entities for the game
		for(int i=0;i<entities.size();i++)
			{
				Entity entity = (Entity) entities.get(i);
				entity.draw(g);
			}

		//force collisions, if any entity's collide notify both
		for (int p=0;p<entities.size();p++) 
			{
			for (int s=p+1;s<entities.size();s++)
				 {
					Entity me = (Entity) entities.get(p);
					Entity him = (Entity) entities.get(s);
					
					if (me.collidesWith(him)) 
					{
						me.collidedWith(him);
						him.collidedWith(me);
					}
				}
			}
			
		entities.removeAll(removeList);
		removeList.clear();
		//game logic should be resolved
		if(logicRequiredThisLoop)
		{
			for(int i=0;i<entities.size();i++)
			{
			Entity entity = (Entity) entities.get(i);
			entity.doLogic();
			}
			logicRequiredThisLoop = false;
		}

		//if we are waiting for the user to press a key
		if(waitingForKeyPress)
		{
			g.setColor(Color.white);
			g.drawString(message,(800-g.getFontMetrics().stringWidth(message))/2,250);
		g.drawString("Press any key",(800-g.getFontMetrics().stringWidth("Press any key"))/2,300);

		}

		g.dispose();
		strategy.show();
		
		//update movement
		ship.setHorizontalMovement(0);

		if((leftPressed) && (!rightPressed))
			{
			ship.setHorizontalMovement(-moveSpeed);
			}
		else if ((rightPressed) && (!leftPressed))
			{
			ship.setHorizontalMovement(moveSpeed);
			}
		//if firePressed try to fire
		if(firePressed)
		{
			tryToFire();
		
		}

		SystemTimer.sleep(lastLoopTime+10-SystemTimer.getTime());
		}
	}
		
	/**A class to handle the input from the keyboard by the user, goig to use the left and right arrows and the space key. Also will look for press any key to continue.
	 */
	 
			
	private class KeyInputHandler extends KeyAdapter
	{
	private int pressCount=1;
	/**
	 * Notification that the key has beenPressed down
	 * @param e The details of the key pressed
	 */
		public void keyPressed(KeyEvent e)
		{
		if(waitingForKeyPress)
			return;
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed= true;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			rightPressed= true;
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			{
			firePressed = true;
			firecount++;
			}

		}
		/**
		 * Notification from AWT that a key has been released after been pressed down.
		 * @param e The details of the key released
		 */

		public void keyReleased(KeyEvent e)
		{
		if(waitingForKeyPress)
			return;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed= false;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			rightPressed= false;
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			firePressed = false;
		}
		/**
		 * Notification that the key has been pressed and released.
		 * @param e The details of the key typed
		 */
		public void keyTyped(KeyEvent e)
		{
			if(waitingForKeyPress)
			{
				if(pressCount == 1)
				{
				waitingForKeyPress = false;
				StartGame();	
				pressCount=0;
				timecount=0;
				firecount=0;
				}
				else
					pressCount++;
			}

			if(e.getKeyChar() == 27)//if esc key pressed exit game 
				System.exit(0);
		}	

	}
}

