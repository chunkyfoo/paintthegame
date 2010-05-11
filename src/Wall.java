import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Wall extends LevelObject{
	
	public Wall(){
		//super(new ImageIcon(getClass().getResource("i-beam_Painting.jpg")).getImage());
		super(new ImageIcon("wall.png").getImage());
	}//end default constructor
	
	public Wall(int x, int y){
		super(x, y, new ImageIcon("wall.png").getImage(), new DimensionX());
	}//end default constructor
	
	@Override
	public void increment(long total, long pass) {
		// TODO Auto-generated method stub
		
	}//end increment

}//end class
