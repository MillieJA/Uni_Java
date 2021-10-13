import java.util.Scanner;

public class FloatNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the first number?");
		float firstNumber = scan.nextFloat();
		System.out.println("What is the second number?");
		float secondNumber = scan.nextFloat();
		System.out.println("Their sum is: " + (firstNumber+secondNumber));
		System.out.println("Their difference is: " + (firstNumber-secondNumber));
		System.out.println("Their product is: " + (firstNumber*secondNumber));
	}

}
