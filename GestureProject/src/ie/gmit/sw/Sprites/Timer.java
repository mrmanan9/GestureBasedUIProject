package ie.gmit.sw.Sprites;

public class Timer {

	// variables 
	private long prevTime;
	
	public Timer(){
		//set the current timer in the constructor 
		setPrevTime(System.currentTimeMillis());
	}
	
	//setter
	public long getPrevTime() {
		return prevTime;
	}
	//getter 
	public void setPrevTime(long currentTime) {
		this.prevTime = currentTime;
	}
	
	//reset the timer to current timer 
	public void resetTimer(){
		prevTime = System.currentTimeMillis();
	}
	
	// timer event 
	public boolean timerEvent(int timer){
		if(System.currentTimeMillis() - getPrevTime() > timer){
			resetTimer();
			return true;
		}
		
		return false;
	}
	//if timer is ready
	public boolean isTimerReady(int timer){
		if(System.currentTimeMillis() - getPrevTime() > timer){
			return true;
		}
		
		return false;
	}
	
	
}
