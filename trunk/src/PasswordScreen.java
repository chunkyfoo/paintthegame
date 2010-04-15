	import java.applet.*;
	import java.awt.event.*;
	import
	java.io.BufferedReader;
import java.io.FileNotFoundException;
	import
	java.io.FileReader;
	import
	java.io.IOException;
	import
	java.io.InputStreamReader;
	import
	java.util.*;
	import java.awt.*;
	import java.net.*;
import javax.swing.*;
public class PasswordScreen extends JFrame
{
	JPanel main = new JPanel();
	JTextField pass=new JTextField(15);
	JButton enter=new JButton("Go!");
	public PasswordScreen()
	{
		Container content = this.getContentPane();

		setTitle("Enter Password");
		this.pack();
		setSize(600, 502);
		main.setLayout(new FlowLayout());
		main.setBackground(Color.BLACK);
		
		for(int x=1;x<70;x++)
			main.add(new JLabel("                    "));
		//ok that was ghetto to the max but I had to be able to space the layout somehow
		
		main.add(pass);
			main.add(new JLabel(" "));
			enter.setToolTipText("Make sure your case is correct!");
			enter.addActionListener((ActionListener) this);
		enter.setBackground(Color.BLACK);
		main.add(enter);
		
		System.out.println(getComponentZOrder(pass));
		add(main);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	}
	public void paint(Graphics g)//method that draws to the screen 
	{
		super.paint(g);

		update(g);//call the update method

	}//end paint method
	public void passwordMatch() throws IOException
	{
		String correctPass;
		int levelForPass=1;
		String enteredPass;
		BufferedReader in =
			new BufferedReader(new InputStreamReader(System.in));

			FileReader textfile = new FileReader("passwords.txt");// create new object

			// FileReader
			Scanner src =
			new Scanner(textfile);// create object src in class
			do
			{
				correctPass=src.nextLine();
				System.out.println(correctPass);
				enteredPass=enter.getText();
				if (enteredPass.equals(correctPass))
				{
					
				}
				
			}
			while (src.hasNextLine());


	}
	public void update(Graphics g) //method that actually draws
	{

		repaint();

		Graphics m = main.getGraphics();
		m.setColor(Color.WHITE);
		m.drawString("Please Enter Your Password to Access this Level:",160,180);

	
		
		repaint();					
		
	}//end update method
}
