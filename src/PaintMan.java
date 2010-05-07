import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.BitSet;

import javax.swing.ImageIcon;


public class PaintMan extends LevelObject implements Controlable {
	boolean left = false; int keyLeft;
	boolean right = false; int keyRight;
	boolean up = false; int keyUp;
	boolean down = false;int keyDown;
	int xOriginal;
	int yOriginal;
	double xshift;
	double yshift;
	double speed;

	public PaintMan(int x, int y) {
		super(x,y,null);
		xOriginal = x;
		yOriginal = y;
		this.img = loadImage();
		xshift = 0.0;
		yshift = 0.0;
		keyLeft = KeyEvent.VK_A;
		keyRight = KeyEvent.VK_D;
		keyUp = KeyEvent.VK_W;
		keyDown = KeyEvent.VK_S;
		speed = 250.0;
	}

	private Image loadImage() {
		return new ImageIcon(getClass().getResource("images/" + "stickdemo.png")).getImage();
	}

	public PaintMan(int x, int y, Image img) {
		super(x, y, img);
		keyLeft = KeyEvent.VK_A;
		keyRight = KeyEvent.VK_D;
		keyUp = KeyEvent.VK_W;
		keyDown = KeyEvent.VK_S;
		speed = 1000.0;
	}

	@Override
	public void increment(long total, long pass) {
		double pix = ((speed * (double)pass)/(double)1000.0);
		//System.out.println("pix=" + pix);
		//System.out.println("speed=" + speed);
		//System.out.println("pass=" + pass);

		if(left){
			xshift-=pix;
			System.out.println("OH");
		}
		if(right){
			xshift+=pix;
		}
		if(up){
			yshift-=pix;
		}
		if(down){
			yshift+=pix;
		}
		this.x = (int) (xOriginal + xshift);
		this.y = (int) (yOriginal + yshift);
	}

	public void control(BitSet bitset) {
		left = (bitset.get(keyLeft));
		right = (bitset.get(keyRight));
		up = (bitset.get(keyUp));
		down = (bitset.get(keyDown));
	}

}
