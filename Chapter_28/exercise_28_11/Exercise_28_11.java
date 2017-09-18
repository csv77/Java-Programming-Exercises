package exercise_28_11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.font.FontFamily;

public class Exercise_28_11 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.setAlignment(Pos.CENTER);
        
        Button btSolve = new Button("Solve");
        Button btStart = new Button("Start Over");
        hBoxForButtons.getChildren().addAll(btSolve, btStart);
        borderPane.setBottom(hBoxForButtons);
        
        NineTailModel model = new NineTailModel();
        char[] nodes = {'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'};
        NineTailPane pane = new NineTailPane(nodes);
        
        HBox hBoxForNodes = new HBox(5);
        hBoxForNodes.getChildren().add(pane);
        hBoxForNodes.setStyle("-fx-border-color : red");
        borderPane.setCenter(hBoxForNodes);
        
        Scene scene = new Scene(borderPane, 300, 140);
        primaryStage.setTitle("Exercise_28_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public class NineTailPane extends GridPane {
        private char[] node;
        

        public NineTailPane(char[] node) {
            this.node = node;
            for(int i = 0; i < 9; i++) {
                Label lbHOrT = new Label(node[i] + "");
                lbHOrT.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
                this.add(lbHOrT, i % 3, i / 3);
                lbHOrT.setOnMouseClicked(e -> {
                    if(lbHOrT.getText().equals("H")) {
                        lbHOrT.setText("T");
                    }
                    else {
                        lbHOrT.setText("H");
                    }
                });            }
            this.setStyle("-fx-border-color : black");
        }
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
