
public class BallSport implements Sport, TeamSport {
	
	private String SportName;
	private String Equipment;
	private String Location;
	private int NumberOfTeams;
	private int PlayersPerTeam;
	private int TimeLimit;
	
	public BallSport (String SportName, String Equipment, String Location, int NumberOfTeams, int PlayersPerTeam, int TimeLimit) {
		this.SportName = SportName;
		this.Equipment = Equipment;
		this.Location = Location;
		this.NumberOfTeams = NumberOfTeams;
		this.PlayersPerTeam = PlayersPerTeam;
		this.TimeLimit = TimeLimit;
	}
	
	public String getEquipment() {
		return Equipment;
	}
	
	public String getName() {
		return SportName;
	}
	
	public String getLocation() {
		return Location;
	}
	
	public int getNumberOfTeams() {
		return NumberOfTeams;
	}
	
	public int getPlayersPerTeam() {
		return PlayersPerTeam;
	}
	
	public int getTimeLimit() {
		return TimeLimit;
	}

}
