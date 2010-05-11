import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Doctor extends LevelObject{
	double radians;
	double distance;
	double interval;
	boolean horizontal;
	public Doctor(){
		super(new ImageIcon("Doctor.png").getImage());
		radians =  0;
		distance = 0;
		interval = 0;
		horizontal = false;
	}//end default constructor

	public Doctor(int x, int y, double distance, double interval, boolean horizontal){
		super(x, y, new ImageIcon("Doctor.png").getImage(), new DimensionX());
		radians = 0;
		this.distance = distance;
		this.interval = interval;
		this.horizontal = horizontal;
	}//end default constructor

	public void draw(Graphics2D g2) {
		if(horizontal)
		g2.drawImage(img, x + (int)(distance*Math.sin(radians)), y, null);
		else
		g2.drawImage(img, x, y + (int)(distance*Math.sin(radians)), null);
	}//end draw
	
	@Override
	public void increment(long total, long pass) {
		radians += 2 * Math.PI * (double)pass / interval;
		while(radians >= 2 *Math.PI){
			radians -= 2 * Math.PI;
		}//end while
	}//end increment

}//end class
