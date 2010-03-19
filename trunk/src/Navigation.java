/*
 * Edward Kostreski
 * * Start 03-03-2010
 * Last UPdated 03-17-2010
 */

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JApplet;
import javax.swing.JFrame;


/**
 * @author Eddie
 *
 */
public class Navigation extends JApplet{
	boolean isStandAlone = false;//set to true when the program is running in application mode and not applet mode
	DisplayScreen displayScreen;
	Thread game;
	public Navigation (){
		super();
	}
	
	public void init() {
		this.displayScreen = new DisplayScreen();
		this.setLayout(new BorderLayout());
		this.add(displayScreen,BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void start() {
		super.start();
		game = new Thread(displayScreen);
		game.start();
		this.repaint();
		this.validateTree();
		//displayScreen.run();
	}

	public void stop() {
		super.stop();
		
	}
	
	

	public static void main(String[]args){
		Navigation applet = new Navigation();
		applet.isStandAlone = true;
		JFrame gameFrame = new JFrame("Paint The Game!");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.add(applet, BorderLayout.CENTER);
		gameFrame.setSize(700, 700);
		gameFrame.setVisible(true);
		applet.init();
		applet.start();
		
	}
	
	
	
}
