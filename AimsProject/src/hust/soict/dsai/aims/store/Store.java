package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Store {
	public static final int MAX_NUMBERS_STORE = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORE];
	private int num_dvd = 0;
	public void addDVD (DigitalVideoDisc dvd) {
		if (num_dvd == MAX_NUMBERS_STORE) {
			System.out.println("The store is full!");
		} else {
			itemsInStore[num_dvd] = dvd;
			num_dvd += 1;
			System.out.println("The disk " + dvd.getTitle() + " has been added.");
		}		
	}
	public void removeDVD (DigitalVideoDisc dvd) {
		boolean flag = true;
		for (int i = 0; i < num_dvd; i++) {
			if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
				itemsInStore[i] = itemsInStore[num_dvd];
				itemsInStore[num_dvd] = null;
				num_dvd = num_dvd - 1;
				flag = false;
				System.out.println("The disc " + dvd.getTitle() + " has been removed from the store.");
				break;
			}
		}
		if (flag) {
			System.out.println("The disc " + dvd.getTitle() + " is not found in the store.");
		}
	}
	public boolean validTitle(String title) {
		boolean flag = false;
		for (int i = 0; i < num_dvd; i++) {
			if (itemsInStore[i].getTitle().equals(title)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	public DigitalVideoDisc searchDVD (String title) {
		for (int i = 0; i < num_dvd; i++) {
			if (itemsInStore[i].getTitle().equals(title)) {
				System.out.println(itemsInStore[i].toString());
				return itemsInStore[i];
			}
		}
		return itemsInStore[num_dvd - 1];
	}
}
