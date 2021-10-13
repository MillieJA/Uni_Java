import java.text.DecimalFormat;

public class Exercise_2 {
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Farenheit  to  Celcius");
		System.out.println("======================");
		for (int farenheit = 0; farenheit <= 20; farenheit++) {
			System.out.println(farenheit + "        -->   " + df.format(celcius(farenheit)));
			}
	}
	
	public static double celcius(double farenheit) {
		return ((farenheit - 32) * (5.0 / 9));
	}
	
}