import java.util.Scanner;

public class inputArray {

	public static void main(String[] args) {
		double[] input = new double[5];
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 5 numbers");
		for (int i = 0; i < 5; i++) {
		input[i] = scan.nextDouble();
		
		System.out.println("The array contains: ");
		for (int j = 0; j < 5; j++)
		System.out.println(input[j]);
		}
	}
}
