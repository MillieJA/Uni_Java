import java.util.Scanner;

import javax.swing.JOptionPane;

public class pizzaArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int match = 0;
		boolean choice = false;
		
		String[] pizza = new String[4];
		pizza[0] = "S";
		pizza[1] = "M";
		pizza[2] = "L";
		pizza[3] = "XL";
		
		double[] price = new double[4];
		price[0] = 6.99;
		price[1] = 8.99;
		price[2] = 12.50;
		price[3] = 15.00;
		
		String selection = JOptionPane.showInputDialog(null, "Enter size of pizza (S, M, L, XL:");
		for (int i = 0; i < 4; i++) {
			if (selection.equals(pizza[i])) {
				choice = true;
				match = 1;
				break; 
				}
		}
		
		if (choice == true) {
			JOptionPane.showMessageDialog(null, "The price is £" + price[match]);
			System.out.println("Please enter S, M , L or XL"); }
		
		else 
			JOptionPane.showMessageDialog(null, "Invalid Entry");
	}
}
