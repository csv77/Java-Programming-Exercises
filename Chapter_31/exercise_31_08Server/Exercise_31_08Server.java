package exercise_31_08Server;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Exercise_31_08Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started!");
            Socket socket = serverSocket.accept();
            System.out.println("Client has connected.");
            
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
            
            int count = inputFromClient.readInt();
            System.out.println("Starting to read out the last " + count + " primes from file...");
            
            outputToClient.writeObject(getArrayList(count));
            System.out.println("Array with the primes was sent.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<Long> getArrayList(int countOfPrimes) {
        ArrayList<Long> primes = new ArrayList<>();
        try(RandomAccessFile raf = new RandomAccessFile("PrimeNumbers.dat", "r");){
            raf.seek(raf.length() - 8 * countOfPrimes);
            for(int i = 0; i < countOfPrimes; i++) {
                primes.add(raf.readLong());
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("IOException");
        }
        return primes;
    }
}
