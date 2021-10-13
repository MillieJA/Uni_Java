import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SphereAreaa {

	public static void main(String[] args) {
		String enterRadius = JOptionPane.showInputDialog("Enter radius of sphere:");
		double radius = Double.parseDouble(enterRadius);
		DecimalFormat formatter = new DecimalFormat("0.0000");
		double findArea = ((radius*radius)*(Math.PI)*4);
		String area = formatter.format(findArea);
		JOptionPane.showMessageDialog(null, "The area of the sphere is: " + area);
		
	}

}
