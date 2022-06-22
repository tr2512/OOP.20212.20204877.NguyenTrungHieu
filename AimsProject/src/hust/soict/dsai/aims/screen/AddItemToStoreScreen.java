package hust.soict.dsai.aims.screen;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.store.Store;


public abstract class AddItemToStoreScreen extends JFrame {
	protected JPanel panel;
	protected Store store;
	protected StoreManagerScreen screen;
	
	ArrayList<JTextField> inputs = new ArrayList<JTextField>();
	
	public AddItemToStoreScreen(Store store, StoreManagerScreen screen) {
		this.store = store;
		this.screen = screen;
		setLayout(new BorderLayout());
		add(createMenuBar(), BorderLayout.NORTH);
		add(createCenter(), BorderLayout.CENTER);
		setSize(1024, 768);
		setTitle("Add media");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected JPanel createCenter() {
		panel = new JPanel(new GridLayout(10, 1, 10, 10));
		addQuestion("Title");
		addQuestion("Category");
		addQuestion("Cost");
		return panel;
	}
	
	protected void addQuestion(String text) {
		panel.add(new JLabel("Enter the " + text));
		JTextField tf = new JTextField(100);
		inputs.add(tf);
		panel.add(tf);
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
				new AddDigitalVideoDiscToStoreScreen(store, screen);
				dispose();
			}
		});
		JMenuItem addBook = new JMenuItem("Add book");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, screen);
				dispose();
			}
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, screen);
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
}	
