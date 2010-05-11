import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/*
 * Kevin Voellmer
 * This is the main character, his movement will be controlled by the player
 */

public class StickMan extends LevelObject{
	public StickMan(){
		this.img = new ImageIcon(getClass().getResource("images/" + "sprite.png")).getImage();
	}//end default constructor
	
	public StickMan(int x, int y){
		super(x, y, new DimensionX());
		this.img = new ImageIcon(getClass().getResource("images/" + "sprite.png")).getImage();
	}//end default constructor

	@Override
	public void increment(long total, long pass) {
		// TODO Auto-generated method stub
		
	}//end increment
	
}//end class
