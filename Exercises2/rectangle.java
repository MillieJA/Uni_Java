
public class rectangle {
	private int width;
	private int height;
	
	public rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.print("-");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.print("-");
		System.out.print("\n");
		for (int j = 0; j < height; j++) {
			System.out.print("|");
			for (int k = 0; k < width; k++) {
				System.out.print("+");
			}
			System.out.print("|");
			System.out.print("\n");
		}
		System.out.print("-");
		for (int l = 0; l < width; l++) {
			System.out.print("-");
		}
		System.out.print("-");
		System.out.print("\n");
	}
	
	public void draw(char chr) {
		System.out.print("-");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.print("-");
		System.out.print("\n");
		for (int j = 0; j < height; j++) {
			System.out.print("|");
			for (int k = 0; k < width; k++) {
				System.out.print(chr);
			}
			System.out.print("|");
			System.out.print("\n");
		}
		System.out.print("-");
		for (int l = 0; l < width; l++) {
			System.out.print("-");
		}
		System.out.print("-");
		System.out.print("\n");
	}
	
}
