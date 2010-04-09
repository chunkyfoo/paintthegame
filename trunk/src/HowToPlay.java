import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class HowToPlay extends Applet
{

	/**
	 * @param args
	 */
	Boolean close=false;
	int x;
	int y;
	Image instructions;
	Cursor curr=new Cursor(Cursor.HAND_CURSOR);
	//GridLayout experimentLayout = new GridLayout(0,2);
	JPanel main = new JPanel();
	JPanel p = new JPanel();//drawing panel
	JPanel buttonPanel = new JPanel();//drawing panel
	JButton button=new JButton();

	public void init() //initializes components of the applet
	{
		 instructions = getImage(getCodeBase(), "Instructions.png");

		repaint();
		
		MouseClick click = new MouseClick();
		p.addMouseListener(click);
		setSize(600, 502);
		add(p);
		p.setLocation(500, 10);
		p.setPreferredSize(new Dimension(200,50));
		p.setBackground(Color.WHITE);

		p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));


	}
	public void paint(Graphics g)//method that draws to the screen 
	{

		super.paint(g);

		update(g);//call the update method

	}//end paint method
	public class MouseClick extends MouseAdapter//handles what happens when the user releases mouse

	{
		public void mouseClicked(MouseEvent e)
		{	
			x=e.getX();
			y=e.getY();

		//	if(x>0)
				System.out.println("OUTTTTTT!");
				close=true;

			


		}
		public void mouseEntered(MouseEvent e)//if the user releases the mouse

		{

			
				p.setCursor(curr);
				System.out.println("ENTERED AREA!");
				repaint();
			


			repaint();

			repaint();

		}//end mouseEntered method
		public void mouseExit(MouseEvent e)
		{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}//end MouseClick class


	public void update(Graphics g) //method that actually draws
	{
		g = getGraphics();
		g.drawImage(instructions, 0,50, 600,402,main);//draws the how to play image
		Graphics pg=p.getGraphics();
		pg.setColor(Color.WHITE);
		pg.fillRect(0, 0, 250, 250);
		pg.setColor(Color.BLACK);
		pg.drawString("CLOSE THIS", 50, 20);
		
		repaint();
		
		
		
	

		
	}//end update method

}
