package exercise_16_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_10 extends Application {
    private TextField tfFilename = new TextField();
    private TextArea ta = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setStyle("-fx-background-color: white");
        ta.setWrapText(true);
        ta.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(ta);
        
        HBox paneForFilename = new HBox();
        tfFilename.setAlignment(Pos.BOTTOM_LEFT);
        tfFilename.setPrefColumnCount(17);
        Button btView = new Button("View");
        paneForFilename.getChildren().addAll(new Label("Filename"), tfFilename, btView);
        
        pane.getChildren().addAll(scrollPane, paneForFilename);
        
        btView.setOnAction(e -> {
            try {
                getTextFile();
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        });
        
        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Text viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void getTextFile() throws FileNotFoundException {
        File file = new File(tfFilename.getText());
        String text = "";
        if(!file.exists()) {
            System.out.println("The file " + tfFilename.getText() + " is not exists!");
        }
        else {
            try(Scanner input = new Scanner(file)) {
                while(input.hasNext()) {
                    text += input.nextLine();
                    text += "\n";
                }
            }
        }
        ta.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
