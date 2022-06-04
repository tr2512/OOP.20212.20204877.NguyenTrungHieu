package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String artist, String director, int length) {
		super();
		this.artist = artist;
		this.director = director;
		this.length = length;
	}

}
