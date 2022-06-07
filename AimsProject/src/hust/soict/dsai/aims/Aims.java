package hust.soict.dsai.aims;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.thread.MemoryDaemon;

public class Aims {
	public static void main(String[] args) {
		MemoryDaemon memory = new MemoryDaemon();
		Scanner keyboard = new Scanner(System.in);
		Store store = new Store();
		Cart anOrder = new Cart();
		Thread t = new Thread(memory);
		t.setDaemon(true);
		t.start();
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
							System.out.println("There is no media with title "+ title);
						} else {
							Media media = store.searchMedia(title);
							System.out.println("Do you want to add this media to the cart? 1. Yes 2. No");
							int p = keyboard.nextInt();
							if (p == 1) {
								anOrder.addMedia(media);
							}
						}
					} else if (m == 2) {
						System.out.println("Enter DVD title");
						String title = keyboard.nextLine();
						if (!store.validTitle(title)) {
							System.out.println("There is no media with title "+ title);
						} else {
							Media media = store.searchMedia(title);
							anOrder.addMedia(media);
							System.out.println("Number of media in the cart: " + anOrder.numberMedia());
						}
					} else if (m == 3) {
						anOrder.display(0, anOrder.numberMedia());
					} else if (m == 0) {
						break;
					}
				}
			} else if (n == 2) {
				while (true) {
					System.out.println("1. Add a media to the store");
					System.out.println("2. Remove a media from the store");
					System.out.println("0. Back");
					int q = keyboard.nextInt();
					keyboard.nextLine();
					if (q == 1) {
						while (true) {
						System.out.println("1. Add a book");
						System.out.println("2. Add a dvd");
						System.out.println("3. Add a CD");
						System.out.println("0. Back");
						int z = keyboard.nextInt();
						keyboard.nextLine();
						if (z == 1) {
							System.out.println("The title of the book:");
							String title = keyboard.nextLine();
							System.out.println("The category of the book:");
							String category = keyboard.nextLine();
							System.out.println("The cost of the book:");
							float cost = keyboard.nextFloat();
							Media book = new Book(title, category, cost);
							store.addMedia(book);
							} else if (z == 2) {
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
								Media dvd = new DigitalVideoDisc(title, category, director, length, cost);
								store.addMedia(dvd);
							} else if (z == 3) {
								System.out.println("The title of the dvd:");
								String title = keyboard.nextLine();
								System.out.println("The category of the dvd:");
								String category = keyboard.nextLine();
								System.out.println("The director of the dvd:");
								String director = keyboard.nextLine();
								System.out.println("The length of the dvd:");
								int length = keyboard.nextInt();
								keyboard.nextLine();
								System.out.println("The cost of the dvd:");
								float cost = keyboard.nextFloat();
								System.out.println("The artist of the cd:");
								String artist = keyboard.nextLine();
								Media cd = new CompactDisc(title, category, cost, length, director, artist);
								store.addMedia(cd);
							} else if (z == 0) {
								break;
							}
						}
					} else if (q == 2) {
						System.out.println("Title of the removed media");
						String title = keyboard.nextLine();
						boolean valid = store.validTitle(title);
						if (valid) {
							Media dvd = store.searchMedia(title);
							store.removeMedia(dvd);
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
							anOrder.searchMedia(id);
						} else if (b == 2) {
							System.out.println("Enter dvd title");
							String title = keyboard.nextLine();
							keyboard.nextLine();
							anOrder.searchByTitle(title);
						}
					} else if (a == 2) {
						System.out.println("Options: ");
						System.out.println("--------------------------------");
						System.out.println("1. Sort media by title");
						System.out.println("2. Sort media by cost");
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
						anOrder.removeMedia(title);
					} else if (a == 4) {
						if (anOrder.numberMedia() >= 5) {
							Media lucky = anOrder.getALuckyItem();
							float bill = anOrder.totalCost() - lucky.getCost();
							System.out.println("The total cost of the order is " + bill);
						}
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
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
}