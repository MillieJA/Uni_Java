import javax.swing.JOptionPane;

public class DialogBox {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		String numHours = JOptionPane.showInputDialog("How many hours did you work this week?");
		float hours = Float.parseFloat(numHours);
		String numWage = JOptionPane.showInputDialog("What is your hourly pay rate?");
		float wage = Float.parseFloat(numWage);
		JOptionPane.showMessageDialog(null, "Hello " + name + ". Your total wages this week is: " + (hours * wage) + " pounds.");

	}

}
