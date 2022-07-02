package hust.soict.dsai.aims.cart;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full!");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added to the cart");
		}
	}	
		
	public void removeMedia(Media media) {
		boolean flag = true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
				flag = false;
				itemsOrdered.remove(i);
				System.out.println("The disc " + media.getTitle() + " has been removed");
				break;
			}
		}
		if (flag) {
			System.out.println(title + " is not in the cart");
		}
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
	
	public void addMedia(Media media1, Media media2) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED - 1) {
			System.out.println("The cart is full, can only add " + media1.getTitle());
			itemsOrdered.add(media1);
		} else if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full, can't add more media");
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
	
	public void searchMedia (int id) {
		boolean flag = true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println("Find the Media with the the id: " + id);
				display(i, i + 1);
				flag = false;
				break;
			}
		if (flag) {
			System.out.println("The Media with id " + id + " is not in the cart");
			}
		}
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
	
	public Media searchByTitle (String title) {
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println("Find a match media");
				display(i, i + 1);
				return itemsOrdered.get(i);
			}
		}
		return itemsOrdered.get(0);
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