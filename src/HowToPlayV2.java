
	import java.applet.Applet;
	import java.awt.*;
	import java.awt.image.BufferedImage;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URL;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.imageio.ImageIO;
	import javax.swing.JPanel;
	import javax.swing.border.BevelBorder;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.EtchedBorder;
	import javax.swing.border.LineBorder;
	import javax.swing.border.MatteBorder;
	import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.applet.AudioClip;

	public class HowToPlayV2 extends JFrame//JFrame version of HowToPlay class
	{
		/**
		 * @param args
		 */
		
		Cursor curr=new Cursor(Cursor.HAND_CURSOR);
		JPanel main = new JPanel();
		JPanel p = new JPanel();//drawing panel
		JPanel buttonPanel = new JPanel();//drawing panel
		JButton button=new JButton();
		AudioClip clip=null;
		BufferedImage img;


		public  HowToPlayV2() throws IOException//initializes components of the applet 
		{
			

			img=ImageIO.read(getClass().getResource("Instructions.png"));

			
			Container content = this.getContentPane();

			setTitle("How To Play");
			main.add(p);
			main.setBackground(Color.white);
			this.pack();//refreshes the main component panel

			MouseClick click = new MouseClick();
			p.addMouseListener(click);

			setSize(600, 502);
			clip=Applet.newAudioClip(getClass().getResource("doh.wav"));
	   	
			p.setPreferredSize(new Dimension(200,50));

			setLayout(new BorderLayout());
			add(main);

			p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			

			 this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


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

					//System.out.println("OUTTTTTT!");
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


		public void update(Graphics g) //method that actually draws
		{

			

			Graphics m = main.getGraphics();
			m.drawImage(img, 0,65, 600,402,main);//draws the how to play image

			Graphics pg=p.getGraphics();
			pg.setColor(Color.WHITE);
			pg.fillRect(0, 0, 250, 250);
			pg.setColor(Color.RED);
			pg.drawString("CLOSE THIS", 50, 20);
			
		
		}//end update method

		

}
