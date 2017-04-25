package exercise_16_15;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_16_15 extends Application {
    private ComboBox cbContentDisplay = new ComboBox();
    private TextField tfGraphicTextGap = new TextField("10");
    private String url = "image/grapes.gif";
    
    @Override
    public void start(Stage primaryStage) {
        HBox paneForCheckBoxes = new HBox(5);
        tfGraphicTextGap.setPrefColumnCount(2);
        paneForCheckBoxes.getChildren().addAll(new Label("contentDisplay: "),cbContentDisplay, new Label("graphicTextGap: "), tfGraphicTextGap);
        ObservableList<String> items = FXCollections.observableArrayList(getContentDisplayElements());
        cbContentDisplay.setItems(items);
        cbContentDisplay.setValue("RIGHT");
        
        StackPane paneForGraphic = new StackPane();
        Label labelForGraphic = new Label("Grapes", new ImageView(new Image(url)));
        labelForGraphic.setContentDisplay(setContentDisplay());
        labelForGraphic.setGraphicTextGap(Double.parseDouble(tfGraphicTextGap.getText()));
        paneForGraphic.getChildren().add(labelForGraphic);
        
        BorderPane pane = new BorderPane();
        pane.setTop(paneForCheckBoxes);
        pane.setCenter(paneForGraphic);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        cbContentDisplay.setOnAction(e -> {
            labelForGraphic.setContentDisplay(setContentDisplay());
        });
        
        tfGraphicTextGap.setOnAction(e -> {
            labelForGraphic.setGraphicTextGap(Double.parseDouble(tfGraphicTextGap.getText()));
        });
        
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Label properties");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public ContentDisplay setContentDisplay() {
        String content = cbContentDisplay.getValue().toString();
        return ContentDisplay.valueOf(content);
    }
    
    public ArrayList<String> getContentDisplayElements() {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < ContentDisplay.values().length; i++) {
            names.add(ContentDisplay.values()[i].toString());
        }
        return names;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
