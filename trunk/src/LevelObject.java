/*
 * Kevin Voellmer
 * LevelObject is the superclass for Coin, Path, Stickman, and Abstract Obstacles (Spikedwall, Doctor, Wall).
 */
public class LevelObject {
	int x,y;
	image img;
	
	public LevelObject(Image img){
		x = -1000;
		y = -1000;
		this.img = img;
		
	}//end default constructor
	
	public void draw(Graphics2D g2){//default draw method, will be overiden by StickMan and path
		
	}//end draw
	
}//end class
