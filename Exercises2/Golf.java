
public class Golf implements Sport {

	private String SportName;
	private String Equipment;
	private String Location;
	
	public Golf (String SportName, String Equipment, String Location) {
		this.SportName = SportName;
		this.Equipment = Equipment;
		this.Location = Location;
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
	
}
