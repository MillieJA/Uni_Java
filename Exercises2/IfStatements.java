import javax.swing.JOptionPane;

public class IfStatements {

	public static void main(String[] args) {
		String number1 = JOptionPane.showInputDialog("Enter first number");
		int num1 = Integer.parseInt(number1);
		String number2 = JOptionPane.showInputDialog("Enter second number");
		int num2 = Integer.parseInt(number2);
		JOptionPane.showMessageDialog(null, "The sum is " + (num1 + num2));
		
		if (num1 != num2) {
			JOptionPane.showMessageDialog(null, "Not equal");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Equal");
		}
		
		/* z = x > y ? 10 : 5;
		 
		? implies the end of an if block
		: implies 'else'
	 
		Means the same as:
		 
		if(x > y)
			z = 10;
		else
			z = 5; */
	
	}

}
