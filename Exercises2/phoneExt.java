import java.util.Scanner;

public class phoneExt {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String[] namesArray = {"Reception", "Ron", "Jo", "Sally", "Jim", "Edward"};
		System.out.println("Enter a phone extension: ");
		String phoneExt = myScanner.nextLine();
		int number = Integer.parseInt(phoneExt);
		System.out.println(namesArray[number] + " is on extension " + phoneExt);
	}

}
