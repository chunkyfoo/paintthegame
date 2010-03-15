import java.awt.Graphics2D;
import java.awt.Image;

/*
 * Kevin Voellmer
 * LevelObject is the superclass for Coin, Path, Stickman, and Abstract Obstacles (Spikedwall, Doctor, Wall).
 */
public class LevelObject {
	int x,y;
	Image img;
	
	public LevelObject(){
		
	}//end default constructor
	
	public void draw(Graphics2D g2){//default draw method, will be overiden by StickMan and path
		
	}//end draw
	
}//end class
