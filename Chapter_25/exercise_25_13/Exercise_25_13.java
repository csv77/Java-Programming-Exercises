package exercise_25_13;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_25_13 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BST<Integer> tree = new BST<>();

        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree);
        pane.setCenter(view);

        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btInorder = new Button("Show Inorder");
        Button btPreorder = new Button("Show Preorder");
        Button btPostorder = new Button("Show Postorder");
        
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete, btInorder, btPreorder, btPostorder);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        
        Label lbStatus = new Label();
        pane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if(tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            }
            else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if(!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            }
            else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });
        
        btInorder.setOnAction(e -> {
            lbStatus.setText("");
            ArrayList<Integer> list = (ArrayList<Integer>)tree.inorderList();
            if(list.size() > 0) {
                StringBuilder text = new StringBuilder("Inorder: [");
                for(int i = 0; i < list.size(); i++) {
                    if(i < list.size() - 1) {
                        text.append(list.get(i) + ", ");
                    }
                    else {
                        text.append(list.get(i) + "]");
                    }
                }
                lbStatus.setText(text.toString());
            }
            else {
                lbStatus.setText("The tree is empty.");
            }
        });
        
        btPreorder.setOnAction(e -> {
            lbStatus.setText("");
            ArrayList<Integer> list = (ArrayList<Integer>)tree.preorderList();
            if(list.size() > 0) {
                StringBuilder text = new StringBuilder("Preorder: [");
                for(int i = 0; i < list.size(); i++) {
                    if(i < list.size() - 1) {
                        text.append(list.get(i) + ", ");
                    }
                    else {
                        text.append(list.get(i) + "]");
                    }
                }
                lbStatus.setText(text.toString());
            }
            else {
                lbStatus.setText("The tree is empty.");
            }
        });
        
        btPostorder.setOnAction(e -> {
            lbStatus.setText("");
            ArrayList<Integer> list = (ArrayList<Integer>)tree.postorderList();
            if(list.size() > 0) {
                StringBuilder text = new StringBuilder("Postorder: [");
                for(int i = 0; i < list.size(); i++) {
                    if(i < list.size() - 1) {
                        text.append(list.get(i) + ", ");
                    }
                    else {
                        text.append(list.get(i) + "]");
                    }
                }
                lbStatus.setText(text.toString());
            }
            else {
                lbStatus.setText("The tree is empty.");
            }
        });
        
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Exercise_25_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
