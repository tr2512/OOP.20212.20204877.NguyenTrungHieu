package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
	
	public static final int MAX_NUMBERS_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia (Media media) {
		if (itemsInStore.size() == MAX_NUMBERS_STORE) {
			System.out.println("The store is full!");
		} else {
			itemsInStore.add(media);
			System.out.println("The disk " + media.getTitle() + " has been added.");
		}		
	}
	
	public void removeMedia (Media media) {
		boolean flag = true;
		
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				itemsInStore.remove(i);
				flag = false;
				System.out.println("The disc " + media.getTitle() + " has been removed from the store.");
				break;
			}
		}
		if (flag) {
			System.out.println("The disc " + media.getTitle() + " is not found in the store.");
		}
	}
	
	public boolean validTitle(String title) {
		boolean flag = false;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public Media searchMedia (String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println(itemsInStore.get(i).toString());
				return itemsInStore.get(i);
			}
		}
		return itemsInStore.get(itemsInStore.size() - 1);
	}
}
