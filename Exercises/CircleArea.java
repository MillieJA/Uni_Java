import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter radius of circle:");
		double radius = scan.nextDouble();
		System.out.println("The area of the circle is: " + (Math.PI*(radius*radius)));
	}

}
