import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HowToPlay extends Applet
{

	/**
	 * @param args
	 */
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
		button.setText("Go Back to Main Screen");
		
		//main.add(p);
		//add(p);
		//p.add(button);
		repaint();
		//buttonPanel.add(button);
		//main.add(buttonPanel);
		//add(button);
		MouseClick click = new MouseClick();
		p.addMouseListener(click);
		setSize(600, 602);
		p.setSize(600,600);
		p.setLocation(4000, 4000);
		add(p);
		//setCursor(curr);
		//p.setCursor(curr);

	}
	public void paint(Graphics g)//method that draws to the screen 
	{

		super.paint(g);

		update(g);//call the update method

	}//end paint method
	public class MouseClick extends MouseAdapter//handles what happens when the user releases mouse

	{

		public void mouseEntered(MouseEvent e)//if the user releases the mouse

		{

			
				p.setCursor(curr);
				System.out.println("ENTERD AREA!");
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
		g.drawImage(instructions, 0,0, 600,402,main);//draws the how to play image
		Graphics pg=p.getGraphics();
		pg.fillRect(0, 0, 200, 200);
		//add(button);
		
		repaint();
		
		
		
	

		
	}//end update method

}
