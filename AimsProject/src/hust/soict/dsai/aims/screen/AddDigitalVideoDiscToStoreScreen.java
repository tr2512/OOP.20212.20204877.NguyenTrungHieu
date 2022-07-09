package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	
	private JButton button = new JButton("Add dvd to store");
	
	public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen screen) throws IllegalArgumentException {
		super(store, screen);
		addQuestion("Director");
		addQuestion("Length");
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
				int length = Integer.parseInt(inputs.get(4).getText());
				inputs.get(4).setText("");
				store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
			}
		});
	}
}
