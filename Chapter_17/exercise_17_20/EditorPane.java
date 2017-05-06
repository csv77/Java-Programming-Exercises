package exercise_17_20;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class EditorPane extends BorderPane {
    private TextField tfFilePath = new TextField();
    private TextArea taEditorWindow = new TextArea();
    private Button btChange = new Button("Save the change");

    public EditorPane() {
        tfFilePath.setPrefColumnCount(30);
        Label lbFile = new Label("Enter a file: ", tfFilePath);
        lbFile.setContentDisplay(ContentDisplay.RIGHT);
        
        taEditorWindow.setWrapText(true);
        ScrollPane scrollPane = new ScrollPane(taEditorWindow);
        
        setTop(lbFile);
        setCenter(scrollPane);
        setBottom(btChange);
        BorderPane.setAlignment(btChange, Pos.CENTER);
    }

    public TextField getTfFilePath() {
        return tfFilePath;
    }

    public TextArea getTaEditorWindow() {
        return taEditorWindow;
    }

    public Button getBtChange() {
        return btChange;
    }

}
