package exercise_31_06Server;

import exercise_31_06Client.StudentAddress;
import exercise_31_06Client.StudentAddressConstants;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Exercise_31_06Server implements StudentAddressConstants {
    private ObjectOutputStream outputToClient;
    private ObjectInputStream inputFromClient;
    private ArrayList<StudentAddress> listOfStudentAddresses = new ArrayList<>();
    private int currentIndex = 0;
    private int countOfClients = 0;
    
    public static void main(String[] args) {
        new Exercise_31_06Server();
    }

    public Exercise_31_06Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started!");

            while(countOfClients < 2) {
                Socket socket = serverSocket.accept();
                countOfClients++;
                System.out.println("New client has been connected.");
                new Thread(new HandleAClient(socket)).start();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try{
                inputFromClient = new ObjectInputStream(socket.getInputStream());
                outputToClient = new ObjectOutputStream(socket.getOutputStream());
                
                while(true) {
                    int request = inputFromClient.readInt();
                    switch(request) {
                        case ADD : 
                            StudentAddress element = (StudentAddress)(inputFromClient.readObject());
                            listOfStudentAddresses.add(element);
                            currentIndex = 0;
                            break;
                        case FIRST :
                            if(!listOfStudentAddresses.isEmpty()) {
                                outputToClient.writeObject(listOfStudentAddresses.get(0));
                                currentIndex = 0;
                            }
                            break;
                        case NEXT :
                            if(currentIndex < listOfStudentAddresses.size() - 1) {
                                outputToClient.writeObject(listOfStudentAddresses.get(++currentIndex));
                            }
                            break;
                        case PREVIOUS :
                            if(currentIndex > 0 && !listOfStudentAddresses.isEmpty()) {
                                outputToClient.writeObject(listOfStudentAddresses.get(--currentIndex));
                            }
                            break;
                        case LAST :
                            if(!listOfStudentAddresses.isEmpty()) {
                                currentIndex = listOfStudentAddresses.size() - 1;
                                outputToClient.writeObject(listOfStudentAddresses.get(currentIndex));
                            }
                            break;
                        default :
                            break;
                    }
                    for(StudentAddress data : listOfStudentAddresses) {
                        System.out.println(data);
                    }
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            finally {
                countOfClients--;
            }
        }
    }
}
