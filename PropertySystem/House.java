import java.io.Serializable;

public class House extends Property implements Serializable {

	private static final long serialVersionUID = -4069382371272621713L;
	
	protected int number_of_floors;
	protected String garden;
	protected String garage;
	
	// Constructor
	public House (String branch_name, String property_title, String address, int number_of_rooms, String selling_price, String sold_price,  String sold_date, int number_of_floors, String garden, String garage) {
		super(branch_name, property_title, address, number_of_rooms, selling_price, sold_price,  sold_date);
		this.number_of_floors = number_of_floors;
		this.garden = garden;
		this.garage = garage;
	}
	
	// Setters
	public void setNumberOfFloors(int number_of_floors) {
		if (number_of_floors > 0 ) {
			this.number_of_floors = number_of_floors;
		}
		else {
			System.out.println("Numbers of floors must be more than 0");
		}
	}
	public void setGarden(String garden) {
		this.garden = garden;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	
	// Getters
	public int getNumberOfFloors() {
		return number_of_floors;
	}
	public String getGarden() {
		return garden;
	}
	public String getGarage() {
		return garage;
	}
	
	// Methods
	public void showDetails() {
		System.out.println("Branch Name: " + branch_name + "\nProperty Title: " + property_title + "\nAddress: " + address
				+ "\nNumber Of Rooms: " + number_of_rooms + "\nNumber Of Floors: " + number_of_floors + "\nGarden: " + garden + "\nGarage: " + garage + "\nSelling Price: £" 
				+ selling_price + "\nSold Price: £" + sold_price + "\nSold Date: " + sold_date);
	}
}
