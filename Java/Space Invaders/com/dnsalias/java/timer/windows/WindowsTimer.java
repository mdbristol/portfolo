package com.dnsalias.java.timer.windows;

import com.dnsalias.java.timer.*;

public class WindowsTimer implements NativeTimer
{
    private static boolean loaded = false;
    private static boolean available = false;
    
    public boolean available()
    {
        if(loaded) return available;
        
        System.out.println(System.getProperty("os.name"));
        
        if(System.getProperty("os.name").indexOf("Win") >= 0)
        {
            if(!loaded) available = loadLibrary();
        }
        
        loaded = true;
        
        return available;
    }
    
    private static boolean loadLibrary()
    {
        try
        {
            System.loadLibrary("timer");
            return true;
        }
        catch(Throwable e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public native long getResolution();
    
    public native long getClockTicks();
}