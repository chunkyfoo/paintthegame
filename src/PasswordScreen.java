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
public class PasswordScreen extends JFrame implements ActionListener
{
	JPanel main = new JPanel();
	Cursor curr=new Cursor(Cursor.HAND_CURSOR);
	JTextField pass=new JTextField(15);
	JButton enter=new JButton("Go!");
	JPanel p = new JPanel();//drawing panel
	Boolean match=false;
	int levelForPass=2;
	Boolean wrongPass=false;
	AudioClip clip=null;
	public PasswordScreen()
	{

		Container content = this.getContentPane();
		clip=Applet.newAudioClip(getClass().getResource("doh.wav"));
		setTitle("Enter Password");
		this.pack();
		setSize(600, 502);
		main.setLayout(new FlowLayout());
		main.setBackground(Color.BLACK);
		pass.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					enter.doClick();
				}
			}
		});

		p.setPreferredSize(new Dimension(200,50));
		MouseClick click = new MouseClick();
		p.addMouseListener(click);
		
		for(int x=1;x<73;x++)
			main.add(new JLabel("                    "));
		//ok that was ghetto to the max but I had to be able to space the layout somehow
		
		main.add(pass);
			main.add(new JLabel(" "));


		enter.setBackground(Color.BLACK);
		main.add(enter);
		
		for(int x=1;x<70;x++)
		main.add(new JLabel("                 "));
		
		main.add(p);
		enter.addActionListener(this);
		add(main);
		 this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 this.setResizable(false);
		 
	
	}
	
	public void actionPerformed(ActionEvent evt)
	{

		try {
			
			passwordMatch();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (match==true)
		{
			pass.setVisible(false);
			enter.setVisible(false);
		}
		
		
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

				//System.out.println("OUTTTTTT!");//TESTING FLAG
				setVisible(false);//minimize
							

		}

				public void mouseEntered(MouseEvent e)//if the user releases the mouse


		{
			
				p.setCursor(curr);
				//System.out.println("ENTERD AREA!");
			
				clip.play();

	

		}//end mouseEntered method
		public void mouseExit(MouseEvent e)
		{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}//end MouseClick class
	public void passwordMatch() throws IOException
	{
		String correctPass;
		match=false;
		wrongPass=false;
		levelForPass=2;
		String enteredPass;
		BufferedReader in =
			new BufferedReader(new InputStreamReader(System.in));

			FileReader textfile = new FileReader("src\\Passwords\\passwords.txt");// create new object

			// FileReader
			Scanner src =
			new Scanner(textfile);// create object src in class
			enteredPass=pass.getText();
			//System.out.println(enteredPass);
			do
			{
				correctPass=src.nextLine();
				if (enteredPass.equals(correctPass))
				{
					//System.out.println("TRUE! Real pass was "+correctPass+" and you entered "+enteredPass);
					match=true;	
					break;
				}
				else
					levelForPass++;
				
			}
			while (src.hasNextLine());
			if(match==false)
			{
				//System.out.println("FALSE! Real pass was "+correctPass+" and you entered "+enteredPass);
				pass.setText("");
				levelForPass=2;
				wrongPass=true;
			}
			else
			{
				//System.out.println("You can now access level " +levelForPass);
			
			}


	}
	public void update(Graphics g) //method that actually draws
	{

		repaint();

		Graphics m = main.getGraphics();
		m.setColor(Color.WHITE);
		if((match==false)&&(wrongPass==false))
		{
			p.setVisible(true);
		m.drawString("Please Enter Your Password to Access this Level:",160,180);
		closeThisButton();
		}
		else if ((match==false)&&(wrongPass==true))
		{
			p.setVisible(true);
			m.setColor(Color.BLACK);
			m.fillRect(50, 100, 450, 100);
			m.setColor(Color.WHITE);
			m.drawString("Wrong password, please enter the right one, dumbass", 120, 180);
			
			closeThisButton();
		}
			
		else
		{
			m.setColor(Color.BLACK);
			m.fillRect(50, 100, 500, 400);
			m.setColor(Color.WHITE);
			m.drawString("Now Loading Level... "+levelForPass, 160, 180);
			p.setVisible(false);
		}
		
	}//end update method
	public void closeThisButton()//initializes the button that says "Go Back"
	{
		Graphics pg=p.getGraphics();
		pg.setColor(Color.BLACK);
		pg.fillRect(0, 0, 250, 250);
		pg.setColor(Color.RED);
		pg.drawString("Go back to main menu", 50, 20);
	}

}
