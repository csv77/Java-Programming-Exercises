package exercise_17_09;

import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_09 extends Application {
    AddressPane pane = new AddressPane();
    private final int NAME = 32;
    private final int STREET = 32;
    private final int CITY = 20;
    private final int STATE = 2;
    private final int ZIP = 5;
    private final int ALL_FIELDS = 91;
    private int count = 0;
    
    @Override
    public void start(Stage primaryStage) {
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
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                raf.seek(raf.length());
                write(raf);
                int dataCount = (int)(raf.length() / (ALL_FIELDS));
                System.out.println("Address #" + dataCount + " saved!");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void first() {
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                if(raf.length() > 0) {
                    raf.seek(0);
                    read(raf);
                    count = 1;
                    System.out.println("Address #" + count + " is read!");
                }
                else {
                    System.out.println("File is empty!");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void next() {
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                if(count * ALL_FIELDS < raf.length()) {
                    count++;
                    raf.seek((count - 1) * ALL_FIELDS);
                    read(raf);
                    System.out.println("Address #" + count + " is read!");
                }
                else {
                    System.out.println("End of file!");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void previous() {
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                if(count > 1) {
                    count--;
                    raf.seek((count - 1) * ALL_FIELDS);
                    read(raf);
                    System.out.println("Address #" + count + " is read!");
                }
                else {
                    System.out.println("This is the first data!");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void last() {
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                if(raf.length() > 0) {
                    count = (int)(raf.length() / ALL_FIELDS);
                    raf.seek(raf.length() - ALL_FIELDS);
                    read(raf);
                }
                else {
                    System.out.println("File is empty!");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_09.dat", "rw")) {
                raf.seek((count - 1) * ALL_FIELDS);
                write(raf);
                System.out.println("Address #" + count + " updated!");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void read(RandomAccessFile raf) throws IOException {
        byte[] name = new byte[NAME];
        raf.read(name);
        pane.tfName.setText(new String(name));
        
        byte[] street = new byte[STREET];
        raf.read(street);
        pane.tfStreet.setText(new String(street));
        
        byte[] city = new byte[CITY];
        raf.read(city);
        pane.tfCity.setText(new String(city));
        
        byte[] state = new byte[STATE];
        raf.read(state);
        pane.tfState.setText(new String(state));
        
        byte[] zip = new byte[ZIP];
        raf.read(zip);
        pane.tfZip.setText(new String(zip));
    }
    
    public void write(RandomAccessFile raf) throws IOException {
        raf.write(setLength(pane.tfName.getText().getBytes(), NAME));
        raf.write(setLength(pane.tfStreet.getText().getBytes(), STREET));
        raf.write(setLength(pane.tfCity.getText().getBytes(), CITY));
        raf.write(setLength(pane.tfState.getText().getBytes(), STATE));
        raf.write(setLength(pane.tfZip.getText().getBytes(), ZIP));
    }
    
    public byte[] setLength(byte[] text, int length) {
        byte[] bytes = new byte[length];
        for(int i = 0; i < Math.min(text.length, bytes.length); i++) {
            bytes[i] = text[i];
        }
        return bytes;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
