package hust.soict.dsai.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
public class ItemController {

	private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
    private Media media;
    
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + "$");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	try {
    		cart.addMedia(media);
    	} catch (LimitExceededException e) {
    		e.printStackTrace();
    	}
    }

    public ItemController(Cart cart) {
		this.cart = cart;
	}
    
	@FXML
    void btnPlayClicked(ActionEvent event) {
		Alert alert = new Alert(AlertType.NONE);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.setTitle("Play media");
		alert.setHeaderText(media.getTitle());
		try {
		alert.setContentText(((Playable)media).play());
		} catch (PlayerException e) {
			alert.setContentText(e.getMessage());
			e.printStackTrace();
		}
		alert.showAndWait();
    }
}