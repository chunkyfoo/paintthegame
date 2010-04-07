import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/*
 * Kevin Voellmer
 * Coins do not move, touching them makes you collect them and they are then tallied into your score for the level.
 */
public class Coin extends LevelObject{

	public Coin(){
		super(new ImageIcon("Instructions.png").getImage());
	}//end default constructor
	
	public Coin(int x, int y){
		super(x, y, new ImageIcon("Instructions.png").getImage());
	}//end constructor

	@Override
	public void draw(Graphics2D g2) {
		if(!(oldx==x) || !(oldy==y))
		g2.drawImage(img, x, y, null);
		else{
			oldy=y;
			oldx=x;
		}//end else
	}//end draw

	@Override
	public void increment(long total, long pass) {//this method is not used, only here because it is in the abstract superclass
	}//end increment
	
}//end class
