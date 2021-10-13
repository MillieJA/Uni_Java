import java.util.Scanner;

public class testScores {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first test score:");
		Float firstScore = scan.nextFloat();
		System.out.println("Enter the second test score:");
		Float secondScore = scan.nextFloat();
		System.out.println("Enter the third test score:");
		Float thirdScore = scan.nextFloat();
		System.out.println("Test average: " + ((firstScore + secondScore + thirdScore)/3));
	}

}
