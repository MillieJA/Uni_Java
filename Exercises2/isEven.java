import java.util.Scanner;

public class isEven {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = myScanner.nextInt();
		Boolean answer = even(number);
		if (answer == true) {
			System.out.println("The number is even");	
		}
		else {
			System.out.println("The number is odd");	
		}
		
	}
	
	public static Boolean even(int number) {
		if (number % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
