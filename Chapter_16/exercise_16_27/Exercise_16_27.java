package exercise_16_27;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise_16_27 extends Application {
    private String[] flagTitles = {"Canada", "China", "Denmark",
        "France", "Germany", "India", "Norway", "United Kingdom",
        "United States of America"};
    private ImageView[] flagImage = {new ImageView("image/ca.gif"),
                                     new ImageView("image/china.gif"),
                                     new ImageView("image/denmark.gif"),
                                     new ImageView("image/fr.gif"),
                                     new ImageView("image/germany.gif"),
                                     new ImageView("image/india.gif"),
                                     new ImageView("image/norway.gif"),
                                     new ImageView("image/uk.gif"),
                                     new ImageView("image/us.gif")};
    
    private String[] flagDescription = new String[9];
    private DescriptionPane descriptionPane = new DescriptionPane();
    private ComboBox<String> cbo = new ComboBox<>();
    
    @Override
    public void start(Stage primaryStage) {
        try {
            getDescriptions();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
        setDisplay(0);
        BorderPane pane = new BorderPane();
        
        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setValue("Canada");
        cbo.setPrefWidth(400);
        
        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);
        
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
        
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Exercise_16_27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void getDescriptions() throws FileNotFoundException {
        for(int i = 0; i < flagDescription.length; i++) {
            flagDescription[i] = new String();
            File file = new File("text/description" + i + ".txt");
            if(!file.exists()) {
                System.out.println("The file " + file.getName() + " doesn't exists.");
                System.exit(1);
            }
            try(Scanner input = new Scanner(file)) {
                while(input.hasNext()) {
                    flagDescription[i] += input.nextLine();
                    flagDescription[i] += "\n";
                }
            }
        }
    }
    
    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
