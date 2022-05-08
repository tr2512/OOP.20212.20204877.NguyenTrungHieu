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
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}
}