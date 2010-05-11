import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Wall extends LevelObject{
	
	public Wall(){
		this.img = new ImageIcon(getClass().getResource("images/" + "wall.png")).getImage();
	}//end default constructor
	
	public Wall(int x, int y){
		super(x, y, new DimensionX());
		this.img = new ImageIcon(getClass().getResource("images/" + "wall.png")).getImage();
	}//end default constructor
	
	@Override
	public void increment(long total, long pass) {
		// TODO Auto-generated method stub
		
	}//end increment

}//end class
