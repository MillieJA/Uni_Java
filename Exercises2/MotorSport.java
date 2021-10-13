
public class MotorSport implements Sport, TeamSport {
	
	private String SportName;
	private String Equipment;
	private String Location;
	private int NumberOfTeams;
	private int PlayersPerTeam;
	private int Laps;
	
	public MotorSport (String SportName, String Equipment, String Location, int NumberOfTeams, int PlayersPerTeam, int Laps) {
		this.SportName = SportName;
		this.Equipment = Equipment;
		this.Location = Location;
		this.NumberOfTeams = NumberOfTeams;
		this.PlayersPerTeam = PlayersPerTeam;
		this.Laps = Laps;
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
	
	public int getNumberOfLaps() {
		return Laps;
	}
}
