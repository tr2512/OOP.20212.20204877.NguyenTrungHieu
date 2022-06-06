package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full!");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added to the cart");
		}
	}	
		
	public void removeMedia(String title) {
		boolean flag = true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				flag = false;
				itemsOrdered.remove(i);
				System.out.println("The disc " + title + " has been removed");
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
			System.out.println((i + 1) + " - " + itemsOrdered.get(i).toString());
		}
	}
	
	public void sortByCost () {
		Media temp;
		int j;
		for (int i = 1; i < itemsOrdered.size(); i++) {
			temp = itemsOrdered.get(i);
			j = i - 1;
			while (j >= 0 && itemsOrdered.get(j).getCost() < temp.getCost()) {
				itemsOrdered.set(j + 1, itemsOrdered.get(j));
				j -= 1;
			}
			itemsOrdered.set(j + 1, temp);
		}
		System.out.println("The cart sorted by cost:");
		display(0, itemsOrdered.size());
	}
	
	public void sortByTitle() {
		Media temp;
		int j;
		for (int i = 1; i < itemsOrdered.size(); i++) {
			temp = itemsOrdered.get(i);
			j = i - 1;
			while (j >= 0 && itemsOrdered.get(i).getTitle().compareTo(temp.getTitle()) > 0) {
				itemsOrdered.set(j + 1, itemsOrdered.get(j));
				j -= 1;
			}
			itemsOrdered.set(j + 1, temp);
		}
		System.out.println("The cart sorted by title:");
		display(0, itemsOrdered.size());
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
	
	private int tupleCompare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getTitle().compareTo(dvd2.getTitle()) > 0) {
			return 1;
		} else if (dvd1.getTitle().compareTo(dvd2.getTitle()) < 0) {
			return -1;
		} else {
			if (Math.abs(dvd1.getCost() - dvd2.getCost()) < 1e-6) {
				if (dvd1.getLength() > dvd2.getLength()) {
					return -1;
				} else {
					return 1;
				}
			} else if (dvd1.getCost() > dvd2.getCost()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public void print () {
		Media temp;
		int j;
		for (int i = 1; i < itemsOrdered.size(); i++) {
			temp = itemsOrdered.get(i);
			j = i - 1;
			while (j >= 0 && tupleCompare((DigitalVideoDisc)itemsOrdered.get(j), (DigitalVideoDisc)temp) > 0) {
				itemsOrdered.set(j + 1, itemsOrdered.get(j));
				j -= 1;
			}
			itemsOrdered.set(j + 1, temp);
		}
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
	
	public void searchByTitle (String title) {
		boolean flag = true;
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println("Find a match media");
				display(i, i + 1);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("There is no dvd match the given title");
		}
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