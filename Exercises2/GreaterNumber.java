import java.util.Scanner;

public class GreaterNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int firstNumber = scan.nextInt();
		System.out.println("Enter second number: ");
		int secondNumber = scan.nextInt();
		if (firstNumber > secondNumber) {
			System.out.println("The first number is greater");
		}
		else if (firstNumber == secondNumber) {
			System.out.println("The numbers are the same");
		}
		else if (firstNumber < secondNumber) {
			System.out.println("The second number is greater");
		}
	}

}
