import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/*
 * Kevin Voellmer
 * LevelObject is the superclass for Coin, Path, Stickman, and Abstract Obstacles (Spikedwall, Doctor, Wall).
 */
public abstract class LevelObject implements Drawable, incrementable{
	int oldx, oldy;
	int x,y;
	Image img;
	static ImageObserver imgObserve;
	
	public LevelObject(Image img){
		x = -1000;
		y = -1000;
		this.img = img;
	}//end default constructor
	
	public LevelObject(int x, int y, Image img){
		this.x = x;
		this.y = y;
		this.img = img;
	}//end default constructor
	
	public boolean isMoved() {
		boolean moved;
		if(!(oldx==x) || !(oldy==y)){
			moved = true;
		}//end if
		else{
			oldx=x;
			oldy=y;
			moved = false;
		}//end else
		return moved;
	}//end isMoved
	
	abstract public void draw(Graphics2D g2);//default draw method, will be overiden by StickMan and path

	abstract public void increment(long total, long pass);
	
}//end class
