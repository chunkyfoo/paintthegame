import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Edward Kostreski
 * Start 03-03-2010
 * Last UPdated 03-17-2010
 */

public class LevelTester {
	int levelNumber;
	ArrayList<Path>paths;
	Set<LevelObject> levelObjects1;
	static Navigation n;
	
	public static void main(String[]args)
	{
		
		LevelTester t = new LevelTester();
	}

	public LevelTester(){
		n=new Navigation();
		int levelNumber = 0;//fake value
		paths = new ArrayList<Path>();//fake value
		Level lev=new Level(null);
		levelObjects1 = new HashSet<LevelObject>();//fake value
		
		levelObjects1.add(new StickMan(50, 200));
		levelObjects1.add(new SpikedWall(100, 20));
		levelObjects1.add(new Wall(200, 200));
		lev.levelObjects=levelObjects1;
		n.holdStart = true;
		n.main(null);
		System.out.println(null==lev);
		System.out.println(null==n.displayScreen);
		n.displayScreen = new DisplayScreen();
		n.displayScreen.level = lev;
		n.holdStart=false;
		n.start();
		
	}
	
	private boolean loadLevel(File levelFile){
		levelNumber = 0;//Not Completed
		levelObjects1 = new HashSet<LevelObject>();//Completed
		paths = new ArrayList<Path>();//Not Completed
		boolean success = true;//not completed
		
		return success;
	}
	
	private class Path{
		
	}
}
