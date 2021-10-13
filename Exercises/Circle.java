
public class Circle {
	
	private Double radius;
	private Double pi = 3.14159;
	private Double area;
	private Double diameter;
	private Double circumference;
	
	public void setRadius(Double r) {
		radius = r;
	}
	
	public Double getRadius() {
		return radius;
	}
	
	public Double getArea() {
		area = pi*(radius*radius);
		return area;
	}
	
	public Double getDiameter() {
		diameter = radius*2;
		return diameter;
	}
	
	public Double getCircumference() {
		circumference = pi*(radius*2);
		return circumference;
	}
}
