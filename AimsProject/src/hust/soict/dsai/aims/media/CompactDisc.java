package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		boolean flag = true;
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				flag = false;
				System.out.println("The track has already in the list of tracks!");
				break;
			}
		}
		if (flag) {
			tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added.");
		}
	}
	
	public void removeTrack(Track track) {
		boolean flag = true;
		for (int i = 0; i < tracks.size(); i ++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				flag = false;
				tracks.remove(i);
				System.out.println("Remove " + track.getTitle() + " from the list of tracks.");
				break;
			}
		}
		if (flag) {
			System.out.println("Track " + track.getTitle() + " is not in the list of tracks!");
		}
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
	
	public String play() {
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
