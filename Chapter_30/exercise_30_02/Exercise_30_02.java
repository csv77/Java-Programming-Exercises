package exercise_30_02;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_30_02 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CarPane carPane = new CarPane();
        
        Scene scene = new Scene(carPane, 300, 250);
        primaryStage.setTitle("Exercise_30_02");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.widthProperty().addListener(e -> carPane.setW(carPane.getWidth()));
        scene.heightProperty().addListener(e -> carPane.setH(carPane.getHeight()));
        
        carPane.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.UP)) {
                carPane.increaseSpeed();
            }
            else if(e.getCode().equals(KeyCode.DOWN)) {
                carPane.decreaseSpeed();
            }
        });
        
        carPane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                carPane.suspend();
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                carPane.resume();
            }
        });
        carPane.requestFocus();
    }
    
    public class CarPane extends Pane{
        private double width = 300;
        private double height = 250;
        private double x = -50;
        private double y = height;
        private Rectangle rec = new Rectangle(x, y - 20, 50, 10);;
        private Polygon trapeze = new Polygon(x + 10, y - 20, x + 20, y - 30,
                x + 30, y - 30, x + 40, y - 20);;
        private Circle c1 = new Circle(x + 15, y - 5, 5);
        private Circle c2 = new Circle(x + 35, y - 5, 5);
        private int sleepTime = 50;
        private Thread thread = new Thread(() -> {
            try {
                while(true) {
                    Platform.runLater(() -> drive());
                    Thread.sleep(sleepTime);
                }
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        
        public CarPane() {
            rec.setFill(Color.CYAN);
            trapeze.setFill(Color.LIGHTSKYBLUE);
            getChildren().addAll(rec, c1, c2, trapeze);
            thread.start();
        }

        public void suspend() {
            thread.suspend();
        }

        public void resume() {
            thread.resume();
        }

        public void increaseSpeed() {
            if(sleepTime > 1) {
                sleepTime--;
            }
        }

        public void decreaseSpeed() {
            sleepTime++;
        }

        public void drive() {
            if(x > width) {
                x = -50;
            }
            else {
                x++;
            }
            setCoordinates();
            y = height;
        }
        
        public void setCoordinates() {
            rec.setX(x);
            rec.setY(y - 20);
            c1.setCenterX(x + 15);
            c1.setCenterY(y - 5);
            c2.setCenterX(x + 35);
            c2.setCenterY(y - 5);
            trapeze.getPoints().clear();
            trapeze.getPoints().addAll(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        }
        
        public void setW(double width) {
            this.width = width;
            setCoordinates();
        }
        
        public void setH(double height) {
            this.height = height;
            setCoordinates();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
