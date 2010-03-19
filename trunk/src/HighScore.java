//Rachel Leksana
//3/3/10
//HighScore Class for Paint: The Game

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HighScore
{
	public int level;
	
	public static void main(String[]args)
	{
		new HighScore(2, "3/6/10", "Caitlin Tjandra", 1);
	}//end main
	
	public HighScore()
	{
		
	}//end HighScore
	
	public HighScore(int scoreNew, String dateNew, String nameNew, int levelNew)
	{
		Score tryScore=new Score(scoreNew, dateNew, nameNew);
		level=levelNew;
		compareScore(tryScore);
	}//end HighScore
	
	//compares score to previous high scores
	public void compareScore(Score tryScore)
	{
		ArrayList<Score> scores=new ArrayList<Score>();
		if(level==1)
		{
			try
			{
				//reads in high scores from file
				File file = new File("lvl1scores.txt");
				Scanner inFile=new Scanner(file);
				while(inFile.hasNextLine())
				{
					String name=inFile.nextLine();
					String score=inFile.nextLine();
					String date=inFile.nextLine();
					scores.add(new Score(Integer.parseInt(score), date, name));
				}//end while
				inFile.close();
			}//end try
			catch(FileNotFoundException e)
			{
				System.out.println("No File Found");
			}//end catch
			
			int hold=10;
			//finds if score is greater than any past high scores
			for(int x=0; x<scores.size(); x++)
			{
				if(hold==10 && tryScore.getScore()>scores.get(x).getScore())
				{
					hold=x;
				}//end if
			}//end for
			
			//adds new high score and shifts the rest down
			if(hold!=10)
			{
				ArrayList<Score> holdScore=new ArrayList<Score>();
				for(int x=0; x<scores.size(); x++)
				{
					holdScore.add(scores.get(x));
				}//end for
				for(int x=hold+1; x<scores.size(); x++)
				{
					scores.set(x, holdScore.get(x-1));
				}//end for
				scores.set(hold, tryScore);
			}//end if
			
			//writes new high score list back to file
			try
			{
				PrintWriter outFile=new PrintWriter(new FileWriter(new File("lvl1scores.txt")));
				for(int x=0; x<scores.size(); x++)
				{
					System.out.println(scores.get(x).toString());
					outFile.println(scores.get(x).getName());
					outFile.println(scores.get(x).getStringScore());
					outFile.println(scores.get(x).getDate());
				}//end for
				outFile.close();
			}//end try
			catch(IOException e)
			{
				System.out.println("Error");
			}//end catch
			
		}//end if 
	}//end compareScore
}//end HighScore