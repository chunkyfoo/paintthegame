/*
 * Edward Kostreski
 * Start 03-03-2010
 * Last UPdated 03-17-2010
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class DisplayScreen extends JPanel implements Runnable , KeyListener{

	Level level;
	long start;
	long total;
	long pass;
	long pauseTime = (long) 0.0;
	long systemPauseTime = (long) 0.0;
	long frames = 0;
	String sPass = "";
	public boolean notQuit = true;
	public boolean pause = false;
	boolean backgroundOn = false;
	ImageIcon background = null;
	BitSet keys = new BitSet(65535);
	
	public DisplayScreen(){
		level = new Level(new File("testLevel"));
	}

	private long getTime(){
		return System.currentTimeMillis() - pauseTime;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Iterator<LevelObject> levelIterator = level.levelObjects.iterator();
		frames++;
		Graphics2D g2 = (Graphics2D)g;
		if (backgroundOn)
			g2.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), 0, 0, background.getImage().getWidth(this),background.getImage().getHeight(this), this);
		while(levelIterator.hasNext()){
			levelIterator.next().draw(g2);
		}
		g2.setColor(Color.GREEN);
		g2.setFont(g2.getFont().deriveFont(24F));
		g2.drawString("Average FPS = " + String.valueOf(frames/(total/1000.0)), 20, 20);
		g2.drawString(sPass, 20, 50);//lag
		g2.drawString(String.valueOf(total/1000.0),20,70);//time
	}

	public void run() {
		this.setVisible(true);
		start = getTime();
		total = getTime() - start;
		pass = getTime() - total;
		long passt = pass;
		long wPass = 0;//time to increment
		while(notQuit){
			if(pause){
				if(systemPauseTime == 0l)
					systemPauseTime = getTime();
			}
			else{
				if(systemPauseTime > 0l){
					pauseTime += getTime() - systemPauseTime;
					systemPauseTime = 0L;
				}
				total = getTime() - start;
				this.repaint();
				pass = wPass + getTime() - passt;
				//System.out.println(pass);
				wPass = getTime();
				this.increment();
				wPass = getTime() - wPass;
				sPass = String.valueOf(pass);
				pass = 0;
				passt = getTime();
			}
		}//end while
	}//end method run

	private void increment() {
		Iterator<LevelObject> levelIterator = level.levelObjects.iterator();
		while(levelIterator.hasNext()){
			LevelObject obj = levelIterator.next();
			obj.increment(total, pass);
			if(obj instanceof Controlable){
				((Controlable) obj).control(keys);
			}
		}
	}//end iterate

	public void keyPressed(KeyEvent arg0) {
		keys.set(arg0.getKeyCode());	
	}

	public void keyReleased(KeyEvent arg0) {
		keys.set(arg0.getKeyCode(), false);
		
	}

	public void keyTyped(KeyEvent arg0) {
	}
}//end class