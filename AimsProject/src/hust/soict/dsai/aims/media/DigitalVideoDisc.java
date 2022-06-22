package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title) {
		super(title, "", 0.0f, 0, "");
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost, 0, "");
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost, 0, director);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, length, director);
	}
	
	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		String result = "";
		result = result + id + " - ";
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
	
	public String play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		return "<html>Playing DVD: " + this.getTitle() + "<br/> " + "DVD length: " + this.getLength() + "</html";
	}
}
