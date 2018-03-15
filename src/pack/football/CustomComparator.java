package pack.football;

import java.util.Comparator;

/**
 * 
 * @author sandhya
 *
 */

public class CustomComparator implements Comparator<FootBallClub>
{

	@Override
	public int compare(FootBallClub o1, FootBallClub o2)
	{
		if(o1.getPoint() > o2.getPoint())
		{
			return -1;
		}
		else if(o1.getPoint() < o2.getPoint())
		{
			return 1;
		}
		else
		{
			int goalDif1=o1.getScoredGoalsCount()-o1.getScoredGoalsCount();
			int goalDif2=o2.getScoredGoalsCount()-o2.getScoredGoalsCount();
			
			if(goalDif1 > goalDif2)
			{
				return -1;
			}
			else 
				if(goalDif1 > goalDif2)
					return 1;
				else 
					return 0;
		}
		 
	}
	
	

}
