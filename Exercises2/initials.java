import java.util.Scanner;

public class initials {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String firstName = scan.nextLine();
		
		System.out.println("Enter your last name:");
		String lastName = scan.nextLine();
		
		System.out.println("Your name is: " + firstName + " " + lastName);
		System.out.println("Your initials are: " + firstName.charAt(0) + lastName.charAt(0));
	}

}
