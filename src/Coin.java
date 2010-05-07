/*
 * Kevin Voellmer
 * Coins do not move, touching them makes you collect them and they are then tallied into your score for the level.
 */

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Coin extends LevelObject{

	public Coin(){
		super(new ImageIcon("coin.png").getImage());
	}//end default constructor
	
	public Coin(int x, int y){
		super(x, y, new ImageIcon("coin.png").getImage());
	}//end constructor

	@Override
	public void increment(long total, long pass) {//this method is not used, only here because it is in the abstract superclass
	}//end increment
	
}//end class
