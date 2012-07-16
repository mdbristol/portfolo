package com.dnsalias.java.timer;

import com.dnsalias.java.timer.windows.*;
import com.dnsalias.java.timer.nanotimer.*;

/**
 * This class is an implementation of a timer with an unknown resolution. When loaded, the class
 * queries the OS for the timer resolution and calculates both the leading edge of the "digital wave"
 * and the number of changes per second. Each clock change is then turned into a single clock "tick"
 * which can be used for timing (e.g. Game events).
 */

public class AdvancedTimer
{
    private static long resolution;
    
    private long start = 0;
    private long ticks = 0;
    
    private boolean running = false;
    
    private static NativeTimer wintimer;
    
    public AdvancedTimer()
    {
        if(resolution == 0) init();
    }
    
    private static void init()
    {
        long time = System.currentTimeMillis();
        long prev_time = time;
        
        if(new NanoTimer().available())
        {
            System.out.println("1.5 NanoTimer selected.");
            wintimer = new NanoTimer();
            resolution = 1;
        }
        else if(new WindowsTimer().available())
        {
            wintimer = new WindowsTimer();
            resolution = 1;
        }
        else
        {
            while(time == prev_time) time = System.currentTimeMillis();
            
            resolution = time-prev_time;
            
            time = System.currentTimeMillis();
            prev_time = time;
            
            while(time == prev_time) time = System.currentTimeMillis();
            
            if(time-prev_time < resolution) resolution = time-prev_time;
        }
    }
    
    private long getTime()
    {
        if(wintimer != null) return wintimer.getClockTicks();
        else return System.currentTimeMillis();
    }
    
    /**
     * Starts the timer running. The number of ticks is reset to zero and the timer is synchronized with the
     * leading edge of the wave.
     */
    
    public void start()
    {
        long time = getTime();
        long prev_time = time;
        
        ticks = 0;
        running = true;
        
        //Synchronize our timer
        while(time == prev_time) time = getTime();
        
        start = getTime();
    }
    
    /**
     * Returns the number of clock ticks since the timer was started. If the timer is stopped,
     * the number of ticks will be frozen at the duration between when the clock was started and
     * stopped.
     *
     * @return Number of ticks since the clock started.
     */
    
    public long getClockTicks()
    {
        if(running) ticks = (getTime()-start)/resolution;
        
        return ticks;
    }
    
    /**
     * Stops the timer and freezes the number of clock ticks.
     */
    
    public void stop()
    {
        getClockTicks();
        
        running = false;
    }
    
    /**
     * Convienence method to stop code execution for exactly one clock tick.
     *
     * @see #sleep(long)
     * @throws IllegalStateException Thrown if the timer is not started.
     */
    
    public void sleep() throws IllegalStateException
    {
        sleep(1);
    }
    
    /**
     * Stops code execution for the specified number of clock ticks. To prevent the next
     * tick from being lost, this is implemented as a hard loop that calls Thread.yield().
     * Unless the calling thread is of extremely low priority, this should return almost
     * immediately after the clock changes.
     *
     * @param ticks The number of ticks to wait before returning control
     * @throws IllegalStateException Thrown if the timer is not started.
     */
    
    public void sleep(long ticks) throws IllegalStateException
    {
        long tick = getClockTicks();
        
        if(!running) throw new IllegalStateException("Timer not running!");
        
        while(getClockTicks() < tick+ticks) Thread.yield();
    }
    
    /**
     * Stops code execution until the timer reaches the specified clock tick. This is useful
     * for situations where code may unpredictably take longer than expected. For example:<br><br>
     *
     * <code>
     * long lasttick = 0;<br>
     * <br>
     * timer.start();<br>
     * <br>
     * while(true)<br>
     * {<br>
     *    ...<br>
     *    timer.sleepUntil(lasttick + 2);<br>
     *    lasttick += 2;<br>
     *    ...<br>
     * }<br>
     * </code>
     * <br><br>
     * The above code would lengthen every loop to exactly 2 clock ticks. If the code falls behind,
     * the code will stop sleeping until it catches up. This is implemented using the same hard loop
     * situation as sleep().
     *
     * @param ticks The "time" in clock ticks at which the code should resume execution
     * @throws IllegalStateException Thrown if the timer is not started.
     * @see #sleep(long)
     * 
     */
    
    public void sleepUntil(long ticks) throws IllegalStateException
    {
        if(!running) throw new IllegalStateException("Timer not running!");
        
        while(getClockTicks() < ticks) Thread.yield();
    }
    
    /**
     * Gets the system clock resolution in milliseconds. 
     *
     * @return The time each clock tick takes in milliseconds.
     */
    
    public static long getResolution()
    {
        if(resolution == 0) init();
        
        return resolution;
    }
    
    /**
     * Returns the number of clock ticks that occur per second. If the ticks per second
     * is a non-integral value, only the integral portion is returned.
     *
     * @return Number of clock ticks per second.
     */
    
    public static long getTicksPerSecond()
    {
        if(resolution == 0) init();
        if(wintimer != null) return wintimer.getResolution();
        
        return (1000/getResolution());
    }
}