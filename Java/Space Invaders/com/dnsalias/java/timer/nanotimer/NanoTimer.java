package com.dnsalias.java.timer.nanotimer;

import com.dnsalias.java.timer.*;

public class NanoTimer implements NativeTimer
{
    public boolean available()
    {
        String version = System.getProperty("java.vm.version");
        String sub = version.substring(version.indexOf(".")+1);
        
        if(Integer.parseInt(sub.charAt(0)+"") >= 5) return true;
        
        return false;
    }
    
    public long getResolution()
    {
        return 1000000000L;
    }
    
    public long getClockTicks()
    {
        return System.nanoTime();
    }
}