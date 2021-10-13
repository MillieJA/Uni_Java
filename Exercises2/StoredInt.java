import java.util.Scanner;

public class StoredInt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first integer:");
		int a = scan.nextInt();
		System.out.println("Enter second integer:");
		int b = scan.nextInt();
		System.out.println("Before swap: ");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("After swap: ");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
	}

}
