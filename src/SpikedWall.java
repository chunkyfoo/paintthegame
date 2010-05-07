import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class SpikedWall extends LevelObject{
	
	public SpikedWall(){
		super(new ImageIcon("spike.png").getImage());
	}//end default constructor
	
	public SpikedWall(int x, int y){
		super(x, y, new ImageIcon("spike.png").getImage());
	}//end default constructor

	@Override
	public void increment(long total, long pass) {
		// TODO Auto-generated method stub
		
	}//end increment

}//end class
