
	import java.applet.Applet;
	import java.awt.*;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseMotionAdapter;
	import java.net.MalformedURLException;
	import java.net.URL;
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
import java.applet.AudioClip;

	public class HowToPlayV2 extends JFrame
	{
		/**
		 * @param args
		 */
		Image instructions;
		Cursor curr=new Cursor(Cursor.HAND_CURSOR);
		JPanel main = new JPanel();
		JPanel p = new JPanel();//drawing panel
		JPanel buttonPanel = new JPanel();//drawing panel
		JButton button=new JButton();
		AudioClip clip=null;


		public  HowToPlayV2() //initializes components of the applet
		{
<<<<<<< .mine
			 instructions = Toolkit.getDefaultToolkit().getImage("Instructions.png");
			Container content = this.getContentPane();

			setTitle("TESTING");
			main.add(p);
		main.setBackground(Color.white);
			this.pack();
=======
		//	 instructions = getImage(getCodeBase(), "Instructions.png");
			button.setText("Go Back to Main Screen");
			
			//main.add(p);
			//add(p);
>>>>>>> .r81
			//p.add(button);
	//		repaint();
			System.out.println("WHY WONT SIZE WORK");
			//buttonPanel.add(button);
			//main.add(buttonPanel);
			//add(button);
			MouseClick click = new MouseClick();
			p.addMouseListener(click);
<<<<<<< .mine
			repaint();
			setSize(600, 502);
			clip=getAudioClip("doh.wav");
	   	
			p.setPreferredSize(new Dimension(200,50));
=======
			setSize(900, 902);
			setLayout(new BorderLayout());
			//main.add(p);
			add(main,BorderLayout.SOUTH);
			add(p,BorderLayout.NORTH);
			p.setLocation(20,400);
			p.setPreferredSize(new Dimension(600,402));
>>>>>>> .r81
			

			p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			content.repaint();

<<<<<<< .mine
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
>>>>>>> .r81

		}
		public void paint(Graphics g)//method that draws to the screen 
		{
			super.paint(g);

			update(g);//call the update method

		}//end paint method
		public class MouseClick extends MouseAdapter//handles what happens when the user releases mouse

		{
<<<<<<< .mine
			public void mouseClicked(MouseEvent e)
			{	
=======
>>>>>>> .r81

<<<<<<< .mine
					System.out.println("OUTTTTTT!");
					setVisible(false);
					repaint();				
=======
			public void mouseEntered(MouseEvent e)//if the user releases the mouse
>>>>>>> .r81

<<<<<<< .mine
			}

					public void mouseEntered(MouseEvent e)//if the user releases the mouse

=======
>>>>>>> .r81
			{
				
					p.setCursor(curr);
					System.out.println("ENTERD AREA!");
					repaint();
					clip.play();

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
<<<<<<< .mine
			repaint();
			g = getGraphics();
			g.drawImage(instructions, 0,65, 600,402,main);//draws the how to play image
=======
			Graphics m = main.getGraphics();
			m.drawImage(instructions, 0,0, 600,402,main);//draws the how to play image
>>>>>>> .r81
			Graphics pg=p.getGraphics();
			pg.setColor(Color.WHITE);
			pg.fillRect(0, 0, 250, 250);
			pg.setColor(Color.BLACK);
			pg.drawString("CLOSE THIS", 50, 20);
			
			repaint();					
			
		}//end update method

		public static AudioClip getAudioClip(String fileName) {
			URL address = null;
			try {
				address = new URL("file:" + "/Volumes/STUHOME/10779309/My Documents/" + fileName);
				//the above for testing only! grey this out and use the code below:
				//address = new URL("file:" + System.getProperty("user.dir") + "\\" + fileName);//change this to your own directory
			} catch (MalformedURLException mfurle) {
				System.err.println("Couldn't make URL: " + mfurle);
				System.out.println("HAHALOSER YOU FAIL");
			}
			
			return Applet.newAudioClip(address);
		}

}
