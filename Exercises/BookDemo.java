
public class BookDemo {

	public static void main(String[] args) {
	
		Book book = new Book();
		book.setAuthor("Book Author");
		book.setPublisher("Book Publisher");
		book.setCopiesSold(400);
		System.out.println("Book Title: " + book.getTitle());
		System.out.println("Book Author: " + book.getAuthor());
		System.out.println("Book Publisher " + book.getPublisher());
		System.out.println("Number of Copies Sold: " + book.getCopiesSold());
		
	}

}
