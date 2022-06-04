package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class Media {
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private static int nbMedia = 0;
	private LocalDate dateAdded;
	
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
	
	public Media() {
		nbMedia = nbMedia + 1;
		this.id = Media.nbMedia;
		this.dateAdded = LocalDate.now();
	}

}
