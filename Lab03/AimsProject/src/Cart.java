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
				itemsOrdered[i] = itemsOrdered[qtyOrdered];
				itemsOrdered[qtyOrdered] = null;
				qtyOrdered = qtyOrdered - 1;
				System.out.println("The disc " + disc.getTitle() + " has been removed");
				break;
			}
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