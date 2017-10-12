package exercise_31_06Server;

import exercise_31_06Client.StudentAddress;
import exercise_31_06Client.StudentAddressConstants;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Exercise_31_06Server implements StudentAddressConstants {
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
                ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                int currentIndex = 0;
                
                while(true) {
                    int request = inputFromClient.readInt();
                    switch(request) {
                        case ADD : 
                            StudentAddress element = (StudentAddress)(inputFromClient.readObject());
                            listOfStudentAddresses.add(element);
                            outputToClient.writeInt(listOfStudentAddresses.size() - 1);
                            outputToClient.flush();
                            break;
                        case FIRST :
                            if(!listOfStudentAddresses.isEmpty()) {
                                outputToClient.writeBoolean(true);
                                outputToClient.flush();
                                outputToClient.writeObject(listOfStudentAddresses.get(0));
                                outputToClient.flush();
                            }
                            else {
                                outputToClient.writeBoolean(false);
                                outputToClient.flush();
                            }
                            break;
                        case NEXT :
                            outputToClient.writeInt(listOfStudentAddresses.size());
                            outputToClient.flush();
                            currentIndex = inputFromClient.readInt();
                            if(listOfStudentAddresses.size() > 1 && currentIndex < listOfStudentAddresses.size()) {
                                outputToClient.writeBoolean(true);
                                outputToClient.flush();
                                outputToClient.writeObject(listOfStudentAddresses.get(currentIndex));
                                outputToClient.flush();
                            }
                            else {
                                outputToClient.writeBoolean(false);
                                outputToClient.flush();
                            }
                            break;
                        case PREVIOUS :
                            currentIndex = inputFromClient.readInt();
                            if(listOfStudentAddresses.size() > 1 && currentIndex >= 0) {
                                outputToClient.writeBoolean(true);
                                outputToClient.flush();
                                outputToClient.writeObject(listOfStudentAddresses.get(currentIndex));
                                outputToClient.flush();
                            }
                            else {
                                outputToClient.writeBoolean(false);
                                outputToClient.flush();
                            }
                            break;
                        case LAST :
                            outputToClient.writeInt(listOfStudentAddresses.size() - 1);
                            if(!listOfStudentAddresses.isEmpty()) {
                                outputToClient.writeBoolean(true);
                                outputToClient.flush();
                                currentIndex = listOfStudentAddresses.size() - 1;
                                outputToClient.writeObject(listOfStudentAddresses.get(currentIndex));
                                outputToClient.flush();
                            }
                            else {
                                outputToClient.writeBoolean(false);
                                outputToClient.flush();
                            }
                            break;
                        default :
                            break;
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
