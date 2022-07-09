package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
	
	public static final int MAX_NUMBERS_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia (Media media) throws NullPointerException {
		if (itemsInStore.size() == MAX_NUMBERS_STORE) {
			throw new NullPointerException("The store is full");
		} else {
			itemsInStore.add(media);
		}		
	}
	
	public void removeMedia (Media media) throws NullPointerException {
		
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				itemsInStore.remove(i);
				return;
			}
		}
		throw new NullPointerException("The media is not found in the cart");
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
		return null;
	}
	
	public void displayStore() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
