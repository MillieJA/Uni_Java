import java.util.Scanner;

public class random {

	public static void main(String[] args) {
		int guesses = 0;
		boolean correct = false;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String chosenNumber = myScanner.nextLine();
		int number = Integer.parseInt(chosenNumber);
		System.out.println("I am thinking of a number between 1 and " + number);
		int randomNumber = (int) ((Math.random()*number) + 1);
		while (correct == false) {
			int guess = myScanner.nextInt();
			if (guess == randomNumber) {
				correct = true;
				System.out.println("You guessed it! It took you " + guesses + " tries.");
			}
			else if (guess > randomNumber) {
				System.out.println("Too high");
			}
			else if (guess < randomNumber) {
				System.out.println("Too low");
			}
			guesses++;
		}
	}

}
