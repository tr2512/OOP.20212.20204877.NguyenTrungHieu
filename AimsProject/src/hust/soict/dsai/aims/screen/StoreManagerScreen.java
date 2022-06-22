package hust.soict.dsai.aims.screen;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreManagerScreen extends JFrame {
	private Store store;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				new StoreManagerScreen(store);
				dispose();
			}
		});
		menu.add(viewStore);
		
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem addDVD = new JMenuItem("Add dvd");
		addDVD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDigitalVideoDiscToStoreScreen(store, StoreManagerScreen.this);
				dispose();
			}
		});
		JMenuItem addBook = new JMenuItem("Add book");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, StoreManagerScreen.this);
				dispose();
			}
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, StoreManagerScreen.this);
				dispose();
			}
		});
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;	
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}	
		
		return center;
	}
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		store.addMedia(new Book("aaaa", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("bbbb", "bbbb", 11.58f, "Something"));
		store.addMedia(new Book("cccc", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("aaaa", "aaaa", 12.45f, "Something"));
		store.addMedia(new DigitalVideoDisc("bbbb", "bbbb", "Something", 3, 12.12f));
		store.addMedia(new Book("cccc", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("aaaa", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("bbbb", "bbbb", 11.58f, "Something"));
		store.addMedia(new Book("cccc", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("aaaa", "aaaa", 12.45f, "Something"));
		store.addMedia(new Book("bbbb", "bbbb", 11.58f, "Something"));
		store.addMedia(new Book("cccc", "aaaa", 12.45f, "Something"));
		new StoreManagerScreen(store);
	}
}
