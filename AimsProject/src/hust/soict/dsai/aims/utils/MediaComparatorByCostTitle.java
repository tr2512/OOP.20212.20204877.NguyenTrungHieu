package hust.soict.dsai.aims.utils;
import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public int compare(Media media1, Media media2) {
		if (Math.abs(media1.getCost() - media2.getCost()) < 1e-6) {
			return media1.getTitle().compareTo(media2.getTitle());
		} else {
			return (int)Math.floor((media2.getCost() - media1.getCost()));
		}
	}
}
