public class Artworks {

	public static void main(String[] args) {
		Painting Mona_Lisa = new Painting("Da Vinci", 8300000.00, "Oil", 77, 53);
		Sculpture David = new Sculpture("Michelangelo", 2000000.00, "Marble", 5600);
		Mona_Lisa.show_details();
		David.show_details();
	}

}
