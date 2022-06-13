package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import hust.soict.dsai.aims.utils.*;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	protected LocalDate dateAdded;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public static int getNbMedia() {
		return nbMedia;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia = nbMedia + 1;
		this.id = Media.nbMedia;
		this.dateAdded = LocalDate.now();
	}

	public boolean equals(Object o) {
		if (o instanceof Media) {
			if (this.id == ((Media)o).getId()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;	
		}
	}
	
	public int compareTo(Media media) {
		if (title.compareTo(media.getTitle()) != 0) {
			return title.compareTo(media.getTitle());
		} else {
			return category.compareTo(media.getCategory());
		}
	}
}
