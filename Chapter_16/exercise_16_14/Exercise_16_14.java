package exercise_16_14;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_14 extends Application {
    private Text text = new Text("Programming is fun");
    private ComboBox fontName = new ComboBox();
    private ComboBox fontSize = new ComboBox();
    private CheckBox chbBold = new CheckBox("Bold");
    private CheckBox chbItalic = new CheckBox("Italic");
    
    @Override
    public void start(Stage primaryStage) {
        HBox paneForComboBoxes = new HBox(5);
        paneForComboBoxes.setAlignment(Pos.CENTER);
        
        HBox paneForCheckBoxes = new HBox(5);
        paneForCheckBoxes.setAlignment(Pos.CENTER);
        
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(400, 100);
        stackPane.getChildren().add(text);
        
        BorderPane pane = new BorderPane();
        pane.setTop(paneForComboBoxes);
        pane.setCenter(stackPane);
        pane.setBottom(paneForCheckBoxes);
        
        List<String> fontFamilies = Font.getFamilies();
        ObservableList<String> items = FXCollections.observableArrayList(fontFamilies);
        fontName.setItems(items);
        fontName.setValue(items.get(items.indexOf("Times New Roman")));
        
        ArrayList<String> sizes = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            sizes.add(String.valueOf(i));
        }
        items = FXCollections.observableArrayList(sizes);
        fontSize.setItems(items);
        fontSize.setValue(items.get(20 - 1));
        text.setFont(Font.font(getFamily(), getFontWeight(), getFontPosture(), getSize()));
        
        paneForComboBoxes.getChildren().addAll(new Label("Font Name"), fontName, new Label("Font Size"), fontSize);
        paneForCheckBoxes.getChildren().addAll(chbBold, chbItalic);
        
        fontName.setOnAction(e -> setText());
        fontSize.setOnAction(e -> setText());
        chbBold.setOnAction(e -> setText());
        chbItalic.setOnAction(e -> setText());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Select a font");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setText() {
        text.setFont(Font.font(getFamily(), getFontWeight(), getFontPosture(), getSize()));
    }
    
    public String getFamily() {
        return fontName.getValue().toString();
    }
    
    public FontWeight getFontWeight() {
        return chbBold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
    }
    
    public FontPosture getFontPosture() {
        return chbItalic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
    }
    
    public int getSize() {
        return Integer.parseInt(fontSize.getValue().toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
