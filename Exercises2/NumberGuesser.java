import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a number between 1 and 1000");
		System.out.println("Divide your number by 7. What is the remainder?");
		int first = scan.nextInt();
		System.out.println("Divide your number by 11. What is the remainder?");
		int second = scan.nextInt();
		System.out.println("Divide your number by 13. What is the remainder?");
		int third = scan.nextInt();
		int firstProd = first*715;
		int secondProd = second*364;
		int thirdProd = third*924;
		int total = firstProd + secondProd + thirdProd;
		int chosenNumber = total/1001;
		System.out.println("Your number is: " + chosenNumber);
	}
}
