package exercise_16_19;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import runningfan.FanPane;

public class Exercise_16_19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane fanPane1 = getFanPane();
        BorderPane fanPane2 = getFanPane();
        BorderPane fanPane3 = getFanPane();
        
        HBox paneForFanPanes = new HBox(10);
        paneForFanPanes.getChildren().addAll(fanPane1, fanPane2, fanPane3);
        paneForFanPanes.setAlignment(Pos.CENTER);
        
        Button btStartAll = new Button("Start All");
        Button btStopAll = new Button("Stop All");
        
        HBox paneForButtons = new HBox(10, btStartAll, btStopAll);
        paneForButtons.setAlignment(Pos.CENTER);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForFanPanes);
        pane.setBottom(paneForButtons);
        
        ObservableList<Node> list = paneForFanPanes.getChildren();
        
        btStartAll.setOnAction(e -> {
            for(Node i : list) {
                ((FanPane)((BorderPane)i).getCenter()).play();
            }
        });
        
        btStopAll.setOnAction(e -> {
            for(Node i : list) {
                ((FanPane)((BorderPane)i).getCenter()).pause();
            }
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public BorderPane getFanPane() {
        FanPane fanPane = new FanPane(200, 200, 100);
        fanPane.play();
        
        Slider slider = new Slider();
        slider.setMax(10);
        slider.setValue(5);
        
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        hBox.getChildren().addAll(pause, resume, reverse);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(fanPane);
        pane.setTop(hBox);
        pane.setBottom(slider);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setStyle("-fx-border-color: black");
        
        pause.setOnAction(e -> fanPane.pause());
        resume.setOnAction(e -> fanPane.play());
        reverse.setOnAction(e -> fanPane.reverse());
        fanPane.getRateProperty().bind(slider.valueProperty());
        
        return pane;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
