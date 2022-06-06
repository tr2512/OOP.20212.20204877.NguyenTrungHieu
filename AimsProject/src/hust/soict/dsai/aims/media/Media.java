package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public abstract class Media {
	
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

}
