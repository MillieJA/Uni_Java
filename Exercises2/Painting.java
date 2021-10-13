
public class Painting extends Artwork {
	private String paint_type;
	private double height;
	private double width;
	
	public Painting (String artist_name, double cost, String paint_type, double width, double height) {
		super(artist_name, cost);
		this.paint_type = paint_type;
		this.height= height;
		this.width = width;
	}
	
	public String getPaintType() {
		return paint_type;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setPaintType(String paint_type) {
		this.paint_type = paint_type;
	}
	
	public void setHeight(double height) {
		if (height > 0) {
			this.height = height; }
		else {
			System.out.println("Please enter a valid height");
		}
	}
	
	public void setWidth(double width) {
		if (width > 0) {
			this.width = width; }
		else {
			System.out.println("Please enter a valid width");
		}
	}
	
	public void show_details() {
		System.out.println(artist_name + ", £" + cost + ", " + paint_type + ", " + height + "cm x " + width + "cm");
	}
}
