import java.util.Scanner;

public class rockPaperScissors {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Choose: \n0 - Rock\n1 - Paper\n2 - Scissors");
		String choice = myScanner.nextLine();
		int userChoice = Integer.parseInt(choice);
		if (userChoice < 0 || userChoice > 2) {
			System.out.println("Please chose a valid option");
			return;
		}
		int computerChoice = (int) (Math.random()*2);
		System.out.println("************************");
		System.out.print("You chose: ");
		switch (userChoice) {
			case 0: System.out.print("Rock\n");
				break;
			case 1: System.out.print("Paper\n");
				break;
			case 2: System.out.print("Scissors\n");
				break;
			default: System.out.print("Invalid choice");
				break;
		}
		System.out.print("The computer chose: ");
		switch (computerChoice) {
		case 0: System.out.print("Rock\n");
			break;
		case 1: System.out.print("Paper\n");
			break;
		case 2: System.out.print("Scissors\n");
			break;
		default: System.out.print("Invalid choice");
			break;
		}
		int result = result(userChoice, computerChoice);
		switch (result) {
		case 0: System.out.print("It's a tie!");
			break;
		case 1: System.out.print("The computer wins!");
			break;
		case 2: System.out.print("You win!");
			break;
		default: System.out.print("Invalid choice");
			break;
		}
	}
	
	public static int result(int user, int computer) {
		int result = 0;
		if (user == computer) {
			result = 0;
		}
		if ((user == 0 && computer == 1) || (user == 1 && computer == 2) || (user == 2 && computer == 0)) {
			result = 1;
		}
		if ((user == 0 && computer == 2) || (user == 1 && computer == 0) || (user == 2 && computer == 1)) {
			result = 2;
		}
		return result;
	}

}
