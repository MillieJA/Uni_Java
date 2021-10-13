
public class Artwork {
	protected String artist_name;
	protected double cost;
	
	public Artwork (String artist_name, double cost) {
		this.artist_name = artist_name;
		this.cost = cost;
	}
	
	public String getName() {
		return artist_name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setName(String artist_name) {
		this.artist_name = artist_name;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void show_details() {
		System.out.println(artist_name + ", £" + cost);
	}
}
