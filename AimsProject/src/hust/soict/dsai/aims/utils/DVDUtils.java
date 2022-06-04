package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (Math.abs(dvd1.getCost() - dvd2.getCost()) < 1e-6) {
			return "The cost of " + dvd1.getTitle() + " is equal to the cost of " + dvd2.getTitle();
		} else if (dvd1.getCost() > dvd2.getCost()) {
			return "The cost of " + dvd1.getTitle() + " is higher than the cost of " + dvd2.getTitle();
		} else {
			return "The cost of " + dvd1.getTitle() + " is lower than the cost of " + dvd2.getTitle();
		}
	}
	
	public static String compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getTitle().equals(dvd2.getTitle())) {
			return "Two DVDs have the same title";
		} else {
			return "Two DVDs have different titles.";
		}
	}
	
	public static DigitalVideoDisc[] sortByCost (DigitalVideoDisc[] dvdlist) {
		DigitalVideoDisc temp;
		int j;
		for (int i = 1; i < dvdlist.length; i++) {
			temp = dvdlist[i];
			j = i - 1;
			while (j >= 0 && dvdlist[j].getCost() > temp.getCost()) {
				dvdlist[j + 1] = dvdlist[j];
				j -= 1;
			}
			dvdlist[j + 1] = temp;
		}
		return dvdlist;
	}
	
	public static DigitalVideoDisc[] sortByTitle (DigitalVideoDisc[] dvdlist) {
		DigitalVideoDisc temp;
		int j;
		for (int i = 1; i < dvdlist.length; i++) {
			temp = dvdlist[i];
			j = i - 1;
			while (j >= 0 && dvdlist[j].getTitle().compareTo(temp.getTitle()) > 0) {
				dvdlist[j + 1] = dvdlist[j];
				j -= 1;
			}
			dvdlist[j + 1] = temp;
		}
		return dvdlist;
	}
}
