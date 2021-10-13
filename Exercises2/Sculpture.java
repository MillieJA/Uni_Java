
public class Sculpture extends Artwork {
	private String material;
	private double weight;
	
	public Sculpture (String artist_name, double cost, String material, double weight) {
		super(artist_name, cost);
		this.material = material;
		this.weight = weight;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void show_details() {
		System.out.println(artist_name + ", £" + cost + ", " + material + ", " + weight + "kg");
	}
}
