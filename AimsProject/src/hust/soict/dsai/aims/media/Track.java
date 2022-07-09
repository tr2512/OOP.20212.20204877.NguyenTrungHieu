package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String play() throws PlayerException{
		if (this.getLength() < 0) {
			throw new PlayerException("This track length is non-positive");
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		return "<html>Playing DVD: " + this.getTitle() + "<br/>" + "DVD length: " + this.getLength() + "</html";
	}	
	
	public String toString() {
		return title + " - " + length;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Track) {
			if (this.title.equals(((Track)o).getTitle()) && this.length == ((Track)o).getLength()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
