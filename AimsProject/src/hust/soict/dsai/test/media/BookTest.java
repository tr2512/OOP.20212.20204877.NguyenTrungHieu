package hust.soict.dsai.test.media;
import hust.soict.dsai.aims.media.Book;

public class BookTest {
	public static void main (String[] args) {
		Book book1 = new Book("Inferno", "Fiction", 19.95f, "Harvard professor of symbology Robert Langdon awakens in an Italian hospital, disoriented and with no recollection of the past thirty-six hours, including the origin of the macabre object hidden in his belongings.");
		System.out.println(book1.toString());
	}
}
