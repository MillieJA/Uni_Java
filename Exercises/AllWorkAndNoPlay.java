
public class AllWorkAndNoPlay {

	public static void main(String[] args) {
		repeat500(); repeat500(); // 1000 times
	}
	public static void repeat500() {
		repeat100(); repeat100(); repeat100(); repeat100(); repeat100();
	}
	public static void repeat100() {
		repeat25(); repeat25(); repeat25(); repeat25();
	}
	public static void repeat25() {
		repeat5(); repeat5(); repeat5(); repeat5(); repeat5();
	}
	public static void repeat5() {
		repeat1(); repeat1(); repeat1(); repeat1(); repeat1();
	}
	public static void repeat1() {
		System.out.println("All work and no play makes Jack a dull boy");
	}
}
