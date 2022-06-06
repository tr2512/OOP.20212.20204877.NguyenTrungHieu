package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) {
		boolean flag = true;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				flag = false;
				System.out.println("This author is already in the list.");
				break;
			}
		}
		if (flag) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean flag = true;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				flag = false;
				authors.remove(i);
				break;
			}
		}
		if (flag) {
			System.out.println("This author is not in the list.");
		}
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public String toString() {
		String descrip = title + " - " + category + " - " + cost;
		for (int i = 0; i < authors.size(); i++) {
			descrip = descrip + " - " + authors.get(i);
		}
		return descrip;
	}

}
