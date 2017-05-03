package exercise_17_09;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddressPane extends BorderPane {
    private GridPane paneForTextFields = new GridPane();
    private HBox paneForButtons = new HBox(5);
    private HBox paneForText = new HBox(5);
    protected TextField tfName = new TextField();
    protected TextField tfStreet = new TextField();
    protected TextField tfCity = new TextField();
    protected TextField tfState = new TextField();
    protected TextField tfZip = new TextField();
    protected Button btAdd = new Button("Add");
    protected Button btFirst = new Button("First");
    protected Button btNext = new Button("Next");
    protected Button btPrevious = new Button("Previous");
    protected Button btLast = new Button("Last");
    protected Button btUpdate = new Button("Update");

    public AddressPane() {
        tfName.setPrefColumnCount(23);
        tfStreet.setPrefColumnCount(23);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(4);
        
        Label lbState = new Label("State", tfState);
        Label lbZip = new Label("Zip", tfZip);
        lbState.setContentDisplay(ContentDisplay.RIGHT);
        lbZip.setContentDisplay(ContentDisplay.RIGHT);
        
        paneForTextFields.setVgap(5);
        paneForTextFields.setHgap(5);
        paneForText.getChildren().addAll(tfCity, lbState, lbZip);
        paneForTextFields.add(new Label("Name"), 0, 0);
        paneForTextFields.add(tfName, 1, 0);
        paneForTextFields.add(new Label("Street"), 0, 1);
        paneForTextFields.add(tfStreet, 1, 1);
        paneForTextFields.add(new Label("City"), 0, 2);
        paneForTextFields.add(paneForText, 1, 2);
        
        paneForButtons.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(5, 0, 0, 0));
        
        setPadding(new Insets(5, 5, 5, 5));
        setCenter(paneForTextFields);
        setBottom(paneForButtons);
    }
}
