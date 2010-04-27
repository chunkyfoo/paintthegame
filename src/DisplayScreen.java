/*
 * Edward Kostreski
 * Start 03-03-2010
 * Last UPdated 03-17-2010
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;

import javax.swing.JPanel;


public class DisplayScreen extends JPanel implements Runnable{

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
		while(levelIterator.hasNext()){
			levelIterator.next().draw(g2);
		}
		g2.setColor(Color.GREEN);
		g2.setFont(g2.getFont().deriveFont(24F));
		g2.drawString("Average FPS = " + String.valueOf(frames/(total/1000.0)), 20, 20);
		g2.drawString(sPass, 20, 50);//lag
		g2.drawString(String.valueOf(total/1000.0),20,70);//time
		//System.out.println(this.getWidth());
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
			levelIterator.next().increment(total, pass);
		}
	}//end iterate
}//end class