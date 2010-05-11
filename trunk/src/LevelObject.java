import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/*
 * Kevin Voellmer
 * LevelObject is the superclass for Coin, Path, Stickman, and Abstract Obstacles (Spikedwall, Doctor, Wall).
 */

public abstract class LevelObject implements Drawable, incrementable{
	DimensionX dim;
	int x,y,oldy,oldx;
	Image img;
	static ImageObserver imgObserve;

	public LevelObject(){
		x = -1000;
		y = -1000;
		dim = new DimensionX();
	}//end default constructor

	public LevelObject(int x, int y, DimensionX dim){
		this.x = x;
		this.y = y;
		this.img = img;
		this.dim = dim;
	}//end default constructor

	public void draw(Graphics2D g2){
			g2.drawImage(img, x, y, null);
	}//end draw

	public DimensionX getDimensions(){
		return dim;
	}//end getDimensions
	
	abstract public void increment(long total, long pass);

}//end class
