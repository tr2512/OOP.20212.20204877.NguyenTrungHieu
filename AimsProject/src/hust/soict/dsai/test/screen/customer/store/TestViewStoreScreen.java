package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController; 
import hust.soict.dsai.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class TestViewStoreScreen extends Application{	
	private static Store store;
	
	public void start(Stage primaryStage) throws Exception {
		final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ITEM_FXML_FILE_PATH"));
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
			
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
		
		public static void main(String[] args) {
			store = new Store();
			launch(args);
	}	
}