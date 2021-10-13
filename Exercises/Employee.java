public class Employee {
	protected String employee_name;
	protected String employee_number;
	protected String hire_date;
	protected double hourly_rate;
	
	public Employee (String employee_name, String employee_number, String hire_date, double hourly_rate) {
		this.employee_name = employee_name;
		this.employee_number = employee_number;
		this.hire_date = hire_date;
		this.hourly_rate = hourly_rate;
	}
	
	public String getName() {
		return employee_name;
	}
	
	public void setName(String employee_name) {
		this.employee_name = employee_name;
	}
	
	public String getNumber() {
		return employee_number;
	}
	
	public void setNumber(String employee_number) {
		this.employee_number = employee_number;
	}
	
	public String getHireDate() {
		return hire_date;
	}
	
	public void setHireDate(String hire_date) {
		this.hire_date = hire_date;
	}
	
	public double getHourlyRate() {
		return hourly_rate;
	}
	
	public void setHourlyRate(double hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
	
	public void show_details() {
		System.out.println(employee_name + ", " + employee_number + ", " + hire_date + ", £" + hourly_rate);
	}
	
	public void getPay(int hours) {
		double pay = hourly_rate * hours;
		System.out.println("The employee, with hourly wage £" + hourly_rate + " has worked " + hours + " hours, and will earn £" + pay);
	}
}
