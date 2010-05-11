import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Door extends LevelObject{

	public Door(){
		super(new ImageIcon("door.png").getImage());
	}//end default constructor
	
	public Door(int x, int y){
		super(x, y, new ImageIcon("door.png").getImage(), new DimensionX());
	}//end constructor

	@Override
	public void increment(long total, long pass) {//this method is not used, only here because it is in the abstract superclass
	}//end increment
	
}//end class
