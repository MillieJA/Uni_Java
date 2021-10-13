import javax.swing.JOptionPane;

public class Exercise_1 {

	public static void main(String[] args) {
		double length;
		double width;
		double area;
		
		length = getLength();
		width = getWidth();
		area = getArea(length, width);
		displayData(length, width, area);	
	}
	
	public static double getLength() {
		String input;
		input = JOptionPane.showInputDialog("Enter the length of the rectangle: ");
		return Double.parseDouble(input);
		}
	
	public static double getWidth() {
		String input;
		input = JOptionPane.showInputDialog("Enter the width of the rectangle: ");
		return Double.parseDouble(input);
	}

	public static double getArea(double length, double width) {
		Double area = length*width;
		return area;
	}
	
	public static void displayData(double length, double width, double area) {
		JOptionPane.showMessageDialog(null, "The length is " + length + ". The width is " + width + ". The area is " + area);
	}

}
