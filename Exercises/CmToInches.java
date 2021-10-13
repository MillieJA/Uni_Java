import java.util.Scanner;

public class CmToInches {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter centimeters as an integer:");
		double centimeters = scan.nextInt();
		System.out.println("The value in inches is: " + (centimeters * 0.3937));
	}

}
