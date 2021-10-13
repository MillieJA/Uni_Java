import javax.swing.JOptionPane;

public class IfElse {

	public static void main(String[] args) {
		String enterNumber = JOptionPane.showInputDialog("Enter an integer greater than 20 and less than 45");
		int Number = Integer.parseInt(enterNumber);
		/* if (Number > 20) && (Number < 45) {
				JOptionPane.showMessageDialog(null, "Number within range");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid entry");
			}
		}*/
		
		System.out.println(((Number > 20) && (Number < 45)) ? "Number within range" : "Invalid entry");
	}

}
