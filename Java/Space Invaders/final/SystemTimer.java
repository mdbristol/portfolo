/** 
Michael Bristol

SystemTimer
A class the provides the timing methods for the game
*/

import com.dnsalias.java.timer.AdvancedTimer;


public class SystemTimer
{

	private static AdvancedTimer timer = new AdvancedTimer();//link to theGAGE timer library
	private static long timerTicksPerSecond;//number of timer tickers per second

	//initialistation at startup of the GAGE timer 
	static
	{
		timer.start();
		timerTicksPerSecond= AdvancedTimer.getTicksPerSecond();
	}

	/**
	 * Gets a high resolution time
	 * @return The high resolution 
	 */
	public static long getTime()
	{


	return (timer.getClockTicks() * 1000)/timerTicksPerSecond;

	}

	/**
	 * Sleep method for a fixed time
	 * @param duration Tha ammount of time to sleep for 
	 */
	public static void sleep(long duration)
	{
		timer.sleep((duration * timerTicksPerSecond) / 1000);
	}
}
