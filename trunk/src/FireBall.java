/*
 * Start 03-03-2010
 * Last UPdated 03-17-2010
 * This Class serves as an example of extending Level Object
 */

import java.awt.Color;
import java.awt.Graphics2D;


public class FireBall extends LevelObject implements Drawable,incrementable{
	int x;
	int y;
	int radius;
	int size;
	Color color;
	double radians;
	double speed;
	
	
	public FireBall(int x, int y, int radius, int size, Color color,double speed) {
		super(null);
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.size = size;
		this.color = color;
		this.radians = 0.0;
		this.speed = speed;
	}

	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fillOval(this.x + (int)(radius * Math.cos(radians)),this.y + (int)(radius * Math.sin(radians)), size, size);
	}

	public void increment(long total, long pass) {
		radians += (speed * 2.0 * Math.PI * (double)pass / 1000.0);
		while(radians >= 2 *Math.PI){
			radians -= 2 * Math.PI;
		}		
	}

}
