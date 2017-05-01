package exercise_17_09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_09 extends Application {
    private final int NAME = 32;
    private final int STREET = 32;
    private final int CITY = 20;
    private final int STATE = 2;
    private final int ZIP = 5;
    
    @Override
    public void start(Stage primaryStage) {
        AddressPane pane = new AddressPane();
        
        pane.btAdd.setOnAction(e -> add());
        pane.btFirst.setOnAction(e -> first());
        pane.btNext.setOnAction(e -> next());
        pane.btPrevious.setOnAction(e -> previous());
        pane.btLast.setOnAction(e -> last());
        pane.btUpdate.setOnAction(e -> update());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_09");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void add() {
        
    }
    
    public void first() {
        
    }
    
    public void next() {
        
    }
    
    public void previous() {
        
    }
    
    public void last() {
        
    }
    
    public void update() {
        
    }
    
    public void read() {
        
    }
    
    public void write() {
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
