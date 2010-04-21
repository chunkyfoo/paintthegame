import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Doctor extends LevelObject{
	public Doctor(){
		super(new ImageIcon("Instructions.png").getImage());
	}//end default constructor
	
	public Doctor(int x, int y){
		super(x, y, new ImageIcon("Instructions.png").getImage());
	}//end default constructor
	
	@Override
	public void increment(long total, long pass) {
		// TODO Auto-generated method stub
		
	}//end increment
	
}//end class
