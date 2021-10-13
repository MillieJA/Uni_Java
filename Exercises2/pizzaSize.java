import java.util.Scanner;

public class pizzaSize {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String[] priceArray = {"£6.99", "£8.99", "£12.50", "£15.00"};
		System.out.println("What size pizza do you want? (S/M/L/XL)");
		String pizzaSize = myScanner.nextLine();
		if (pizzaSize.equals("S")) {
			System.out.println("Your chosen pizza will cost: " + priceArray[0]);
		}
		else if (pizzaSize.equals("M")) {
			System.out.println("Your chosen pizza will cost: " + priceArray[1]);
		}
		else if (pizzaSize.equals("L")) {
			System.out.println("Your chosen pizza will cost: " + priceArray[2]);
		}
		else if (pizzaSize.equals("XL")) {
			System.out.println("Your chosen pizza will cost: " + priceArray[3]);
		}
		else {
			System.out.println("Please enter a valid size");
		}
	}

}
