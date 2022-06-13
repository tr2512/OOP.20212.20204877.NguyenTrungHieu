package hust.soict.dsai.test.media;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book;
import java.util.ArrayList;

public class TestMediaCompareTo {
	public static void main (String[] args) {
		ArrayList<Media> collection = new ArrayList<Media>();
		Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
		Media dvd2 = new DigitalVideoDisc("Aladin", "Animation", 12.45f);
		Media book = new DigitalVideoDisc("Inferno", "Scifi", 14.24f);
		Media cd = new CompactDisc("Long Way Down", "Mix", 34.45f, 69, "Tom Ordell", "Tom Ordell");
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(book);
		collection.add(cd);
		
		java.util.Iterator iterator = collection.iterator();
		System.out.println("Current DVD order");
		while (iterator.hasNext() ) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
		java.util.Collections.sort((java.util.List)collection);
		iterator = collection.iterator();
		System.out.println("Current DVD in sorted order");
		while (iterator.hasNext() ) {
			System.out.println(((Media)iterator.next()).getTitle());
	}
}
}
