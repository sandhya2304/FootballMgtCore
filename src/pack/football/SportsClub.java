package pack.football;

public abstract class SportsClub
{
	
	public String name;
	public String location;
	public String statistics;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatistics() {
		return statistics;
	}
	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}
	
	public boolean equals(Object o)
	{
		
		return this.name.equals(((SportsClub)o).name);
	}
	
	
	
	

}
