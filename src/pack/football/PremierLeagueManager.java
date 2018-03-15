package pack.football;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class PremierLeagueManager implements LeagueManager
{
	
	private final ArrayList<FootBallClub> league;
	private final Scanner scanner;
	private final ArrayList<Match> matches;
	
	private final int numberOFClubs;
	
	/*
	 * 
	 * initialze values in constructor
	 */
	public PremierLeagueManager(int numberOFClubs) 
	{
		this.numberOFClubs=numberOFClubs;
		league=new ArrayList<>();
		
		matches=new ArrayList<>();
		scanner=new Scanner(System.in);
		
		displayMenu();
		System.out.println("thank you for visit");
	}

	private void displayMenu()
	{
		
		while(true)
		{
			System.out.println("Premier Legaue Menu:");
			System.out.println("create a new team and add it to a league(press 1)");
			System.out.println("Delete Existing team from league(press 2)");
			System.out.println("Display sttaitics for a team(press 3)");
			System.out.println("Display the premier league table(press 4)");
			System.out.println("Add a player match(press 5)");
			System.out.println("Display calanedar and find mathc(press 6)");
			System.out.println("to exit from application (press 7)");
			
			String line=scanner.nextLine();
			int command =0;
			
			try
			{
				command=Integer.parseInt(line);
			}
			catch(Exception e){}
			
			switch(command)
			{
			case 1:
				addTeam();
				break;
			case 2:
				deleteTeam();
				break;
			case 3:
				displayStatistics();
				break;
			case 4:
				displayLeagueTable();
				break;
			case 5:
				addPlayedMatch();
				break;
			case 6:
				displayCalendar();
				break;
			case 7:
				System.exit(1);
				break;
				
			default: 
				System.out.println("wrong command:");
			
		   }
		
	   }
	
   }

	/*
 * 
 * add team method
 */
	private void addTeam()
	{
		// if league is already full then msg throw
		if(league.size() == numberOFClubs)
		{
			System.out.println("cant add more clubs to league");
			return ;
		}
		
		//if space then create a club
		FootBallClub club=new FootBallClub();
		System.out.println("Insert club name: ");
		String line=scanner.nextLine(); //enter the club name 
		club.setName(line); //set name of club
		
		//if entity is already in league
		if(league.contains(club))
		{
			System.out.println("this club already in league:");
			return;
		}
		System.out.println("insert club location :");
		line=scanner.nextLine();
		club.setLocation(line);
		league.add(club);
		
	}	
	
	/*
	 * check the club name name if it matche sthne remove it
	 */
    private void deleteTeam()
    {
    	System.out.println("Insert club name: ");
    	String line=scanner.nextLine();
    	  for(FootBallClub club: league)
    	  {
    		  if(club.getName().equals(line))
    		  {
    			  league.remove(club);
    			  System.out.println("delete the club :" +club.getName()+ "removed:!!");
    			  return;
    		  }
    	  }
    	  System.out.println("no such club in list league!!");
           		
	}
    
   /*
    * dispaly statitics of footbal game
    */
	private void displayStatistics() 
	{
		System.out.println("Insert club name: ");
    	String line=scanner.nextLine();
    	  for(FootBallClub club:league)
    	  {
    		  if(club.getName().equals(line))
    		  {
    			  System.out.println("Club"+ club.getName() +" matche won :" +club.getWinCount());
    			  System.out.println("Club"+ club.getName() +" matche lost :" +club.getDefeatCount());
    			  System.out.println("Club"+ club.getName() +" matche draw :" +club.getDrawCount());
    			  System.out.println("Club"+ club.getName() +" Scored goals :" +club.getScoredGoalsCount());
    			  System.out.println("Club"+ club.getName() +" Receivd goals :" +club.getReceivedGoalsCount());
    			  System.out.println("Club"+ club.getName() +" points : " +club.getPoint());
    			  System.out.println("Club"+ club.getName() +" match palyed  : " +club.getMatchPlayed());
    			  
    			  return;
    		  }
    	  }
    	
    	  System.out.println("no such club in list league!!");
	}
	
/*
 * dispaly the table league in fottbal in team
 */
	private void displayLeagueTable() 
	{
		Collections.sort(league,new CustomComparator());
		 for(FootBallClub club:league)
		 {
			 System.out.println("club: "+club.getName() +" Points :" +club.getPoint() +
					  " Goals difference :" + (club.getScoredGoalsCount() - club.getReceivedGoalsCount()) );
		 }
		
	}

	
/*
 * show how many matches played
 * 
 */

	private void addPlayedMatch()
	{
		System.out.println("Enter date : (mm-dd-yyyy)");
		String line=scanner.nextLine();
		Date date;
		
		try
		{
			date=new SimpleDateFormat("MM-DD-YYYY").parse(line);
		}catch(Exception e)
		{
			System.out.println("upu have to enter date in format:");
			return;
		}
		
		System.out.println("enter home team :");
		line=scanner.nextLine();
		FootBallClub home =null;
		
		   for(FootBallClub club:league)
		   {
			   if(club.getName().equals(line))
			   {
				   home = club;
			   }
		   }
		   
		   if(home == null)
		   {
			   System.out.println("no such club in a league");
			   return;
		   }
		   
		   System.out.println("Enter Away team :");
		   line=scanner.nextLine();
		   FootBallClub away =null;
			
		   for(FootBallClub club:league)
			   {
				   if(club.getName().equals(line))
				   {
					   away = club;
				   }
			   }
		   if(away == null)
		   {
			   System.out.println("no such club in a league");
			   return;
		   }
		   
		   System.out.println("enter home team goals:");
		   line=scanner.nextLine();
		   int homeGoals = -1;
		     try
		     {
		    	 homeGoals =Integer.parseInt(line);
		     }catch(Exception e)
		     {
		    	 
		     }
		     
		     if(homeGoals == -1)
		     {
		    	 System.out.println("you have to enter number of goals:");
		    	 return;
		     }
		     
		     System.out.println("enter away team goals:");
			   line=scanner.nextLine();
			   int awayGoals = -1;
			     try
			     {
			    	 awayGoals =Integer.parseInt(line);
			     }catch(Exception e)
			     {
			    	 
			     }
			     
			     if(awayGoals == -1)
			     {
			    	 System.out.println("you have to enter number of goals:");
			    	 return;
			     }
			     
			     
			     Match match=new Match();
			     match.setDate(new Date());
		         match.setTeamA(home);
		         match.setTeamB(away);
		         match.setTeamAScore(homeGoals);
		         match.setTeamBScore(awayGoals);
		         
		         
		         
		         matches.add(match);
		         
		         home.setScoredGoalsCount(home.getScoredGoalsCount()+homeGoals);
		         away.setScoredGoalsCount(away.getScoredGoalsCount()+awayGoals);
		         
		         home.setReceivedGoalsCount(home.getReceivedGoalsCount()+awayGoals);
		         away.setReceivedGoalsCount(away.getReceivedGoalsCount()+homeGoals);
		         
		         home.setMatchPlayed(home.getMatchPlayed()+1);
		         away.setMatchPlayed(away.getMatchPlayed()+1);
		         
		         
		         if(homeGoals > awayGoals)
		         {
		        	 home.setPoint(home.getPoint()+3);
		        	 home.setWinCount(home.getWinCount()+1);
		        	 away.setDefeatCount(away.getDefeatCount()+1);
		         }
		         else if(homeGoals < awayGoals)
		         {
		        	 away.setPoint(away.getPoint()+3);
		        	 away.setWinCount(away.getWinCount()+1);
		        	 home.setDefeatCount(home.getDefeatCount()+1);
		        	 
		         }
		         else
		         {
		        	 home.setPoint(home.getPoint()+1);     	 
		        	 away.setPoint(away.getPoint()+1);  
		        	 home.setDrawCount(home.getDrawCount()+1);
		        	 away.setDrawCount(away.getDrawCount()+1);
		         }
		         
		
	}

   /*
    * display calenedar for football team user can type a date and see when to play a match
    */

	private void displayCalendar()
	{
		System.out.println("Enter a year:");
		String line=scanner.nextLine();
		int y=-7777;
		
		 try
		 {
			 y= Integer.parseInt(line);
		 }catch(Exception e)
		 { }
		 
		 if(y == -77777)
		 {
			 System.out.println("you have to enter a year:");
			 return;
		 }
		 
		 
		     System.out.println("Enter a Month:");
			 line=scanner.nextLine();
			int m= 0;
			
			 try
			 {
				m= Integer.parseInt(line);
			 }catch(Exception e)
			 { }
			 
			 if(m == 0)
			 {
				 System.out.println("you have to enter a month:");
				 return;
			 }
			 
			 
			 String [] months={
					 
					 "",
					 "January", "February", "March",
		             "April", "May", "June",
		             "July", "August", "September",
		             "October", "November", "December"  
					 
			 };
			 
			 int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			 
			 if(m == 2 && isLeapYear(y)) days[m] = 29;
			 
			 System.out.println("  "+months[m] +" "+ y);
			 System.out.println("S M Tu W Th F S");
			 
			 
			 int d= day(m, 1, y);
			 String space = "";
			 
			 
			 for(int i=0;i <d;i++)
				 System.out.print("  ");
			 for(int i=1; i<= days[m];i++)
			 {
				 if(i<10)
				    System.out.print(i+"  ");
				 else
					 System.out.print(i+" ");
				 if (((i + d) % 7 == 0) || (i == days[m])) System.out.println();
			 }
			 
			 System.out.println("Enter a Day:");
			 line =scanner.nextLine();
			 int D=0;
			  try
			  {
				  D=Integer.parseInt(line);
			  }catch(Exception e){}
			 
			 if(D==0 || days[m] < D)
			 {
				 System.out.println("you have to enter a day in month");
			     return;
			 }
			 
			 Calendar cal=Calendar.getInstance();
			 cal.set(y,m-1,D);
			 for (Match m1 : matches) {
		           Calendar cal2 = Calendar.getInstance();
		           cal2.setTime(m1.getDate());
		            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
		                System.out.println(m1.getTeamA().getName()+ " "+m1.getTeamAScore() + " : "+ m1.getTeamBScore()+ " "+ m1.getTeamB().getName());
		            }
		       }   
			 
			 
			 
			 
	}

	public int day(int M, int D, int Y) 
	{
		int y = Y - (14 - M) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = M + 12 * ((14-M) / 12) - 2;
        int d = (D + x + (31*m)/12) % 7;
        return d;
	}

	private boolean isLeapYear(int year) 
	{
		if ((year % 4 ==0) && (year % 100 !=0 )) return true;
        if (year % 400 == 0) return true;
        return false;  
	}

}
