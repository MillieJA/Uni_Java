import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Controller implements ActionListener {

	private View view;
	private Model model;
	
	boolean adminLoggedIn = false;
	
	String propertyType;
	Branch loggedInBranch, newBranch, oldBranch;
	Property newHouse, oldHouse, newFlat, oldFlat, soldProperty;
	ArrayList<Branch> branchList;
	ArrayList<Property> properties, otherProperties, soldProperties, notSoldProperties, houses, flats, searchResults;
	
	JButton[] viewButton, editButton, deleteButton, soldButton;
	
	// Get the model
	public Controller(Model model) {
		this.model = model;
	}
	
	// Get the view
	public void addView(View view) {
		this.view = view;
	}
	
	// All actions performed
	public void actionPerformed(ActionEvent event) {
		
		// Log out
		if (event.getSource() == view.logOutItem || event.getSource() == view.jBAdminLogOut || event.getSource() == view.jBBranchSecLogOut) {
			if (adminLoggedIn = true) {
				model.saveBranches(branchList);
			}
			else {
				model.saveProperties(otherProperties, notSoldProperties, soldProperties);
			}
			view.reset();
			view.logIn();
		}
		
		// Exit
		if (event.getSource() == view.exitItem) {
			model.saveBranches(branchList);
			model.saveProperties(otherProperties, notSoldProperties, soldProperties);
			System.exit(0);
		}
		
		// Help in menu bar
		if (event.getSource() == view.helpItem) {
			view.help();
		}
		
		// About in menu bar
		if (event.getSource() == view.aboutItem) {
			view.about();
		}
		
		// Log in
		if (event.getSource() == view.jBLogIn) {
			String username = view.getUsername();
			String password = view.getPassword();
			adminLoggedIn = model.adminLogInCheck(username, password);
			if (adminLoggedIn == true) {
				adminLoggedIn();
			}
			else {
				branchSecLoggedIn(username, password);
			}
		}
		
		// Add branch
		if (event.getSource() == view.jBAdminAdd) {
			view.reset();
			view.adminAddBranch();
		}
		
		// Go to admin home
		if (event.getSource() == view.jBAdminHome) {
			adminHome();
		}
		
		// Submit a new branch
		if (event.getSource() == view.jBBranchSubmit) {
			Branch branch = view.getBranch();
			branchList.add(branch);
			adminHome();
		}
		
		// Submit branch modifications
		if (event.getSource() == view.jBBranchEditSubmit) {
			newBranch = view.getBranch();
			oldBranch = getOldBranch();
			int index = branchList.indexOf(oldBranch);
			System.out.println(index);
			System.out.println(branchList.get(index).getName());
			branchList.set(index, newBranch);
			adminHome();
		}
		
		// Add a house
		if (event.getSource() == view.jBBranchSecAddHouse) {
			view.reset();
			view.branchSecAddHouse(loggedInBranch.getName());
		}
		
		// Add a flat
		if (event.getSource() == view.jBBranchSecAddFlat) {
			view.reset();
			view.branchSecAddFlat(loggedInBranch.getName());
		}
		
		// Search for a property
		if (event.getSource() == view.jBBranchSecSearch) {
			String searchTerm = view.getSearchTerm();
			searchResults = model.getSearchedProperties(notSoldProperties, searchTerm);
			if (searchResults.isEmpty()) {
				view.reset();
				view.branchSecHome(loggedInBranch.getName(), 800);
				view.noProperties();
			}
			else {
				int noOfSearchProperties = searchResults.size();
				viewButton = new JButton[noOfSearchProperties];
				editButton = new JButton[noOfSearchProperties];
				deleteButton = new JButton[noOfSearchProperties];
				soldButton = new JButton[noOfSearchProperties];
				int height = noOfSearchProperties * 100;
				view.reset();
				view.branchSecHome(loggedInBranch.getName(), height);
				for (int k = 0; k < noOfSearchProperties; k++) {
					if (searchResults.get(k) instanceof House) {
						propertyType = "House";
					}
					else {
						propertyType = "Flat";
					}
					view.displayProperty(propertyType, viewButton[k], editButton[k], deleteButton[k], soldButton[k], searchResults.get(k).getPropertyTitle(), searchResults.get(k).getAddress(), k);
				}
			}
		}
		
		// Go to branch sec home
		if (event.getSource() == view.jBBranchSecHome) {
			view.reset();
			branchSecHome();
		}
		
		// Submit a new house
		if (event.getSource() == view.jBHouseSubmit) {
			House house = view.getHouse(loggedInBranch.getName());
			notSoldProperties.add(house);
			branchSecHome();
		}
		
		// Submit a new flat
		if (event.getSource() == view.jBFlatSubmit) {
			Flat flat = view.getFlat(loggedInBranch.getName());
			notSoldProperties.add(flat);
			branchSecHome();
		}
		
		// View sold properties
		if (event.getSource() == view.jBBranchSecSold) {
			viewSold();
		}
		
		// View all properties
		if (event.getSource() == view.jBBranchSecViewAll) {
			view.reset();
			branchSecHome();
		}
		
		// Submit house modifications
		if (event.getSource() == view.jBHouseEditSubmit) {
			newHouse = view.getHouse(loggedInBranch.getName());
			oldHouse = getOldHouse();
			int index = notSoldProperties.indexOf(oldHouse);
			System.out.println(index);
			System.out.println(notSoldProperties.get(index).getPropertyTitle());
			notSoldProperties.set(index, newHouse);
			branchSecHome();
		}
		
		// Submit flat modifications
		if (event.getSource() == view.jBFlatEditSubmit) {
			newFlat = view.getFlat(loggedInBranch.getName());
			oldFlat = getOldFlat();
			int index = notSoldProperties.indexOf(oldFlat);
			System.out.println(index);
			System.out.println(notSoldProperties.get(index).getPropertyTitle());
			notSoldProperties.set(index, newFlat);
			branchSecHome();
		}
		
		// Submit sold details
		if (event.getSource() == view.jBSoldDetailsSubmit) {
			soldProperty = getSoldProperty();
			String soldPrice = view.getSoldPrice();
			String soldDate = view.getSoldDate();
			
			soldProperty.setSoldPrice(soldPrice);
			soldProperty.setSoldDate(soldDate);
			soldProperties.add(soldProperty);
			notSoldProperties.remove(soldProperty);
			
			branchSecHome();
		}
		
		// View all houses
		if (event.getSource() == view.jBBranchSecHouses) {
			viewHouses();
		}
		
		// View all flats
		if (event.getSource() == view.jBBranchSecFlats) {
			viewFlats();
		}
	}

	// Admin logged in
	private void adminLoggedIn() {
		System.out.println("Admin logged in");
		branchList = model.getBranches();
		adminHome();
	}
	
	// Admin home
	void adminHome() {
		int noOfBranches = branchList.size();
		int height = noOfBranches * 100;
		view.reset();
		view.adminHome(height);
		
		viewButton = new JButton[noOfBranches];
		editButton = new JButton[noOfBranches];
		deleteButton = new JButton[noOfBranches];
		
		if (branchList.isEmpty()) {
			view.noBranches();
		}
		else { // Display all branches
			System.out.println(noOfBranches);
			for (int i = 0; i < noOfBranches; i++) {
				view.displayBranch(viewButton[i], editButton[i], deleteButton[i], branchList.get(i).getName(), branchList.get(i).getAddress(), i);
			}
		}
	}
	
	// Branch sec logged in
	private void branchSecLoggedIn(String username, String password) {
		branchList = model.getBranches();
		int noOfBranches = branchList.size();
		for (int i = 0; i < noOfBranches; i++) { // Check log in details
			if (branchList.get(i).getBranchSecUsername().equals(username) && branchList.get(i).getBranchSecPassword().equals(password)) {
				loggedInBranch = branchList.get(i);
				System.out.println("Branch Secretary logged in");
				
				// Get all properties
				properties = model.getProperties();
				model.sortProperties(properties, loggedInBranch.getName());
				soldProperties = model.getSoldProperties();
				notSoldProperties = model.getNotSoldProperties();
				otherProperties = model.getOtherProperties();
	
				branchSecHome();
				break;
			}
			else {
				System.out.println("Log in incorrect");
				view.reset();
				view.logIn();
			}
		}
	}
	
	// Branch sec home
	private void branchSecHome() {
		System.out.println("Not sold properties: " + notSoldProperties.size());
		System.out.println("Sold properties: " + soldProperties.size());
		System.out.println("Other properties: " + otherProperties.size());
		if (notSoldProperties.isEmpty()) {
			view.reset();
			view.branchSecHome(loggedInBranch.getName(), 800);
			view.noProperties();
		}
		else {
			int noOfNotSoldProperties = notSoldProperties.size();
			viewButton = new JButton[noOfNotSoldProperties];
			editButton = new JButton[noOfNotSoldProperties];
			deleteButton = new JButton[noOfNotSoldProperties];
			soldButton = new JButton[noOfNotSoldProperties];
			int height = noOfNotSoldProperties * 100;
			view.reset();
			view.branchSecHome(loggedInBranch.getName(), height);
			for (int k = 0; k < noOfNotSoldProperties; k++) { // Display all properties and their type
				if (notSoldProperties.get(k) instanceof House) {
					propertyType = "House";
				}
				else {
					propertyType = "Flat";
				}
				view.displayProperty(propertyType, viewButton[k], editButton[k], deleteButton[k], soldButton[k], notSoldProperties.get(k).getPropertyTitle(), notSoldProperties.get(k).getAddress(), k);
			}
		}
	}
	
	// View all sold properties
	public void viewSold() {
		int noOfSoldProperties = soldProperties.size();
		viewButton = new JButton[noOfSoldProperties];
		editButton = new JButton[noOfSoldProperties];
		deleteButton = new JButton[noOfSoldProperties];
		int height = noOfSoldProperties * 100;
		view.reset();
		view.branchSecViewSold(loggedInBranch.getName(), height);
		if (soldProperties.isEmpty()) {
			view.noSoldProperties();
		}
		else {
			for (int k = 0; k < noOfSoldProperties; k++) { // Display each sold property
				if (soldProperties.get(k) instanceof House) {
					propertyType = "House";
				}
				else {
					propertyType = "Flat";
				}
				view.displaySoldProperty(propertyType, viewButton[k], deleteButton[k], soldProperties.get(k).getPropertyTitle(), soldProperties.get(k).getAddress(), k, soldProperties.get(k).getSoldPrice(), soldProperties.get(k).getSoldDate());
			}
		}
	}

	// View all houses
	public void viewHouses() {
		houses = model.getHouses(notSoldProperties);
		int noOfHouses = houses.size();
		propertyType = "House";
		viewButton = new JButton[noOfHouses];
		editButton = new JButton[noOfHouses];
		deleteButton = new JButton[noOfHouses];
		soldButton = new JButton[noOfHouses];
		int height = noOfHouses * 100;
		view.reset();
		view.branchSecViewHouses(loggedInBranch.getName(), height);
		if (houses.isEmpty()) {
			view.noHouses();
		}
		else {
			for (int i = 0; i < noOfHouses; i++) { // Display each house
				view.displayHouse(propertyType, viewButton[i], editButton[i], deleteButton[i], soldButton[i], houses.get(i).getPropertyTitle(), houses.get(i).getAddress(), i);
			}
		}
	}

	// View all flats
	public void viewFlats() {
		flats = model.getFlats(notSoldProperties);
		int noOfFlats = flats.size();
		propertyType = "Flat";
		viewButton = new JButton[noOfFlats];
		editButton = new JButton[noOfFlats];
		deleteButton = new JButton[noOfFlats];
		soldButton = new JButton[noOfFlats];
		int height = noOfFlats * 100;
		view.reset();
		view.branchSecViewFlats(loggedInBranch.getName(), height);
		if (flats.isEmpty()) {
			view.noFlats();
		}
		else {
			for (int i = 0; i < noOfFlats; i++) { // Display each flat
				view.displayFlat(propertyType, viewButton[i], editButton[i], deleteButton[i], soldButton[i], flats.get(i).getPropertyTitle(), flats.get(i).getAddress(), i);
			}
		}
	}

	// Remove a branch
	public void removeBranch(int i) {
		branchList.remove(i);
		view.reset();
		adminHome();
	}
	
	// Remove a property
	public void removeProperty(int i) {
		notSoldProperties.remove(i);
		view.reset();
		branchSecHome();
	}
	
	// Remove a house
	public void removeHouse(int i) {
		houses.remove(i);
		view.reset();
		branchSecHome();
	}
	
	// Remove a flat
	public void removeFlat(int i) {
		flats.remove(i);
		view.reset();
		branchSecHome();
	}
	
	// Remove a sold property
	public void removeSoldProperty(int i) {
		soldProperties.remove(i);
		view.reset();
		branchSecHome();
	}

	// View a branch
	public void viewBranch(int i) {
		Branch branch = branchList.get(i);
		view.reset();
		view.viewBranch(branch.getName(), branch.getAddress(), branch.getPhoneNumber(), branch.getEmailAddress(), branch.getWebAddress(), branch.getBranchSecUsername(), branch.getBranchSecPassword());
	}

	// View a property
	public void viewProperty(int arrayPos) {
		Property property = notSoldProperties.get(arrayPos);
		view.reset();
		if (property instanceof House) { // Find the property type
			  view.viewHouse(loggedInBranch.getName(), ((House) property).getPropertyTitle(), ((House) property).getAddress(), ((House) property).getNumberOfRooms(), ((House) property).getSellingPrice(), ((House) property).getNumberOfFloors(), ((House) property).getGarden(), ((House) property).getGarage());
		} 
		else {
			view.viewFlat(loggedInBranch.getName(), ((Flat) property).getPropertyTitle(), ((Flat) property).getAddress(), ((Flat) property).getNumberOfRooms(), ((Flat) property).getSellingPrice(), ((Flat) property).getFloorNumber(), ((Flat) property).getMonthlyCost());
		}
	}
	
	// View a house
	public void viewHouse(int arrayPos) {
		Property property = houses.get(arrayPos);
		view.reset();
		view.viewHouse(loggedInBranch.getName(), ((House) property).getPropertyTitle(), ((House) property).getAddress(), ((House) property).getNumberOfRooms(), ((House) property).getSellingPrice(), ((House) property).getNumberOfFloors(), ((House) property).getGarden(), ((House) property).getGarage());
	}
	
	// View a flat
	public void viewFlat(int arrayPos) {
		Property property = flats.get(arrayPos);
		view.reset();
		view.viewFlat(loggedInBranch.getName(), ((Flat) property).getPropertyTitle(), ((Flat) property).getAddress(), ((Flat) property).getNumberOfRooms(), ((Flat) property).getSellingPrice(), ((Flat) property).getFloorNumber(), ((Flat) property).getMonthlyCost());
	}
	
	// view a sold property
	public void viewSoldProperty(int arrayPos) {
		Property property = soldProperties.get(arrayPos);
		if (property instanceof House) { // Find the property type
			view.reset();
			view.viewSoldHouse(loggedInBranch.getName(), ((House) property).getPropertyTitle(), ((House) property).getAddress(), ((House) property).getNumberOfRooms(), ((House) property).getNumberOfFloors(), ((House) property).getGarden(), ((House) property).getGarage(), ((House) property).getSoldPrice(), ((House) property).getSoldDate());
		} 
		else {
			view.reset();
			view.viewSoldFlat(loggedInBranch.getName(), ((Flat) property).getPropertyTitle(), ((Flat) property).getAddress(), ((Flat) property).getNumberOfRooms(), ((Flat) property).getFloorNumber(), ((Flat) property).getSoldPrice(), ((Flat) property).getSoldDate());
		}
	}
	
	// Edit a branch
	public void editBranch(int i) {
		Branch branch = branchList.get(i);
		setOldBranch(branch);
		view.reset();
		view.editBranch(branch.getName(), branch.getAddress(), branch.getPhoneNumber(), branch.getEmailAddress(), branch.getWebAddress(), branch.getBranchSecUsername(), branch.getBranchSecPassword());
	}
	
	// Edit a property
	public void editProperty(int arrayPos) {
		Property property = notSoldProperties.get(arrayPos);
		if (property instanceof House) { // Get property type
			setOldHouse(property);
			view.reset();
			view.editHouse(((House) property).getBranchName(), ((House) property).getPropertyTitle(), ((House) property).getAddress(), ((House) property).getNumberOfRooms(), ((House) property).getSellingPrice(), ((House) property).getNumberOfFloors(), ((House) property).getGarden(), ((House) property).getGarage());
		} 
		else {
			setOldFlat(property);
			view.reset();
			view.editFlat(((Flat) property).getBranchName(), ((Flat) property).getPropertyTitle(), ((Flat) property).getAddress(), ((Flat) property).getNumberOfRooms(), ((Flat) property).getSellingPrice(), ((Flat) property).getFloorNumber(), ((Flat) property).getMonthlyCost());
		}
	}
	
	// Set the old branch for editing
	public void setOldBranch(Branch branch) {
		oldBranch = branch;
	}
	
	// Get the old branch for editing
	public Branch getOldBranch() {
		return oldBranch;
	}

	// Set the old house for editing
	public void setOldHouse(Property house) {
		oldHouse = house;
	}
	
	// Get the old house for editing
	public Property getOldHouse() {
		return oldHouse;
	}
	
	// Set the old flat for editing
	public void setOldFlat(Property flat) {
		oldFlat = flat;
	}
	
	// Get the old flat for editing
	public Property getOldFlat() {
		return oldFlat;
	}
	
	// Mark a property as sold
	public void markSold(int arrayPos) {
		Property property = notSoldProperties.get(arrayPos);
		setSoldProperty(property);
		view.reset();
		view.soldDetails(loggedInBranch.getName(), property.getPropertyTitle(), property.getAddress());
	}
	
	// Set the property for being sold
	public void setSoldProperty(Property property) {
		soldProperty = property;
	}
	
	// Get the property for being sold
	public Property getSoldProperty() {
		return soldProperty;
	}
	
}
