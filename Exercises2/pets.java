
public class pets {

	public static void main(String[] args) {
		pet Buster = new pet("Buster", "Dog", 6);
		pet Ron = new pet("Ron", "Hamster", 1);
		pet Maisy = new pet("Maisy", "Cat", 8);
		Buster.show_details();
		Ron.show_details();
		Maisy.show_details();
		System.out.println(Buster.getAge());
	}

}
