package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Disc {
	
	private LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	
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
	
	public void setTitle(String title) {
		this.title = title;
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
