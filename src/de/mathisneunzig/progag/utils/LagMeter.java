package de.mathisneunzig.progag.utils;

public class LagMeter implements Runnable{
	
	  private double currentTPS;
	  private long last;
	  
	  public LagMeter()
	  {
	    this.currentTPS = 20.0D;
	    this.last = System.currentTimeMillis();
	  }
	  
	  public void run()
	  {
	    long currentTime = System.currentTimeMillis();
	    long elapsed = currentTime - this.last;
	    
	    this.currentTPS = (elapsed / 50.0D);
	    
	    this.last = currentTime;
	  }
	  
	  public double getCurrent() {
	  
	    return this.currentTPS;
	  }
	  
}