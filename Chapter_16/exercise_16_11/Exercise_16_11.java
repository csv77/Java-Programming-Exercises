package exercise_16_11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_11 extends Application {
    private TextField tfFilename = new TextField();
    private TextArea ta = new TextArea();
    Pane pane = new Pane();
    
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: white");
        vBox.setPadding(new Insets(5, 5, 5, 5));
        
        HBox paneForFilename = new HBox();
        Label label = new Label("Filename:", tfFilename);
        tfFilename.setAlignment(Pos.BOTTOM_LEFT);
        tfFilename.setPrefColumnCount(20);
        label.setContentDisplay(ContentDisplay.RIGHT);
        Button btView = new Button("View");
        paneForFilename.getChildren().addAll(label, btView);
        paneForFilename.setStyle("-fx-border-color: black");
        
        vBox.getChildren().addAll(pane, paneForFilename);
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Histogram");
        primaryStage.setScene(scene);
        
        btView.setOnAction(e -> {
            Histogram histogram = new Histogram(tfFilename.getText());
            pane.getChildren().add(histogram);
            primaryStage.sizeToScene();
        });
        
        primaryStage.show();
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
