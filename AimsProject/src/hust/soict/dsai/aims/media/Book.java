package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public void processContent() {
		String[] contentSplit = content.split("[ ,?.!;]");
		for (int i = 0; i < contentSplit.length; i++) {
			if (wordFrequency.containsKey(contentSplit[i])) {
				wordFrequency.put(contentSplit[i], wordFrequency.get(contentSplit[i]) + 1);
			} else {
				contentTokens.add(contentSplit[i]);
				wordFrequency.put(contentSplit[i], 1);
			}
		}
		java.util.Collections.sort(contentTokens);
	}
	
	public void addAuthor(String authorName) {
		boolean flag = true;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				flag = false;
				System.out.println("This author is already in the list.");
				break;
			}
		}
		if (flag) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean flag = true;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				flag = false;
				authors.remove(i);
				break;
			}
		}
		if (flag) {
			System.out.println("This author is not in the list.");
		}
	}
	
	public Book(String title, String category, float cost, String content) {
		super(title, category, cost);
		this.content = content;
		processContent();
	}
	
	public String toString() {
		StringBuffer descrip = new StringBuffer(id + " - " + title + " - " + category + " - " + cost);
		for (int i = 0; i < authors.size(); i++) {
			descrip.append(" - " + authors.get(i));
		}
		descrip.append("\nlength: " + contentTokens.size() + "\n Word list: " + String.join(" ,", contentTokens) + "\n Occurences: " + wordFrequency);
		return descrip.toString();
	}

}
