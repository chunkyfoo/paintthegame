import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OptionMenu extends JFrame{
	int musicN = 0;
	boolean musicOn = false;
	int backgroundN = 0;
	boolean backgroundOn = false;
	AudioClip[] audioClips;
	String[] audioTittles;
	ImageIcon[] icons;
	String[] iconsTittles;
	JPanel jpTittle;
	JPanel jpAudio;
	JCheckBox jcbAudio;
	JButton jbtAudio;
	JLabel jlbAudio;
	JPanel jpImage;
	JCheckBox jcbImage;
	JButton jbtImage;
	JLabel jlbImage;
	Navigation navigation;


	public static void main(String[]args){

	}

	public OptionMenu(Navigation navigation){
		load();
		this.navigation = navigation;
		this.setTitle("Options Menu");
		this.setSize(600, 150);
		jpTittle = new JPanel();
		jpTittle.setLayout(new GridLayout(1,3));
		jpTittle.add(new JLabel("ON/OFF"));
		jpTittle.add(new JLabel("NEXT"));
		jpTittle.add(new JLabel("FILE NAME"));

		jpAudio = new JPanel();

		jcbAudio = new JCheckBox("Music");
		jcbAudio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				checkMusic();
			}


		});
		jbtAudio = new JButton("Next Song");
		jbtAudio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				nextMusic();
			}
		});
		jlbAudio = new JLabel(audioTittles[0]);
		jpImage = new JPanel();
		jcbImage = new JCheckBox("Background");
		jcbImage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				checkBackground();
			}
		});
		jbtImage = new JButton("Next Background");
		jbtImage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				nextBackground();
			}
		});
		jbtImage.setIcon(icons[0]);
		jlbImage = new JLabel(iconsTittles[0]);
		

		jpAudio.setLayout(new GridLayout(1,3));
		jpAudio.add(jcbAudio);
		jpAudio.add(jbtAudio);
		jpAudio.add(jlbAudio);

		jpImage.setLayout(new GridLayout(1,3));
		jpImage.add(jcbImage);
		jpImage.add(jbtImage);
		jpImage.add(jlbImage);
		this.setLayout(new GridLayout(3,1));
		this.add(jpTittle);
		this.add(jpAudio);
		this.add(jpImage);
		this.setVisible(false);
		this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);

	}
	
	protected void nextBackground() {
		if(++backgroundN >= icons.length)
			backgroundN = 0;
		jlbImage.setText(iconsTittles[backgroundN]);
		jbtImage.setIcon(icons[backgroundN]);
		checkBackground();
		
	}

	protected void checkBackground() {
		backgroundOn = jcbImage.isSelected();
		if(backgroundOn){
			navigation.displayScreen.background = icons[backgroundN];
			navigation.displayScreen.backgroundOn = backgroundOn;
		}
		else{
			navigation.displayScreen.backgroundOn = backgroundOn;
		}

		
	}

	protected void nextMusic() {
		audioClips[musicN].stop();
		if(++musicN >= audioClips.length)
			musicN = 0;
		jlbAudio.setText(audioTittles[musicN]);
		checkMusic();
	}

	private void checkMusic() {
		musicOn = jcbAudio.isSelected();
		if(musicOn){
			audioClips[musicN].loop();
		}
		else{
			audioClips[musicN].stop();
		}

	}
	
	private void load() {
		loadBackgrounds();
		loadAudioClips();

	}


	private void loadBackgrounds() {
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
		String[]temp = new String[files];
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				backgrounds[++b] = new ImageIcon(getClass().getResource("background/" + listOfFiles[i].getName()));
				temp[b] = listOfFiles[i].getName();
			}
		}
		icons = backgrounds;
		iconsTittles = temp;
	}

	private void loadAudioClips() {
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
		String[]temp = new String[files];
		int b=-1;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//System.out.println(getClass().getResource("music/" + listOfFiles[i].getName()));
				System.out.println(listOfFiles[i].getAbsolutePath());
				System.out.println(this.getClass().getResource("music/allianc1.mid"));
				//clips[i] = Applet.newAudioClip(getClass().getResource("music/" + listOfFiles[i].getName()));
				clips[++b] = Applet.newAudioClip(getClass().getResource("music/" + listOfFiles[i].getName()));
				temp[b] = listOfFiles[i].getName();
			}
		}
		this.audioClips = clips;
		audioTittles = temp;
	}

}
