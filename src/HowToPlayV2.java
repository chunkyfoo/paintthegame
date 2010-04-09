

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

	public class HowToPlayV2 extends JFrame
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


		public  HowToPlayV2() //initializes components of the applet
		{
			Container content = this.getContentPane();

			setTitle("TESTING");

			//add(p);
			content.add(main);
			MouseClick click = new MouseClick();
			p.addMouseListener(click);
			this.setSize(900, 902);
			content.setLayout(new BorderLayout());
			main.add(p);
			//add(main,BorderLayout.SOUTH);
			//add(p,BorderLayout.NORTH);
			//p.setLocation(20,400);
			p.setPreferredSize(new Dimension(600,402));
			
		//	p.setSize(800,800);
			p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		//	p.setLocation(4000, 4000);
			
			//setCursor(curr);
			//p.setCursor(curr);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.pack();   // does layout of components.

		}
		public void paint(Graphics g)//method that draws to the screen 
		{
			Graphics m = main.getGraphics();
			m.drawImage(instructions, 0,0, 600,402,main);//draws the how to play image
			Graphics pg=p.getGraphics();
			pg.setColor(Color.BLACK);
			pg.drawOval(20, 20, 400, 200);

			super.paint(g);

		//	update(g);//call the update method

		}//end paint method

		public class MouseClick extends MouseAdapter//handles what happens when the user releases mouse

		{
			public void mouseClicked(MouseEvent e)
			{	
				x=e.getX();
				y=e.getY();

			//	if(x>0)
					System.out.println("OUTTTTTT!");
					System.exit(0);
				


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
			
			Graphics m = main.getGraphics();
			m.drawImage(instructions, 0,0, 600,402,main);//draws the how to play image
			Graphics pg=p.getGraphics();
			pg.fillRect(0, 0, 2150, 2510);
			//add(button);
			
			repaint();
			
			
			
		

			
		}//end update method

	

}
