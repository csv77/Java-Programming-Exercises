package exercise_26_01;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_26_01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        AVLTree<Integer> tree = new AVLTree<>();

        BorderPane pane = new BorderPane();
        AVLView view = new AVLView(tree);
        pane.setCenter(view);

        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        
        Label lbStatus = new Label();
        pane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if(tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is already in the AVLtree");
            }
            else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " is inserted in the AVLtree");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if(!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is not in the AVLtree");
            }
            else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is deleted from the AVLtree");
            }
        });
                        
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Exercise_26_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
