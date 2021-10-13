import java.util.Scanner;

public class phoneExt2 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String[] namesArray = {"Reception", "Ron", "Jo", "Sally", "Jim", "Edward"};
		System.out.println("Who's phone extension would you like to find?");
		String phoneExt = myScanner.nextLine();
		for (int i = 0; i < 6; i++) {
			if (phoneExt.equals(namesArray[i])) {
				System.out.println(phoneExt + " is on extension " + i);
			}
		}
		
	}
}
