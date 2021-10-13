
public class car {
	private String make;
	private String model;
	private String registration;
	private int speed;
	
	public car (String make, String model, String registration, int speed) {
		this.make = make;
		this.model = model;
		this.registration = registration;
		this.speed = speed;
	}
	
	public void accelerate() {
		speed = speed + 5;
		System.out.println("The speed is " + speed + "mph");
	}
	
	public void brake() {
		speed = speed - 10;
		System.out.println("The speed is " + speed + "mph");
	}

	public int getSpeed() {
		return speed;
	}
	
	public void show_details() {
		System.out.println(make + " " + model + " reg: " + registration + " is going " + speed + "mph.");
	}
	
}
