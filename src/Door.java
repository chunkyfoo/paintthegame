import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Door extends LevelObject{

	public Door(){
		this.img = new ImageIcon(getClass().getResource("images/" + "door.png")).getImage();
	}//end default constructor

	public Door(int x, int y){
		super(x, y, new DimensionX());
		this.img = new ImageIcon(getClass().getResource("images/" + "door.png")).getImage();
	}//end constructor

	@Override
	public void increment(long total, long pass) {//this method is not used, only here because it is in the abstract superclass
	}//end increment

}//end class
