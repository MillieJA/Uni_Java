
public class ProductionWorker extends Employee {
	private int shift;
	
	public ProductionWorker (String employee_name, String employee_number, String hire_date, double hourly_rate, int shift) {
		super(employee_name, employee_number, hire_date, hourly_rate);
		this.shift = shift;
	}
	
	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		if (shift == 1 || shift == 2) {
			this.shift = shift;
		}
		else {
			System.out.println("Please enter shift 1 or shift 2");
		}
	}
	
	public void getPay(int hours) {
		if (shift == 1) {
			double pay = hourly_rate * hours;
			System.out.println("The employee, with hourly wage £" + hourly_rate + " has worked " + hours + " hours, and will earn £" + pay);
		}
		else if (shift == 2) {
			double pay = (hourly_rate * 2) * hours;
			System.out.println("The employee, with hourly wage £" + hourly_rate + " has worked " + hours + " hours, and will earn £" + pay);
		}
	}
	
	public void show_details() {
		System.out.println(employee_name + ", " + employee_number + ", " + hire_date + ", £" + hourly_rate + ", Shift " + shift);
	}
}
