
public class priceArray {

	public static void main(String[] args) {
		double sum = 0;
		double average = 0;
		
		double[] price = new double[10];
		price[0] = 2.34;
		price[1] = 7.89;
		price[2] = 1.34;
		price[3] = 9.27;
		price[4] = 4.61;
		price[5] = 6.93;
		price[6] = 3.38;
		price[7] = 5.77;
		price[8] = 8.13;
		price[9] = 2.81;
		
		for (int i = 0; i < 10; i++)
			sum = sum + price[i];
		System.out.println("The sum is: " + sum);
		
		for (int i = 0; i < 10; i++)
		if (price[i] < 5.00) {
			System.out.println(price[i]);
		}
		
		for (int i = 0; i < 10; i++)
			sum = sum + price[i];	
	}
}
