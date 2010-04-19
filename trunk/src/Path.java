import java.awt.Graphics2D;
import java.util.ArrayList;


public class Path implements Drawable{

	ArrayList<Line> lines;
	
	public Path(){
		lines = new ArrayList<Line>();
	}//end default constructor
	
	public Path(Line line){
		lines = new ArrayList<Line>();
		lines.add(line);
	}//end default constructor
	
	public void addLine(Line line){//adds a new line to the arraylist
		lines.add(line);
	}//end addLine

	public void draw(Graphics2D g2) {
		for(Line x:lines){
			x.draw(g2);
		}//end for
	}//end draw
	
}//end class
