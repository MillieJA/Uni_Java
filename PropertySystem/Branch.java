import java.io.Serializable;

public class Branch implements Serializable {
	
	private static final long serialVersionUID = -4448817344287582660L;
	
	protected String name;
	protected String address;
	protected String phone_number;
	protected String email_address;
	protected String web_address;
	protected String branch_sec_username;
	protected String branch_sec_password;
	
	// Constructor
	public Branch (String name, String address, String phone_number, String email_address, String web_address, String branch_sec_username, String branch_sec_password) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email_address = email_address;
		this.web_address = web_address;
		this.branch_sec_username = branch_sec_username;
		this.branch_sec_password = branch_sec_password;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoneNumber(String phone_number) {
		boolean numeric = true;
        try {
            Double num = Double.parseDouble(phone_number);
        }
        catch (NumberFormatException e) {
            numeric = false;
        }
        if(numeric) {
        	this.phone_number = phone_number;
        }
        else {
        	this.phone_number = "Null";
        }
	}
	public void setEmailAddress(String email_address) {
		this.email_address = email_address;
	}
	public void setWebAddress(String web_address) {
		this.web_address = web_address;
	}
	public void setBranchSecUsername(String branch_sec_username) {
		this.branch_sec_username = branch_sec_username;
	}
	public void setBranchSecPassword(String branch_sec_password) {
		this.branch_sec_password = branch_sec_password;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public String getEmailAddress() {
		return email_address;
	}
	public String getWebAddress() {
		return web_address;
	}
	public String getBranchSecUsername() {
		return branch_sec_username;
	}
	public String getBranchSecPassword() {
		return branch_sec_password;
	}
	
	// Methods
	public void showDetails() {
		System.out.println("\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phone_number
				+ "\nEmail Address: " + email_address + "\nWeb Address: " + web_address);
	}
	public void showAll() {
		System.out.println("\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phone_number
				+ "\nEmail Address: " + email_address + "\nWeb Address: " + web_address + "\nBranch Secretary Username: " + branch_sec_username 
				+ "\nBranch Secretary Password: " + branch_sec_password);
	}
}


