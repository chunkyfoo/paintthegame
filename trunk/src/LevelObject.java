import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/*
 * Kevin Voellmer
 * LevelObject is the superclass for Coin, Path, Stickman, and Abstract Obstacles (Spikedwall, Doctor, Wall).
 */

public abstract class LevelObject implements Drawable, incrementable{
	int x,y,oldy,oldx;
	Image img;
	static ImageObserver imgObserve;

	public LevelObject(Image img){
		x = -1000;
		y = -1000;
		oldy=-1000;
		oldx=-1000;
		this.img = img;
	}//end default constructor

	public LevelObject(int x, int y, Image img){
		this.x = x;
		this.y = y;
		oldy=y;
		oldx=x;
		this.img = img;
	}//end default constructor

	public void draw(Graphics2D g2){
		if(!(oldx==x) || !(oldy==y))
			g2.drawImage(img, x, y, null);
		else{
			oldy=y;
			oldx=x;
		}//end else
	}//end draw

	abstract public void increment(long total, long pass);

}//end class
