import java.util.Scanner;

public class nameInput {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String nameInput = myScanner.nextLine();
		System.out.println("Hello " + nameInput + "!");
		System.out.print("Your name backwards is: ");
		for (int i = (nameInput.length() - 1); i >= 0; i--) {
			System.out.print(nameInput.charAt(i));
		}
	}

}
