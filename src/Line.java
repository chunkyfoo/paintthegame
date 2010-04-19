import java.awt.Graphics2D;

public class Line implements Drawable{
	
	int x1,y1,x2,y2;
	
	public Line(){
		x1=0;
		y1=0;
		x2=0;
		y2=0;
	}//end default constructor
	
	public Line(int x1, int y1){
		this.x1=x1;
		this.y1=y1;
	}//end constructor
	
	public Line(int x1, int y1, int x2, int y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}//end constructor
	
	public int getSlope(){
		return((y2-y1)/(x2-x1));
	}//end getSlope

	public void draw(Graphics2D g2) {
		g2.drawLine(x1, y1, x2, y2);
	}//end draw
	
}//end class
