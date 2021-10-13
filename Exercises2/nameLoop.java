import java.util.Scanner;

public class nameLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = scan.nextLine();
		int i = 1;
		while (i <= 5) {
			System.out.println("Hello " + name);
			i ++;
		}
	}

}
