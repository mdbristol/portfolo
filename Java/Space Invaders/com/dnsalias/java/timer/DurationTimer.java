package com.dnsalias.java.timer;

/**
 * This class provides convenient way of implementing countdown timers
 * such as timed powerups, level timers, bomb fuses, and other game concepts that rely on a
 * bounded timer. It is important to note that this timer is designed to be polled and will not 
 * generate events. <br>
 * <br>
 * An example usage would be a BomerMan game that uses this timer to determine when a bomb should 
 * explode. The code to track a bomb might look something like the following:<br>
 * <br>
 * <pre>
 * //5 seconds till bomb blows!
 * DurationTimer bombtime = new DurationTimer(DurationTimer.getTicksPerSecond()*5);
 * 
 * bombtime.start();
 *
 * while(running)
 * {
 *     //other game code
 *     if(bombtime.getTicksRemaining() == 0) explodeBomb();
 * }
 * </pre>
 */
public class DurationTimer
{
    private AdvancedTimer timer = new AdvancedTimer();
    private long duration;
    
    private boolean paused = false;
    private long adjust;
    private long pausetime;
    
    /**
     * Creates a new instance that will count down for "duration" ticks. Use the getTicksPerSecond() method to
     * calibrate this timer against real time.
     *
     * @param duration The number of ticks before this timer will expire.
     */
    public DurationTimer(long duration)
    {
        this.duration = duration;
    }
    
    /**
     * Returns the number of clock ticks per second. This method is useful for determining the value to
     * pass to the constructor. e.g. If I have a bomb that will explode in 20 seconds, I can call the
     * constructor like this: <code>new DurationTimer(20*DurationTimer.getTicksPerSecond())</code>.
     *
     * @return The number of clock ticks per second.
     */
    public static long getTicksPerSecond()
    {
        return AdvancedTimer.getTicksPerSecond();
    }
    
    /**
     * Calling this method begins the countdown. The timer will continue to countdown until "duration" clock ticks
     * has passed, or the timer is paused.
     */
    public void start()
    {
        timer.start();
    }
    
    /**
     * Stops the timer (if running) and resets it to it's initial value. This method is useful
     * if you want to reuse this timer.
     */
    public void reset()
    {
        reset(duration);
    }
    
    /**
     * Stops the timer (if running) and resets it to "duration" ticks. This method is useful
     * if you want to reuse this timer.
     *
     * @param duration The number of ticks before this timer expires.
     */
    public void reset(long duration)
    {
        stop();
        
        this.duration = duration;
    }
    
    /**
     * Pauses the timer. Generally, this should be called If a user pauses a game. Otherwise,
     * the timer will continue to count down even though "game time" is suspended. This call is
     * ignored if the timer is already paused.
     */
    public void pause()
    {
        if(paused) return;
        
        paused = true;
        pausetime = timer.getClockTicks();
    }
    
    /**
     * Checks to see if the timer is currently paused.
     *
     * @return True if paused, false otherwise.
     */
    public boolean isPaused()
    {
        return paused;
    }
    
    /**
     * Resumes the timer after a pause. If the timer was not paused, this method has no effect.
     */
    public void resume()
    {
        if(!paused) return;
        
        adjust += (timer.getClockTicks()-pausetime);
        paused = false;
    }
    
    /**
     * Stops the timer. Once the timer is stopped, the timer will need to be reset before it can be used again.
     * The timer will automatically stop after the specified duration has elapsed.
     */
    public void stop()
    {
        timer.stop();
    }
    
    /**
     * Returns the remaining number of clock ticks before the timer expires. Zero is returned once the timer 
     * expires.
     *
     * @return Clock ticks left before the timer automatically stops.
     */
    public long getTicksRemaining()
    {
        if(paused) return duration-pausetime;
        
        return Math.max(0, duration+adjust-timer.getClockTicks());
    }
    
    /**
     * Returns the number of seconds until the timer expires. Zero is returned once the timer expires. Only
     * the integral number of seconds is returned. i.e. The fraction of a second remaining is lost. Generally
     * this method would be used to show a number to the user. (e.g. Number of seconds until a race starts.) 
     * getTicksRemaining() should be used to determine the real amount of time remaining.
     *
     * @return Number of seconds until the timer expires.
     */
    public long getSecondsRemaining()
    {
        return getTicksRemaining()/getTicksPerSecond();
    }
    
    /**
     * Returns the percentage of the duration remaining. Only the intregal part of the percentage is returned.
     * i.e. The fraction of a percentage remaining is lost. getTicksRemaining() should be used to determine 
     * the real amount of time remaining.
     *
     * @return Percentage of time remaining (0%-100%).
     */
    public int getPercentRemaining()
    {
        return (int)((getTicksRemaining()*100)/duration);
    }
    
    /**
     * Returns the number of clock ticks that have elapsed. When the timer expires, this method will return
     * the value of getDuration().
     *
     * @return Clock ticks that have already passed.
     */
    public long getTicksElapsed()
    {
        if(paused) return pausetime;
        
        return Math.min(duration, timer.getClockTicks()-adjust);
    }
    
    /**
     * Returns the number of seconds that have elapsed. Only
     * the integral number of seconds is returned. i.e. The fraction of a second remaining is lost. Generally
     * this method would be used to show a number to the user. (e.g. Number of seconds a character has held a bomb.) 
     * getTicksElapsed() should be used to determine the real amount of time that has passed.
     *
     * @return The number of seconds that have passed.
     */
    public long getSecondsElapsed()
    {
        return getTicksElapsed()/getTicksPerSecond();
    }
    
    /**
     * Returns the percentage of time elapsed. Only the intregal part of the percentage is returned.
     * i.e. The fraction of a percentage remaining is lost. getTicksRemaining() should be used to determine 
     * the real amount of time that has passed.
     *
     * @return Percentage of time passed (0%-100%).
     */
    public int getPercentElapsed()
    {
        return (int)((getTicksElapsed()*100)/duration);
    }
    
    /**
     * Returns the total amount of time this timer was configured for. This value may be changed by
     * a call to the reset() function.
     *
     * @return The duration this timer will run.
     */
    public long getDuration()
    {
        return duration;
    }
    
    /**
     * Takes a number and scales it to the amount of time remaining. This is useful for progress bars that
     * slowly empty as the clock counts down. Simply pass the total number of pixels in the progress bar, and
     * the correct amount to fill will be returned.
     * 
     * @param value The value to scale.
     * @return The resulting number after the value is multiplied by the amount of time remaining.
     */
    public long scaleToRemainingTime(int value)
    {
        return (getTicksRemaining()*value/getDuration());
    }
    
    /**
     * Takes a number and scales it to the amount of time elapsed. This is useful for progress bars that
     * slowly fill as the clock counts down. Simply pass the total number of pixels in the progress bar, and
     * the correct amount to fill will be returned.
     * 
     * @param value The value to scale.
     * @return The resulting number after the value is multiplied by the amount of time elapsed.
     */
    public long scaleToElapsedTime(int value)
    {
        return (getTicksElapsed()*value/getDuration());
    }
}