public class Book {

	private String title;
	private String author;
	private String publisher;
	private int copiesSold;
	
	public Book() {
		title = "Java";
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	public void setPublisher(String p) {
		publisher = p;
	}
	
	public void setCopiesSold(int cS) {
		copiesSold = cS;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getCopiesSold() {
		return copiesSold;
	}
	
}
