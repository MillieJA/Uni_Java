import java.io.Serializable;

public class Flat extends Property implements Serializable {

	private static final long serialVersionUID = -945464974768444928L;
	
	protected int floor_number;
	protected String monthly_cost;
	
	// Constructor
	public Flat (String branch_name, String property_title, String address, int number_of_rooms, String selling_price, String sold_price,  String sold_date, int floor_number, String monthly_cost) {
		super(branch_name, property_title, address, number_of_rooms, selling_price, sold_price,  sold_date);
		this.floor_number = floor_number;
		this.monthly_cost = monthly_cost;
	}
	
	// Setters
	public void setFloorNumber(int floor_number) {
		if (floor_number >= 0 ) {
			this.floor_number = floor_number;
		}
		else {
			System.out.println("Floor number must be equal to or more than 0");
		}
	}
	public void setMonthlyCost(String monthly_cost) {
		this.monthly_cost = monthly_cost;
	}
	
	// Getters
	public int getFloorNumber() {
		return floor_number;
	}
	public String getMonthlyCost() {
		return monthly_cost;
	}
	
	// Methods
	public void showDetails() {
		System.out.println("Branch Name: " + branch_name + "\nProperty Title: " + property_title + "\nAddress: " + address
				+ "\nFloor Number: " + floor_number + "\nMonthly Cost: £" + monthly_cost + "\nNumber Of Rooms: " + number_of_rooms + "\nSelling Price: £" + selling_price 
				+ "\nSold Price: £" + sold_price + "\nSold Date: " + sold_date);
	}
}
