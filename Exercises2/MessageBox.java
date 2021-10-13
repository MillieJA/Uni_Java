import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MessageBox {

	public static void main(String[] args) {
		
		/* Word string with input box
		String name = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null, "Good Morning " + name); */
		
		// Number input convert to integer
		/*String number1 = JOptionPane.showInputDialog("Enter first number");
		int num1 = Integer.parseInt(number1);
		String number2 = JOptionPane.showInputDialog("Enter second number");
		int num2 = Integer.parseInt(number2);
		JOptionPane.showMessageDialog(null, "The sum is " + (num1 + num2));*/
		
		// Change the format of a decimal number
		double number3 = 3.27368900000;
		double number4 = 749037.12819400000;
		DecimalFormat formatter = new DecimalFormat("#,##0.00"); // ("#0%") To make the number a percentage
		System.out.println(formatter.format(number3));
		System.out.println(formatter.format(number4));
	}

}
