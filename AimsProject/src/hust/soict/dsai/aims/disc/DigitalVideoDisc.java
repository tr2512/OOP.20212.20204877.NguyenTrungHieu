package hust.soict.dsai.aims.disc;
import java.time.LocalDate;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String title) {
		super();
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
	public String toString() {
		String result = "";
		result = result + title;
		if (category != null) {
			result = result + " - " + category;
		}
		if (director != null) {
			result = result + " - " + director;
		} 
		if (length != 0) {
			result = result + " - " + length;
		}
		result = result + ": " + cost + " $";
		return result;
	}
}
