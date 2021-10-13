
public class Employees {

	public static void main(String[] args) {
		Employee Scott = new Employee("Scott", "100787", "12/APR/2004", 12.00);
		ProductionWorker Claire = new ProductionWorker("Claire", "030112", "05/SEP/2013", 13.50, 2);
		Scott.show_details();
		Claire.show_details();
	}

}
