package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) throws NullPointerException {
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				throw new NullPointerException("This track is already in the disc");
			}
		}
		tracks.add(track);
	}
	
	public void removeTrack(Track track) throws NullPointerException {
		for (int i = 0; i < tracks.size(); i ++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				tracks.remove(i);
				return;
			}
		}
		throw new NullPointerException("No track with the given name in the list");
	}
	
	public int getLength() {
		int sum = 0;
		for (int i = 0; i < tracks.size(); i ++) {
			sum = sum + tracks.get(i).getLength();
		}
		return sum;
	}
	
	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, 0, director);
		this.artist = artist;
	}
	
	public String play() throws PlayerException {
		if (this.getLength() < 0) {
			throw new PlayerException("This CD length is non-positive");
		}
		java.util.Iterator iter = tracks.iterator();
		Track nextTrack;
		while(iter.hasNext()) {
			nextTrack = (Track) iter.next();
			try {
				nextTrack.play();
			}catch(PlayerException e) {
				throw e;
			}
		}
		StringBuffer str = new StringBuffer("");
		str.append("<html>Playing the compact disc " + title + " by " + artist + " with" + tracks.size() + " tracks<br/>");
		System.out.println("Playing the compact disc " + title + " by " + artist + " with" + tracks.size() + " tracks");
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
			str.append(tracks.get(i).play() + "<br/>");
		}
		str.append("</html>");
		return str.toString();
	}
	
	public String toString() {
		String descrip = id + " - " + title + " - " + category + " - " + length + " - " + director + " - " + artist + " - " + cost;
		for (int i = 0; i < tracks.size(); i++) {
			descrip = descrip + "\nTrack list\n" + (i + 1) + " - " + tracks.get(i).toString();
		}
		return descrip;
	}
}
