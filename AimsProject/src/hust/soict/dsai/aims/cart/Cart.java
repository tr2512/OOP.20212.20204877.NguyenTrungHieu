package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full!");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered = qtyOrdered + 1;
			System.out.println("The disc " + disc.getTitle() +" has been added");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				itemsOrdered[i] = itemsOrdered[qtyOrdered - 1];
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered = qtyOrdered - 1;
				System.out.println("The disc " + disc.getTitle() + " has been removed");
				break;
			}
		}
	}
	public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			if (i + qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full, only add the first " + i + " discs");
				return i;
			}
			itemsOrdered[i + qtyOrdered] = dvdList[i];
		}
		System.out.println("The discs has been added to the cart.");
		return dvdList.length;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full, cannot add more disc!");
		} else if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered[qtyOrdered] = dvd1;
			System.out.println("The cart is full, can only add the first disc.");
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			System.out.println("The discs has been added.");
		}
	}
	public void display (int m, int n) {
		for (int i=m; i < n; i++) {
			System.out.println((i + 1) + " - " + itemsOrdered[i].toString());
		}
	}
	public void sortByCost () {
		DigitalVideoDisc temp;
		int j;
		for (int i = 1; i < qtyOrdered; i++) {
			temp = itemsOrdered[i];
			j = i - 1;
			while (j >= 0 && itemsOrdered[j].getCost() < temp.getCost()) {
				itemsOrdered[j + 1] = itemsOrdered[j];
				j -= 1;
			}
			itemsOrdered[j + 1] = temp;
		}
		System.out.println("The cart sorted by cost:");
		display(0, qtyOrdered);
	}
	public void sortByTitle() {
		DigitalVideoDisc temp;
		int j;
		for (int i = 1; i < qtyOrdered; i++) {
			temp = itemsOrdered[i];
			j = i - 1;
			while (j >= 0 && itemsOrdered[j].getTitle().compareTo(temp.getTitle()) > 0) {
				itemsOrdered[j + 1] = itemsOrdered[j];
				j -= 1;
			}
			itemsOrdered[j + 1] = temp;
		}
		System.out.println("The cart sorted by title:");
		display(0, qtyOrdered);
	}
	public void searchDVD (int id) {
		boolean flag = true;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Find the DVD with the the id: " + id);
				display(i, i + 1);
				flag = false;
				break;
			}
		if (flag) {
			System.out.println("The DVD with id " + id + " is not in the cart");
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
		DigitalVideoDisc temp;
		int j;
		for (int i = 1; i < qtyOrdered; i++) {
			temp = itemsOrdered[i];
			j = i - 1;
			while (j >= 0 && tupleCompare(itemsOrdered[j], temp) > 0) {
				itemsOrdered[j + 1] = itemsOrdered[j];
				j -= 1;
			}
			itemsOrdered[j + 1] = temp;
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items");
		display(0, qtyOrdered);
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}
	public void searchByTitle (String title) {
		boolean flag = true;
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Find a match disk");
				display(i, i + 1);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("There is no dvd match the given title");
		}
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
}