import java.io.Serializable;

public class Property implements Serializable {

	private static final long serialVersionUID = -1044116300735266978L;
	
	protected String branch_name;
	protected String property_title;
	protected String address;
	protected int number_of_rooms;
	protected String selling_price;
	protected String sold_price;
	protected String sold_date;
	
	// Constructor
	public Property (String branch_name, String property_title, String address, int number_of_rooms, String selling_price, String sold_price, String sold_date) {
		this.branch_name = branch_name;
		this.property_title = property_title;
		this.address = address;
		this.number_of_rooms = number_of_rooms;
		this.selling_price = selling_price;
		this.sold_price = sold_price;
		this.sold_date = sold_date;
	}
	
	// Setters
	public void setBranchName(String branch_name) {
		this.branch_name = branch_name;
	}
	public void setPropertyTitle(String property_title) {
		this.property_title = property_title;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNumberOfRooms(int number_of_rooms) {
		if (number_of_rooms > 0 ) {
			this.number_of_rooms = number_of_rooms;
		}
		else {
			System.out.println("Numbers of rooms must be more than 0");
		}
	}
	public void setSellingPrice (String selling_price) {
		this.selling_price = selling_price;
	}
	public void setSoldPrice (String sold_price) {
		this.sold_price = sold_price;
	}
	public void setSoldDate (String sold_date) {
		this.sold_date = sold_date;
	}
	
	// Getters
	public String getBranchName() {
		return branch_name;
	}
	public String getPropertyTitle() {
		return property_title;
	}
	public String getAddress() {
		return address;
	}
	public int getNumberOfRooms() {
		return number_of_rooms;
	}
	public String getSellingPrice () {
		return selling_price;
	}
	public String getSoldPrice () {
		return sold_price;
	}
	public String getSoldDate () {
		return sold_date;
	}
	
	// Methods
	public void showDetails() {
		System.out.println("Branch Name: " + branch_name + "\nProperty Title: " + property_title + "\nAddress: " + address
				+ "\nNumber Of Rooms: " + number_of_rooms + "\nSelling Price: £" + selling_price + "\nSold Price: £" + sold_price + "\nSold Date: " + sold_date);
	}
}
