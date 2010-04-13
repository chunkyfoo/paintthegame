	import java.applet.*;
	import java.awt.*;
	import java.net.*;
import javax.swing.*;
public class PasswordScreen extends JFrame
{
	JPanel main = new JPanel();
	JTextPane pass=new JTextPane();
	public PasswordScreen()
	{
		Container content = this.getContentPane();

		setTitle("Enter Password");
		this.pack();
		setSize(600, 502);
		main.setBackground(Color.BLACK);
		main.add(pass);
		add(main);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)//method that draws to the screen 
	{
		super.paint(g);

		update(g);//call the update method

	}//end paint method
	public void update(Graphics g) //method that actually draws
	{

		repaint();

		Graphics m = main.getGraphics();
		m.setColor(Color.WHITE);
		m.drawString("Please Enter Your Password to Access this Level:",160,180);

	
		
		repaint();					
		
	}//end update method
}
