/*
 * Edward Kostreski
 * * Start 03-03-2010
 * Last UPdated 03-17-2010
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Navigation extends JApplet{
	boolean isStandAlone = false;//set to true when the program is running in application mode and not applet mode
	DisplayScreen displayScreen;
	boolean pause = false;
	JButton jbtScores = new JButton("High Scores");
	JToggleButton jtgbtPause = new JToggleButton("Press to Pause");
	JButton jbtHowToPlay = new JButton("Instructions");
	JButton jbtMainMenu = new JButton("Quit to Main Menu");
	JButton jbtMedia = new JButton("Music and Background");
	Thread game;
	JFrame window=new HowToPlayV2();
	AudioClip[] audioClips = loadAudioClips();
	ImageIcon[] icons = loadBackgrounds();
	public Navigation (){
		super();
	}

	private ImageIcon[] loadBackgrounds() {
		File folder = new File("src/background/");
		File[] listOfFiles = folder.listFiles();
		int files = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				files++;
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		System.out.println("size=" + files + " , "+listOfFiles.length);
		ImageIcon[] backgrounds = new ImageIcon[files];
		int b=-1;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				backgrounds[++b] = new ImageIcon(getClass().getResource("background/" + listOfFiles[i].getName()));

			}
		}

		return backgrounds;
	}

	private AudioClip[] loadAudioClips() {
		File folder = new File("src/music/");
		File[] listOfFiles = folder.listFiles();
		int files = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				files++;
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		AudioClip[] clips = new AudioClip[files];
		int b=-1;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//System.out.println(getClass().getResource("music/" + listOfFiles[i].getName()));
				System.out.println(listOfFiles[i].getAbsolutePath());
				System.out.println(this.getClass().getResource("music/allianc1.mid"));
				//clips[i] = Applet.newAudioClip(getClass().getResource("music/" + listOfFiles[i].getName()));
				clips[++b] = Applet.newAudioClip(getClass().getResource("music/" + listOfFiles[i].getName()));
			}
		}

		return clips;
	}

	public void init() {
		this.displayScreen = new DisplayScreen();
		this.setLayout(new BorderLayout());
		this.add(displayScreen,BorderLayout.CENTER);
		jbtScores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showHighScores();
			}
		});
		jtgbtPause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(pause){
					unPause();
					jtgbtPause.setText("Press to Pause");
				}
				else if(!pause){
					pause();
					jtgbtPause.setText("Press to Resume");
				}
			}
		});
		jbtHowToPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				howToPlay();
			}
		});
		jbtMainMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainMenu();
			}
		});
		jbtMedia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showMedia();
			}
		});
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,5));
		southPanel.add(jtgbtPause);
		southPanel.add(jbtScores);
		southPanel.add(jbtHowToPlay);
		southPanel.add(jbtMainMenu);
		southPanel.add(jbtMedia);
		this.add(southPanel,BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public void start() {
		super.start();
		game = new Thread(displayScreen);
		game.start();
		this.repaint();
		this.validateTree();
		audioClips[0].loop();
	
		//displayScreen.run();
	}

	public void stop() {
		super.stop();

	}

	public void howToPlay(){
		window.setVisible(true);
	}

	public void showHighScores(){
		HighScore highScore = new HighScore();
		highScore.showScores();
	}

	public void mainMenu() {
		// TODO Auto-generated method stub

	}

	public void showMedia(){

	}

	public void pause(){
		pause = true;
		displayScreen.pause = true;
	}

	public void unPause(){
		pause = false;
		displayScreen.pause = false;
	}

	public static void main(String[]args){
		Navigation applet = new Navigation();
		//applet.isStandAlone = true;
		//JFrame gameFrame = new JFrame("Paint The Game!");
		//gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gameFrame.add(applet, BorderLayout.CENTER);
		//gameFrame.setSize(700, 700);
		//gameFrame.setVisible(true);
		try{
			RemoveMaxAndMinButton frame = new RemoveMaxAndMinButton(new JFrame(),
			"Paint The Game!");
			frame.setResizable(false);
			//JPanel panel = new JPanel();
			//panel.setSize(200,200);
			//JLabel lbl = new JLabel("RoseIndia.Net");
			//panel.add(lbl);
			//frame.add(panel);
			frame.add(applet, BorderLayout.CENTER);
			frame.setSize(900, 900);
			frame.setVisible(true);
		}
		catch(IllegalArgumentException e){
			System.exit(0);
		}
		applet.init();
		applet.start();

	}

}

