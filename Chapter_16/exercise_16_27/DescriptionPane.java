package exercise_16_27;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane {
    private Label lbImageTitle = new Label();
    private TextArea taDescription = new TextArea();
    
    public DescriptionPane() {
        lbImageTitle.setContentDisplay(ContentDisplay.TOP);
        lbImageTitle.setPrefSize(200, 100);
        
        lbImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));
        
        taDescription.setWrapText(true);
        taDescription.setEditable(false);
        
        ScrollPane scrollPane = new ScrollPane(taDescription);
        
        setLeft(lbImageTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5, 5, 5, 5));
    }
    
    public void setTitle(String text) {
        lbImageTitle.setText(text);
    }
    
    public void setDescription(String text) {
        taDescription.setText(text);
    }
    
    public void setImageView(ImageView picture) {
        lbImageTitle.setGraphic(picture);
    }
}
