package pack.football;

import java.util.Date;

public class Match 
{
	//has a 
	private FootBallClub teamA;
	private FootBallClub teamB;

	private int teamAScore;
	private int teamBScore;
	
	private Date date;

	public FootBallClub getTeamA() {
		return teamA;
	}

	public void setTeamA(FootBallClub teamA) {
		this.teamA = teamA;
	}

	public FootBallClub getTeamB() {
		return teamB;
	}

	public void setTeamB(FootBallClub teamB) {
		this.teamB = teamB;
	}

	public int getTeamAScore() {
		return teamAScore;
	}

	public void setTeamAScore(int teamAScore) {
		this.teamAScore = teamAScore;
	}

	public int getTeamBScore() {
		return teamBScore;
	}

	public void setTeamBScore(int teamBScore) {
		this.teamBScore = teamBScore;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
