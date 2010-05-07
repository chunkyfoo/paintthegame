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

public class Level {
	int levelNumber;
	ArrayList<Path>paths;
	Set<LevelObject> levelObjects;
	
	public Level(File file){
		loadLevel(file);
		int levelNumber = 0;//fake value
		paths = new ArrayList<Path>();//fake value
		levelObjects = new HashSet<LevelObject>();//fake value
		levelObjects.add(new FireBall(300, 300, 300, 50 , Color.RED,.25));
		//*
		levelObjects.add(new FireBall(300, 300, 250, 50 , Color.GREEN,.25));
		levelObjects.add(new FireBall(300, 300, 200, 50 , Color.BLUE,.25));
		levelObjects.add(new FireBall(300, 300, 150, 50 , Color.ORANGE,.25));
		levelObjects.add(new FireBall(300, 300, 100, 50 , Color.YELLOW,.25));
		levelObjects.add(new FireBall(300, 300, 50, 50 , Color.GRAY,.25));
		levelObjects.add(new FireBall(300, 300, 0, 50 , Color.BLACK,.25));
		//*/
		
		///*
		//levelObjects = new HashSet<LevelObject>();//fake value
		levelObjects.add(new FireBall(600, 300, 300, 50 , Color.RED,.25));
		levelObjects.add(new FireBall(600, 300, 250, 50 , Color.GREEN,.25));
		levelObjects.add(new FireBall(550, 300, 200, 50 , Color.BLUE,.25));
		levelObjects.add(new FireBall(500, 300, 150, 50 , Color.ORANGE,.25));
		levelObjects.add(new FireBall(450, 300, 100, 50 , Color.YELLOW,.25));
		levelObjects.add(new FireBall(400, 300, 50, 50 , Color.GRAY,.25));
		levelObjects.add(new FireBall(350, 300, 0, 50 , Color.BLACK,.25));
		 //*/
		
		levelObjects.add(new PaintMan(200, 200));

	}
	
	private boolean loadLevel(File levelFile){
		levelNumber = 0;//Not Completed
		levelObjects = new HashSet<LevelObject>();//Completed
		paths = new ArrayList<Path>();//Not Completed
		boolean success = true;//not completed
		
		return success;
	}
	
	private class Path{
		
	}
}
