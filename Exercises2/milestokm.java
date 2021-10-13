import java.util.Scanner;

public class milestokm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the distance in Miles:");
		double miles = scan.nextDouble();
		System.out.println("The distance in Kilometers is: " + (miles * 1.60935));
	}

}
