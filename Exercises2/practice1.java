
public class practice1 {

	public static void main(String[] args) {
		methodTop();
		methodBottom();
		methodLine();
		methodTop();
		methodBottom();
		methodLine();
		methodBottom();
		methodTop();
		methodLine();
		methodBottom();
	}
	public static void methodTop() {
		System.out.println("  _______");
		System.out.println(" /       \\ ");
		System.out.println("/         \\ ");
	}
	public static void methodBottom() {
		System.out.println("\\         / ");
		System.out.println(" \\_______/ ");
	}
	public static void methodLine() {
		System.out.println("_\"_'_\"_'_\"_\"");
	}
}
