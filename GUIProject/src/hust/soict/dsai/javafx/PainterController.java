package hust.soict.dsai.javafx;

import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

public class PainterController {

    @FXML
    private VBox drawingAreaPane;

    @FXML
    private ToggleGroup group;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (((RadioButton)group.getSelectedToggle()).getText().equals("Pen")) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	} else if (((RadioButton)group.getSelectedToggle()).getText().equals("Eraser")) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	} else {
    		
    	}
    }
}

