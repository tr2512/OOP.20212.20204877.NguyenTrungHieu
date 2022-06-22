package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

private JButton button = new JButton("Add book to store");
	
	public AddBookToStoreScreen(Store store, StoreManagerScreen screen) {
		super(store, screen);
		addQuestion("Content");
		add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = inputs.get(0).getText();
				inputs.get(0).setText("");
				String category = inputs.get(1).getText();
				inputs.get(1).setText("");
				float cost = Float.parseFloat(inputs.get(2).getText());
				inputs.get(2).setText("");
				String content = inputs.get(3).getText();
				inputs.get(3).setText("");
				store.addMedia(new Book(title, category, cost, content));
			}
		});
	}
}
