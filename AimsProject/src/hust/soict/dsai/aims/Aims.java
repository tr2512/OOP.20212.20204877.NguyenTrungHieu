package hust.soict.dsai.aims;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
public class Aims {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Store store = new Store();
		Cart anOrder = new Cart();
		while (true) {
			showMenu();
			int n = keyboard.nextInt();
			keyboard.nextLine();
			if (n == 1) {
				while (true) {
					storeMenu();
					int m = keyboard.nextInt();
					keyboard.nextLine();
					if (m == 1) {
						System.out.println("Enter DVD title");
						String title = keyboard.nextLine();
						if (!store.validTitle(title)) {
							System.out.println("There is no dvd with title "+ title);
						} else {
							DigitalVideoDisc dvd = store.searchDVD(title);
							System.out.println("Do you want to add this dvd to the cart? 1. Yes 2. No");
							int p = keyboard.nextInt();
							if (p == 1) {
								anOrder.addDigitalVideoDisc(dvd);
							}
						}
					} else if (m == 2) {
						System.out.println("Enter DVD title");
						String title = keyboard.nextLine();
						if (!store.validTitle(title)) {
							System.out.println("There is no dvd with title "+ title);
						} else {
							DigitalVideoDisc dvd = store.searchDVD(title);
							anOrder.addDigitalVideoDisc(dvd);
							System.out.println("Number of dvd in the cart: " + anOrder.getQtyOrdered());
						}
					} else if (m == 3) {
						anOrder.display(0, anOrder.getQtyOrdered());
					} else if (m == 0) {
						break;
					}
				}
			} else if (n == 2) {
				while (true) {
					System.out.println("1. Add a dvd to the store");
					System.out.println("2. Remove a dvd from the store");
					System.out.println("0. Back");
					int q = keyboard.nextInt();
					keyboard.nextLine();
					if (q == 1) {
						System.out.println("The title of the dvd:");
						String title = keyboard.nextLine();
						System.out.println("The category of the dvd:");
						String category = keyboard.nextLine();
						System.out.println("The director of the dvd:");
						String director = keyboard.nextLine();
						System.out.println("The length of the dvd:");
						int length = keyboard.nextInt();
						System.out.println("The cost of the dvd:");
						float cost = keyboard.nextFloat();
						DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
						store.addDVD(dvd);
					} else if (q == 2) {
						System.out.println("Title of the removed dvd");
						String title = keyboard.nextLine();
						boolean valid = store.validTitle(title);
						if (valid) {
							DigitalVideoDisc dvd = store.searchDVD(title);
							store.removeDVD(dvd);
						} else {
							System.out.println("There is no disk with that title in the store!");
						}			
					} else if (q == 0) {
						break;
					}
				}
			} else if (n == 3) {
				while (true) {
					cartMenu();
					int a = keyboard.nextInt();
					keyboard.nextLine();
					if (a == 1) {
						System.out.println("Options: ");
						System.out.println("--------------------------------");
						System.out.println("1. Filter by id");
						System.out.println("2. Filter by name");
						int b = keyboard.nextInt();
						keyboard.nextLine();
						if (b == 1) {
							System.out.println("Enter dvd id");
							int id = keyboard.nextInt();
							keyboard.nextLine();
							anOrder.searchDVD(id);
						} else if (b == 2) {
							System.out.println("Enter dvd title");
							String title = keyboard.nextLine();
							keyboard.nextLine();
							anOrder.searchByTitle(title);
						}
					} else if (a == 2) {
						System.out.println("Options: ");
						System.out.println("--------------------------------");
						System.out.println("1. Sort dvd by title");
						System.out.println("2. Sort dvd by cost");
						int b = keyboard.nextInt();
						keyboard.nextLine();
						if (b == 1) {
							anOrder.sortByTitle();
						} else if (b == 2) {
							anOrder.sortByCost();
						}
					} else if (a == 3) {
						System.out.println("Enter the title of the DVD you want to remove");
						String title = keyboard.nextLine();
						anOrder.removeDigitalVideoDisc(new DigitalVideoDisc(title));
					} else if (a == 4) {
						System.out.println("An order is created.");
						anOrder = new Cart();
					} else if (a == 0) {
						break;
					}
				}
			} else if (n == 0) {
				System.out.println("Exiting the system.");
				break;
			}
		}
		System.out.println("The system is closed.");
	}
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
}