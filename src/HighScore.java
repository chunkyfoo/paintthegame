//Rachel Leksana
//3/3/10
//HighScore Class for Paint: The Game

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class HighScore
{
	public int level;

	public static void main(String[]args)
	{
		new HighScore(2, "3/2/10", "Caitlin Tjandra", 1);
	}

	public HighScore(int scoreNew, String dateNew, String nameNew, int levelNew)
	{
		Score tryScore=new Score(scoreNew, dateNew, nameNew);
		level=levelNew;
		compareScore(tryScore);
		showScores(1);
	}//end HighScore

	//compares score to previous high scores
	public void compareScore(Score tryScore)
	{
		ArrayList<Score> scores=new ArrayList<Score>();
		scores=readScores(level);
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
	}//end compareScore

	public ArrayList<Score> readScores(int level)
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
		}
		return scores;
	}//end readScores
	
	public void showScores(int level)
	{
		ArrayList<Score> scores=readScores(level);
		ScoreGUI shower= new ScoreGUI();
		shower.passIn(scores);
		shower.setVisible(true);
	}
	
	private class ScoreGUI extends JFrame
	{
		public ArrayList<Score> scores=new ArrayList<Score>();
		
		public ScoreGUI()
		{
			super("High Scores");
			setSize(400,480);
		}
		
		public void passIn(ArrayList<Score> scores1)
		{
			scores=scores1;
		}
		
		
		public void paint(Graphics g)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 16));
			g.drawString("NAME", 50, 40);
			g.drawString("SCORE", 200, 40);
			g.drawString("DATE", 300, 40);
			for(int x=1; x<scores.size()+1; x++)
			{
				String scorer="";
				scorer+=(scores.get(x-1)).getScore();
				g.drawString((scores.get(x-1)).getName(), 50, 40+40*x);
				g.drawString(scorer, 200, 40+40*x);
				g.drawString((scores.get(x-1)).getDate(), 300, 40+40*x);
			}
		}
		
	}
}//end HighScore
