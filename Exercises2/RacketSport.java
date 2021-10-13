
public class RacketSport implements Sport {
	
	private String SportName;
	private String Equipment;
	private String Location;
	private int ScoreLimit;
	
	public RacketSport (String SportName, String Equipment, String Location, int ScoreLimit) {
		this.SportName = SportName;
		this.Equipment = Equipment;
		this.Location = Location;
		this.ScoreLimit = ScoreLimit;
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
	
	public int getScoreLimit() {
		return ScoreLimit;
	}
	
}
