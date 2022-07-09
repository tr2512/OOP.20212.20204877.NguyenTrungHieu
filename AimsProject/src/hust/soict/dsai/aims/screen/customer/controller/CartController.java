package hust.soict.dsai.aims.screen.customer.controller;

import javafx.event.ActionEvent;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import hust.soict.dsai.aims.media.Media;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Playable;

public class CartController {

	private Store store;
	private Cart cart;
	@FXML
	private TextField searchField;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML 
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	costLabel.setText("" + cart.totalCost());
    	searchField.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable,
    	            String oldValue, String newValue) {
    			if (newValue == null | newValue.equals("")) {
    				tblMedia.setItems(cart.getItemsOrdered());
    			} else {
    				if (((RadioButton)filterCategory.getSelectedToggle()).getText().equals("By ID")) {
    					tblMedia.setItems(cart.searchMedia(Integer.parseInt(newValue)));
    				} else {
    					tblMedia.setItems(cart.searchByTitle(newValue));
    				}
    			}
    		}
    	});
    }
    
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	} else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		} else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	Alert alert = new Alert(AlertType.NONE);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.setTitle("Play media");
		alert.setHeaderText(media.getTitle());
		try {
		alert.setContentText(((Playable)media).play());
		} catch (PlayerException e){
			alert.setContentText(e.getMessage());
			e.getStackTrace();
		}
		alert.showAndWait();

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText("" + cart.totalCost());
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
			final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(store, cart));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Cart");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML 
    void btnPlaceOrder(ActionEvent event) {
    	Alert alert = new Alert(AlertType.NONE);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.setTitle("Information");
		alert.setHeaderText("An order has been placed.");
		alert.setContentText("The total cost is " + cart.totalCost());

		alert.showAndWait();
		cart = new Cart();
		tblMedia.setItems(cart.getItemsOrdered());
		costLabel.setText("0");
    }
    
    
}
