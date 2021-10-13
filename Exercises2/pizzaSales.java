import java.util.Scanner;

public class pizzaSales {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of pizzas:");
		int numberOfPizzas = scan.nextInt();
		System.out.println("Enter number of toppings:");
		int numberOfToppings = scan.nextInt();
		System.out.println("Reciept:");
		System.out.println("Number of pizzas: " + numberOfPizzas);
		System.out.println("Number of toppings: " + numberOfToppings);
		Float total = (float) ((numberOfPizzas * 12.00) + (numberOfToppings * 1.50));
		Float tax = (float) (total * 0.05);
		System.out.println("Total: £" + (total + tax));	
	}

}
