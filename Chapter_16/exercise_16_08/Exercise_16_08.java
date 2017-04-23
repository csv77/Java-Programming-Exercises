package exercise_16_08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_08 extends Application {
    private Circle c1 = getCircle();
    private Circle c2 = getCircle();
    private TextField tfX1 = new TextField();
    private TextField tfY1 = new TextField();
    private TextField tfRadius1 = new TextField();
    private TextField tfX2 = new TextField();
    private TextField tfY2 = new TextField();
    private TextField tfRadius2 = new TextField();
        
    @Override
    public void start(Stage primaryStage) {
        
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(Pos.CENTER);
        
        HBox hBox = new HBox(5);
        hBox.getChildren().add(getVBox(new Label("Enter circle 1 info:"), tfX1, tfY1, tfRadius1));
        hBox.getChildren().add(getVBox(new Label("Enter circle 2 info:"), tfX2, tfY2, tfRadius2));
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(intersect());
        
        Pane pane = new Pane();
        pane.setPrefWidth(300);
        pane.setPrefHeight(200);
        
        Button btDraw = new Button("Redraw Circles");
        
        vBox.getChildren().addAll(stackPane, pane, hBox, btDraw);
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_16_8");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btDraw.setOnAction(e -> {
            pane.getChildren().clear();
            c1.setCenterX(Double.parseDouble(tfX1.getText()));
            c1.setCenterY(Double.parseDouble(tfY1.getText()));
            c1.setRadius(Double.parseDouble(tfRadius1.getText()));
            c2.setCenterX(Double.parseDouble(tfX2.getText()));
            c2.setCenterY(Double.parseDouble(tfY2.getText()));
            c2.setRadius(Double.parseDouble(tfRadius2.getText()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
            pane.getChildren().addAll(c1, c2);
        });
        
        c1.setOnMouseDragged(e -> {
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            tfX1.setText(String.valueOf(c1.getCenterX()));
            tfY1.setText(String.valueOf(c1.getCenterY()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
        });
        
        c2.setOnMouseDragged(e -> {
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
            tfX2.setText(String.valueOf(c2.getCenterX()));
            tfY2.setText(String.valueOf(c2.getCenterY()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
        });
        
    }
    
    public Circle getCircle() {
        Circle c = new Circle();
        c.setStroke(Color.BLACK);
        c.setFill(Color.TRANSPARENT);
        return c;
    }
    
    public Text intersect() {
        return new Text("Two circles intersect? " + (isIntersect() ? "Yes" : "No"));
    }
    
    public boolean isIntersect() {
        double distance = Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(), 2) +
                Math.pow(c1.getCenterY() - c2.getCenterY(), 2));
        return distance < c1.getRadius() + c2.getRadius() &&
                distance > Math.max(c1.getRadius(), c2.getRadius()) - Math.min(c1.getRadius(), c2.getRadius());
    }
    
    public VBox getVBox(Label label, TextField tfX, TextField tfY, TextField tfRadius) {
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(150);
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        
        tfX.setPrefColumnCount(3);
        tfX.setAlignment(Pos.BOTTOM_RIGHT);
        tfY.setPrefColumnCount(3);
        tfY.setAlignment(Pos.BOTTOM_RIGHT);
        tfRadius.setPrefColumnCount(3);
        tfRadius.setAlignment(Pos.BOTTOM_RIGHT);
        
        pane.add(new Label("Center X:"), 0, 0);
        pane.add(new Label("Center Y:"), 0, 1);
        pane.add(new Label("Radius:"), 0, 2);
        pane.add(tfX, 1, 0);
        pane.add(tfY, 1, 1);
        pane.add(tfRadius, 1, 2);
        
        vBox.getChildren().addAll(label, pane);
        vBox.setStyle("-fx-border-color: black");
        return vBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
