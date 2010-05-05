import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;






public class LevelEditor extends Applet
{
	JPanel p = new JPanel();//drawing panel
	DisplayScreen d=new DisplayScreen();
	JScrollPane scrollpane = new JScrollPane(p);
	int scaleFactor=3;
	Image grid;
	
	public void init() //initializes components of the applet
	{
		setSize(600,600);
		mouseScroll scroll= new mouseScroll();
		p.setPreferredSize(new Dimension(500,500));
		scrollpane.setPreferredSize(new Dimension(500,500));
		grid = Toolkit.getDefaultToolkit().getImage("basic grid.png");
		
		add(scrollpane);
		p.addMouseWheelListener(scroll);
		repaint();
	
	}

	public void paint(Graphics g)//method that draws to the screen 
	{

		super.paint(g);

		update(g);//call the update method

	}//end paint method
	public void drawGrid(Graphics g)
	{
		/**
	
		int h=p.getHeight();
		int w=p.getWidth();
		for(int x=w; x>0;x-=5*scaleFactor)
			g.drawLine(x, 0, x, p.getHeight());
		for(int x=h; x>0;x-=5*scaleFactor)
			g.drawLine(0, x, p.getWidth(),x);
			**/

		Image newimg=grid.getScaledInstance(scaleFactor, scaleFactor,Image.SCALE_SMOOTH);
		if((600+scaleFactor*4)>500)
		{
		g.drawImage(grid,0,0,600+scaleFactor*4,600+scaleFactor*4 , this);
		//resize p

		}
		else 
		{
			g.drawImage(grid,0,0,600,600, this);
			scaleFactor=-25;
		}
	}
	public class mouseScroll implements MouseWheelListener
	{
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		
		
		       int notches = e.getWheelRotation();
		       //if ((scaleFactor+notches)<1)
		    	//   scaleFactor=1;
		      // else
		       scaleFactor=scaleFactor+notches;
		       
		       repaint();
		System.out.println("YOU SCOLLED "+ notches);
		
	
	}
	}

	public void update(Graphics g) //method that actually draws
	{
	
		
		Graphics pg=p.getGraphics();
		pg.clearRect(0,0, p.getWidth(), p.getHeight());
		drawGrid(pg);
		
		repaint();
		
	}
	
	
}
