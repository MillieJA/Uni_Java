
public class cars {

	public static void main(String[] args) {
		car myCar = new car("Mazda", "MX5", "N107 AVV", 0);
		myCar.show_details();
		
		while (myCar.getSpeed() < 60) {
			myCar.accelerate();
		}
		while (myCar.getSpeed() > 0) {
			myCar.brake();
		}
	}

}
