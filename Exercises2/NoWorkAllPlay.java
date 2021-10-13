public class NoWorkAllPlay {
	public static void main(String[] args) {
		repeat6();
	}
	public static void repeat1() {
		System.out.println("All work and no play makes Jack a dull boy.");
	}
	public static void repeat2() {
		repeat1(); repeat1(); repeat1(); repeat1(); repeat1(); //5 times
	}
	public static void repeat3() {
		repeat2(); repeat2(); repeat2(); repeat2(); repeat2(); //25 times
	}
	public static void repeat4() {
		repeat3(); repeat3(); repeat3(); repeat3(); //100 times
	}
	public static void repeat5() {
		repeat4(); repeat4(); repeat4(); repeat4(); repeat4(); //500 times
	}
	public static void repeat6() {
		repeat5(); repeat5(); //1000 times
	}
}