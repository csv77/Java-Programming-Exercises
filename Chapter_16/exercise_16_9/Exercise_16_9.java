package exercise_16_9;

import javafx.application.Application;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_9 extends Application {
    private Rectangle r1 = getRectangle();
    private Rectangle r2 = getRectangle();
    private TextField tfX1 = new TextField();
    private TextField tfY1 = new TextField();
    private TextField tfWidth1 = new TextField();
    private TextField tfHeight1 = new TextField();
    private TextField tfX2 = new TextField();
    private TextField tfY2 = new TextField();
    private TextField tfWidth2 = new TextField();
    private TextField tfHeight2 = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(Pos.CENTER);
        
        HBox hBox = new HBox(5);
        hBox.getChildren().add(getVBox(new Label("Enter rectangle 1 info:"), tfX1, tfY1, tfWidth1, tfHeight1));
        hBox.getChildren().add(getVBox(new Label("Enter rectangle 2 info:"), tfX2, tfY2, tfWidth2, tfHeight2));
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(intersect());
        
        Pane pane = new Pane();
        pane.setPrefWidth(300);
        pane.setPrefHeight(200);
        pane.setStyle("-fx-background-color: white");
        Button btDraw = new Button("Redraw Rectangles");
        
        vBox.getChildren().addAll(stackPane, pane, hBox, btDraw);
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_16_9");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btDraw.setOnAction(e -> {
            pane.getChildren().clear();
            r1.setX(Double.parseDouble(tfX1.getText()));
            r1.setY(Double.parseDouble(tfY1.getText()));
            r1.setWidth(Double.parseDouble(tfWidth1.getText()));
            r1.setHeight(Double.parseDouble(tfHeight1.getText()));
            r2.setX(Double.parseDouble(tfX2.getText()));
            r2.setY(Double.parseDouble(tfY2.getText()));
            r2.setWidth(Double.parseDouble(tfWidth2.getText()));
            r2.setHeight(Double.parseDouble(tfHeight2.getText()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
            pane.getChildren().addAll(r1, r2);
        });
        
        r1.setOnMouseDragged(e -> {
            r1.setX(e.getX() - r1.getWidth() / 2);
            r1.setY(e.getY() - r1.getHeight() / 2);
            tfX1.setText(String.valueOf(r1.getX()));
            tfY1.setText(String.valueOf(r1.getY()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
        });
        
        r2.setOnMouseDragged(e -> {
            r2.setX(e.getX() - r2.getWidth() / 2);
            r2.setY(e.getY() - r2.getHeight() / 2);
            tfX2.setText(String.valueOf(r2.getX()));
            tfY2.setText(String.valueOf(r2.getY()));
            stackPane.getChildren().clear();
            stackPane.getChildren().add(intersect());
        });
        
    }
    
    public Rectangle getRectangle() {
        Rectangle r = new Rectangle();
        r.setStroke(Color.BLACK);
        r.setFill(Color.TRANSPARENT);
        return r;
    }
    
    public Text intersect() {
        return new Text("Two rectangles intersect? " + (isIntersect() ? "Yes" : "No"));
    }
    
    public boolean isIntersect() {
        return (!(contains(r2, r1) || contains(r1, r2)) && overlaps(r1, r2) && overlaps(r2, r1)) ? true : false;
    }
    
    public static boolean overlaps(Rectangle r1, Rectangle r2) {
        return getDistance(r1.getX(), r2.getX() + r2.getWidth()) < r1.getWidth() + r2.getWidth() &&
               getDistance(r1.getY(), r2.getY() + r2.getHeight()) < r1.getHeight() + r2.getHeight();
    }
    
    public static boolean contains(Rectangle r1, Rectangle r2) {
        return r2.getX() + r2.getWidth() <= r1.getX() + r1.getWidth() &&
               r2.getY() + r2.getHeight() <= r1.getY() + r1.getHeight() &&
               r2.getX() > r1.getX() &&
               r2.getY() > r1.getY();
    }
    
    public static double getDistance(double p1, double p2) {
        return Math.abs(p2 - p1);
    }
    
    public VBox getVBox(Label label, TextField tfX, TextField tfY, TextField tfWidth, TextField tfHeight) {
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
        tfWidth.setPrefColumnCount(3);
        tfWidth.setAlignment(Pos.BOTTOM_RIGHT);
        tfHeight.setPrefColumnCount(3);
        tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
        
        pane.add(new Label("X:"), 0, 0);
        pane.add(new Label("Y:"), 0, 1);
        pane.add(new Label("Width:"), 0, 2);
        pane.add(new Label("Height"), 0, 3);
        pane.add(tfX, 1, 0);
        pane.add(tfY, 1, 1);
        pane.add(tfWidth, 1, 2);
        pane.add(tfHeight, 1, 3);
        
        vBox.getChildren().addAll(label, pane);
        vBox.setStyle("-fx-border-color: black");
        return vBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

