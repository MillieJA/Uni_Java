import java.util.Scanner;

public class rectangles {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the width: ");
		int width = myScanner.nextInt();
		System.out.println("Enter the height: ");
		int height = myScanner.nextInt();
		System.out.println("Enter a character: ");
		char character = myScanner.next().charAt(0);
		rectangle rectangle = new rectangle(width, height);
		rectangle.draw();
		rectangle.draw(character);
	}

}
