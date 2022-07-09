package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController; 
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class TestViewStoreScreen extends Application{	
	private static Store store;
	private static Cart cart;
	
	public void start(Stage primaryStage) throws Exception {
		final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ITEM_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
			
		primaryStage.setTitle("Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
		public static void main(String[] args) {
			store = new Store();
			cart = new Cart();
			store.addMedia(new DigitalVideoDisc("Star wars", "Scifi", "George Lucas", 120, 16.45f));
			store.addMedia(new Book("Inferno", "Fiction", 23.12f, "Something"));
			launch(args);
	}	
}