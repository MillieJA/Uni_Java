import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter temperature in Farenheit:");
		double farenheit = scan.nextDouble();
		System.out.println(farenheit + " degrees Farenheit is " + ((farenheit-32.0) * ( (double) 5/9)) + " degrees Celcuis");
	}
}