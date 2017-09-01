package exercise_25_17;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_25_17 {
    private static final double MAXWEIGHT = 10;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int numberOfObjects = input.nextInt();
        
        double[] weights = new double[numberOfObjects];
        System.out.print("Enter the weights of the objects: ");
        int k = 0;
        while(k < weights.length) {
            double weight = input.nextDouble();
            if(weight <= MAXWEIGHT) {
                weights[k] = weight;
                k++;
            }
            else {
                System.out.println("Weight must be less than " + MAXWEIGHT);
            }
        }
        
        ArrayList<Container> containers = new ArrayList<>();
        containers.add(new Container());
        
        for(int i = 0; i < weights.length; i++) {
            for(int j = 0; j < containers.size(); j++) {
                if(containers.get(j).addObject(weights[i])) {
                    break;
                }
                else {
                    containers.add(new Container());
                    containers.get(containers.size() - 1).addObject(weights[i]);
                }
            }
        }
        
        for(int i = 0; i < containers.size(); i++) {
            System.out.println("Container " + (i + 1) + " contains objects with weight " + containers.get(i).toString());
        }
    }
    
    public static class Container {
        private ArrayList<Double> objects = new ArrayList<>();
        private double totalWeight = 0;
        
        public Container() {
        }
        
        public boolean addObject(double weight) {
            if(totalWeight + weight <= MAXWEIGHT) {
                objects.add(weight);
                totalWeight += weight;
                return true;
            }
            return false;
        }
        
        public int getNumberOfObjects() {
            return objects.size();
        }
        
        @Override
        public String toString() {
            StringBuilder text = new StringBuilder();
            for(Double weight : objects) {
                text.append(weight + " ");
            }
        return text.toString();
        }
    }
}
