import java.util.Scanner;

public class CircleDemo {

	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.setRadius(10.0);
		System.out.println("Area: " + circle.getArea());
		System.out.println("Diameter: " + circle.getDiameter());
		System.out.println("Circumference: " + circle.getCircumference());
	}

}
