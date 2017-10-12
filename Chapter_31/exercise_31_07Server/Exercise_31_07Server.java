package exercise_31_07Server;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_31_07Server {

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
            
            long[] primes = getArray(count);
            outputToClient.writeObject(primes);
            System.out.println("Array with the primes was sent.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static long[] getArray(int countOfPrimes) {
        long[] primes = new long[countOfPrimes];
        try(RandomAccessFile raf = new RandomAccessFile("PrimeNumbers.dat", "r");){
            raf.seek(raf.length() - 8 * countOfPrimes);
            for(int i = 0; i < countOfPrimes; i++) {
                primes[i] = raf.readLong();
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
