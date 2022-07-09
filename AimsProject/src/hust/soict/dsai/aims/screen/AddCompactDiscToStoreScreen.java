package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
private JButton button = new JButton("Add book to store");
	
	public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen screen) throws IllegalArgumentException {
		super(store, screen);
		addQuestion("Director");
		addQuestion("Artist");
		add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = inputs.get(0).getText();
				inputs.get(0).setText("");
				String category = inputs.get(1).getText();
				inputs.get(1).setText("");
				float cost = Float.parseFloat(inputs.get(2).getText());
				if (cost < 0) {
					throw new IllegalArgumentException("Cost is negative");
				}
				inputs.get(2).setText("");
				String director = inputs.get(3).getText();
				inputs.get(3).setText("");
				String artist = inputs.get(4).getText();
				inputs.get(4).setText("");
				store.addMedia(new CompactDisc(title, category, cost, director, artist));
			}
		});
	}
}
