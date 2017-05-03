package exercise_17_13;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CombinePane extends BorderPane {
    private TextField fileName = new TextField();
    private TextField numberOfFiles = new TextField();
    private Button btStart = new Button("Start");
    
    public CombinePane() {
        setPadding(new Insets(5));
        GridPane paneForTextFields = new GridPane();
        paneForTextFields.setHgap(5);
        paneForTextFields.setVgap(5);
        
        paneForTextFields.add(new Label("Enter a file: "), 0, 0);
        paneForTextFields.add(fileName, 1, 0);
        paneForTextFields.add(new Label("Specify the number of smaller files: "), 0, 1);
        paneForTextFields.add(numberOfFiles, 1, 1);
        
        Label infotext = new Label("If the base file is named temp.txt with three pieces, temp.txt.1, temp.txt.2, and"
                + "temp.txt.3 are combined into temp.txt.");
        infotext.setWrapText(true);
        setTop(infotext);
        setCenter(paneForTextFields);
        setBottom(btStart);
        BorderPane.setAlignment(btStart, Pos.CENTER);
    }

    public TextField getFileName() {
        return fileName;
    }

    public TextField getNumberOfFiles() {
        return numberOfFiles;
    }

    public Button getBtStart() {
        return btStart;
    }
    
    
}
