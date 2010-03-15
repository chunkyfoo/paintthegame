import java.applet.Applet;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HowToPlay extends Applet
{

	/**
	 * @param args
	 */
	Image instructions;
	JPanel main = new JPanel();
	JPanel p = new JPanel();//drawing panel
	JPanel buttonPanel = new JPanel();//drawing panel
	JButton button=new JButton();

	public void init() //initializes components of the applet
	{
		instructions = getImage(getCodeBase(), "Instructions.png");
		button.setText("Go Back to Main Screen");
		
		main.add(p);
		buttonPanel.add(button);
		main.add(buttonPanel);
		//add(button);
		setSize(600, 602);

	}
	public void paint(Graphics g)//method that draws to the screen 
	{

		super.paint(g);

		update(g);//call the update method

	}//end paint method

	public void update(Graphics g) //method that actually draws
	{
		g = getGraphics();
		g.drawImage(instructions, 0,0, 600,402,p);//draws the how to play image
		
		repaint();
		
		
		
	

		
	}//end update method

}
