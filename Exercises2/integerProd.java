import java.util.Scanner;

public class integerProd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a whole number between 100 and 999:");
		int entered = scan.nextInt();
		int tens = (entered % 100);
		int ones = (tens % 10);
		System.out.println("The product of the digits is: "+((entered-tens)*(tens-ones)*ones));
	}

}
