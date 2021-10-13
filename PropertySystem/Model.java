import java.io.*;
import java.util.ArrayList;

public class Model implements Serializable {

	private static final long serialVersionUID = -6941973614192456256L;
	
	// Admin log in details
	public static String ADMIN_USERNAME = "Admin1";
	public static String ADMIN_PASSWORD = "Admin1";
	
	public static String BRANCH_FILEPATH = "branches.dat";
	public static String PROPERTY_FILEPATH = "properties.dat";
	
	ArrayList<Branch> branchList = new ArrayList<Branch>();
	ArrayList<Property> properties = new ArrayList<Property>(), otherProperties = new ArrayList<Property>(), soldProperties = new ArrayList<Property>(), notSoldProperties = new ArrayList<Property>(), searchProperties = new ArrayList<Property>(), houses = new ArrayList<Property>(), 
	flats = new ArrayList<Property>();

	// Check admin log in details
	public boolean adminLogInCheck(String username, String password) {
		if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Read in all branches
	public ArrayList<Branch> getBranches() {
		try {
			branchList.clear();
        	FileInputStream fis = new FileInputStream(BRANCH_FILEPATH);
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	Branch obj = null;
            
        	while ((obj=(Branch)ois.readObject())!=null) {
        		branchList.add(obj);
        	}
        	ois.close();
        }
		catch (EOFException e) {
			System.out.println("End of file reached.");
        }
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
		return branchList;
	}
	
	// Read in all properties
	public ArrayList<Property> getProperties() {
		try {
			properties.clear();
			FileInputStream fis = new FileInputStream(PROPERTY_FILEPATH);
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	
        	Property obj = null;
        	while ((obj=(Property)ois.readObject())!=null) {
        		properties.add(obj);
        	}
        	ois.close();
        }
		catch (EOFException e) {
			System.out.println("End of file reached.");
        }
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
		return properties;
	}
	
	// Sort properties into not belonging to logged in branch, not sold, sold
	public void sortProperties (ArrayList<Property> properties, String branchName) {
		soldProperties.clear();
		notSoldProperties.clear();
		otherProperties.clear();
    	int size = properties.size();
    	for (int i = 0; i < size; i++) {
    		if (properties.get(i).getBranchName().equals(branchName)) {
    			if (!properties.get(i).getSoldPrice().equals("")) {
    				soldProperties.add(properties.get(i));
    			}
    			else {
    				notSoldProperties.add(properties.get(i));
    			}
    		}
    		else {
				otherProperties.add(properties.get(i));
			}
    	}
	}

	// Return all sold properties
	public ArrayList<Property> getSoldProperties() {
		return soldProperties;
	}
	
	// Return all not sold properties
	public ArrayList<Property> getNotSoldProperties() {
		return notSoldProperties;
	}
	
	// Return all properties that dont belong to the logged in branch
	public ArrayList<Property> getOtherProperties() {
		return otherProperties;
	}
	
	// Get properties that have been searched for
	public ArrayList<Property> getSearchedProperties(ArrayList<Property> notSoldProperties, String term) {
		searchProperties.clear();
		int size = notSoldProperties.size();
		for (int j = 0; j < size; j++) {
			Property property = notSoldProperties.get(j);
			if (property.getAddress().contains(term)) {
				searchProperties.add(property);
			}
		}
		return searchProperties;
	}
	
	// Save all branches to the binary file
	public void saveBranches(ArrayList<Branch> branchList2) {
		try {
			FileOutputStream fos = new FileOutputStream(BRANCH_FILEPATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			int size = branchList2.size();
			
			for (int i = 0; i < size; i++) {
				oos.writeObject(branchList2.get(i));
			}
			oos.close();
		}
		catch (EOFException e) {
			System.out.println("End of file reached.");
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	// Save all properties to the binary file
	public void saveProperties(ArrayList<Property> otherProperties, ArrayList<Property> notSoldProperties, ArrayList<Property> soldProperties) {
		try {
			FileOutputStream fos = new FileOutputStream(PROPERTY_FILEPATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			int size1 = otherProperties.size();
			int size2 = notSoldProperties.size();
			int size3 = soldProperties.size();
			for (int i = 0; i < size1; i++) {
				oos.writeObject(otherProperties.get(i));
			}
			for (int j = 0; j < size2; j++) {
				oos.writeObject(notSoldProperties.get(j));
			}
			for (int k = 0; k < size3; k++) {
				oos.writeObject(soldProperties.get(k));
			}
			oos.close();
		}
		catch (EOFException ex) {
			System.out.println("End of file reached.");
		} 
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (NullPointerException ex) {
			System.out.println("No properties saved.");
		}
	}
	
	// Get all houses
	public ArrayList<Property> getHouses(ArrayList<Property> notSoldProperties) {
		houses.clear();
		int size = notSoldProperties.size();
		for (int j = 0; j < size; j++) {
			Property property = notSoldProperties.get(j);
			if (property instanceof House) { // (Ayush, 2019)
				houses.add(property);
			} 
		}
		return houses;
	}
	
	// Get all flats
	public ArrayList<Property> getFlats(ArrayList<Property> notSoldProperties) {
		flats.clear();
		int size = notSoldProperties.size();
		for (int j = 0; j < size; j++) {
			Property property = notSoldProperties.get(j);
			if (property instanceof Flat) { // (Ayush, 2019)
				flats.add(property);
			} 
		}
		return flats;
	}
	
}