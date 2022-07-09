package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import javax.naming.LimitExceededException;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("The cart has maximum number of discs");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added to the cart");
		}
	}	
		
	public void removeMedia(Media media) throws NullPointerException{
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
				itemsOrdered.remove(i);
				return;
			}
		}
		throw new NullPointerException("No media is found in the cart.");
	}
	
	public int addMedia(ArrayList<Media> mediaList) {
		for (int i = 0; i < mediaList.size(); i++) {
			if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full, can only add the first " + (i) + " medias");
				return i;
			}
			itemsOrdered.add(mediaList.get(i));
		}
		return mediaList.size();
	}
	
	public void addMedia(Media media1, Media media2) throws LimitExceededException{
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered.add(media1);
			throw new LimitExceededException("Can only add the first media");
		} else if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("The cart is full");
		} else {
			itemsOrdered.add(media1);
			itemsOrdered.add(media2);
			System.out.println(media1.getTitle() + " and " + media2.getTitle() + " has been added to the cart");
		}
	}
	
	public void display (int m, int n) {
		for (int i=m; i < n; i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
	}
	
	public ObservableList<Media> searchMedia (int id) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		boolean flag = true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				list.add(itemsOrdered.get(i));
			}
		if (flag) {
			System.out.println("The Media with id " + id + " is not in the cart");
			}
		}
		return list;
	}
	
	public void sortByTitle() {
		itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
	}
	
	public void print () {
		sortByTitle();
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items");
		display(0, itemsOrdered.size());
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total = total + itemsOrdered.get(i).getCost();
		}
		return total;
	}
	
	public ObservableList<Media> searchByTitle (String title) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println("Find a match media");
				list.add(itemsOrdered.get(i));
			}
		}
		return list;
	}
	
	public Media getALuckyItem() {
		double a = Math.random();
		int b = (int)a*(itemsOrdered.size() - 1);
		System.out.println("The lucky item is " + itemsOrdered.get(b).getTitle());
		return itemsOrdered.get(b);
	}
	
	public int numberMedia () {
		return itemsOrdered.size();
	}
}