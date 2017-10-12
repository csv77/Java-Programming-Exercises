package exercise_31_06Client;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_31_06Client extends Application implements StudentAddressConstants {
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();

    private Button btAdd = new Button("Add");
    private Button btFirst = new Button("First");
    private Button btNext = new Button("Next");
    private Button btPrevious = new Button("Previous");
    private Button btLast = new Button("Last");

    private String host = "localhost";
    private Socket socket;
    private int index = 0;
    private ObjectOutputStream outputToServer;
    private ObjectInputStream inputFromServer;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5, 15, 5, 15));
        
        GridPane pane = new GridPane();
        pane.setVgap(3);
        pane.setHgap(3);
        pane.setPadding(new Insets(3));
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);    
        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        pane.add(new Label("City"), 0, 2);

        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State"), tfState, new Label("Zip"), tfZip);
        pane.setAlignment(Pos.CENTER);   
        borderPane.setCenter(pane);
        
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast);
        hBoxForButtons.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBoxForButtons);
        
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);
        
        try {
            socket = new Socket(host, 8000);
            outputToServer = new ObjectOutputStream(socket.getOutputStream());
            inputFromServer = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        btAdd.setOnAction(e -> {
            try {
                StudentAddress address = getDataFromTextFields();
                outputToServer.writeInt(ADD);
                outputToServer.writeObject(address);
                outputToServer.flush();
                index = inputFromServer.readInt();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        setButtonAction(btFirst, FIRST);
        setButtonAction(btNext, NEXT);
        setButtonAction(btPrevious, PREVIOUS);
        setButtonAction(btLast, LAST);
        
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Exercise_31_06Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void setButtonAction(Button bt, int request) {
        bt.setOnAction(e -> {
            try {
                outputToServer.writeInt(request);
                outputToServer.flush();
                switch(request) {
                    case FIRST :
                        index = 0;
                        break;
                    case NEXT :
                        int size = inputFromServer.readInt();
                        if(index < size - 1) {
                            index++;
                        }
                        outputToServer.writeInt(index);
                        outputToServer.flush();
                        break;
                    case PREVIOUS :
                        if(index > 0) {
                            index--;
                        }
                        outputToServer.writeInt(index);
                        outputToServer.flush();
                        break;
                    case LAST :
                        index = inputFromServer.readInt();
                        break;
                }
                if(inputFromServer.readBoolean()) {
                    setTextFields((StudentAddress)(inputFromServer.readObject()));
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void setTextFields(StudentAddress data) {
        tfName.setText(data.getName());
        tfStreet.setText(data.getStreet());
        tfCity.setText(data.getCity());
        tfState.setText(data.getState());
        tfZip.setText(data.getZip());
    }
    
    private StudentAddress getDataFromTextFields() {
        StudentAddress data = new StudentAddress(tfName.getText(), tfStreet.getText(),
                tfCity.getText(), tfState.getText(), tfZip.getText());
        return data;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
