//Rachel Leksana
//3/3/10
//Score Class for Paint: The Game

public class Score
{
	int score;
	String date;
	String name;
	
	public Score()
	{
		 
	}//end Score
	
	public Score(int scoreNew, String dateNew, String nameNew)
	{
		score=scoreNew;
		date=dateNew;
		name=nameNew;
	}//end Score
	
	public String toString()
	{
		String full="";
		full+=name+"\t";
		full+=score;
		full+="\t"+date;
		return full;
	}//end toString
	
	public void setScore(int scoreNew)
	{
		score=scoreNew;
	}//end setScore
	
	public void setDate(String dateNew)
	{
		date=dateNew;
	}//end setDate
	
	public void setName(String nameNew)
	{
		name=nameNew;
	}//end setName
	
	public int getScore()
	{
		return score;
	}//end getScore
	
	public String getStringScore()
	{
		String temp="";
		temp+=score;
		return temp;
	}//end getStringScore
	
	public String getDate()
	{
		return date;
	}//end getDate
	
	public String getName()
	{
		return name;
	}//end getName
	
}//end Score