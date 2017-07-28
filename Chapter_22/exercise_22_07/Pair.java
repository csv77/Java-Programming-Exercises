package exercise_22_07;

import java.util.ArrayList;
import java.util.Arrays;

public class Pair {
    private Point p1;
    private Point p2;

    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    public double getDistance() {
        return distance(p1, p2);
    }
    
    public static double distance(Point p1, Point p2) {
        return distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    public static Pair getClosestPair(double[][] points) {
        Point[] points2 = new Point[points.length];
        for(int i = 0; i < points2.length; i++) {
            points2[i] = new Point(points[i][0], points[i][1]);
        }
        return getClosestPair(points2);
    }
    
    public static Pair getClosestPair(Point[] points) {
        Arrays.sort(points);
        Point[] pointsOrderedOnY = points.clone();
        Arrays.sort(points, new CompareY());
        return distance(points, 0, points.length - 1, pointsOrderedOnY);
    }
    
    public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
            Point[] pointsOrderedOnY) {
        if(low >= high) {
            return null;
        }
        else if(low + 1 == high) {
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        }
  
        int halfSize = (low + high) / 2;
        Pair p1 = distance(pointsOrderedOnX, low, halfSize, pointsOrderedOnY);
        Pair p2 = distance(pointsOrderedOnX, halfSize + 1, high, pointsOrderedOnY);

        double distance = 0;
        Pair p = null;

        if(p1 == null && p2 == null) {
            distance = Double.MAX_VALUE;
        }
        else if(p1 == null) {
            distance = p2.getDistance();
            p = p2;
        }
        else if(p2 == null) {
            distance = p1.getDistance();
            p = p1;
        }
        else {
            distance = Math.min(p1.getDistance(), p2.getDistance());
            p = ((p1.getDistance() <= p2.getDistance())? p1 : p2);
        }

        ArrayList<Point> stripL = new ArrayList<Point>();
        ArrayList<Point> stripR = new ArrayList<Point>();
        for (int i = 0; i < pointsOrderedOnY.length; i++) {
            if((pointsOrderedOnY[i].getX() <= pointsOrderedOnX[halfSize].getX()) && 
                    (pointsOrderedOnY[i].getX() >= pointsOrderedOnX[halfSize].getX() - distance)) {
                stripL.add(pointsOrderedOnY[i]);
            }
            else {
                stripR.add(pointsOrderedOnY[i]);
            }
        }

        double d3 = distance;
        int r = 0;
        for (int i = 0; i < stripL.size(); i++) {
            while (r < stripR.size() && stripL.get(i).getY() > stripR.get(r).getY() + distance) {
                r++;
            }

            int r1 = r;
            while (r1 < stripR.size() && stripR.get(r1).getY() <= stripL.get(i).getY() + distance) {
                if (d3 > distance(stripL.get(i), stripR.get(r1))) {
                    d3 = distance(stripL.get(i), stripR.get(r1));
                    p.p1 = stripL.get(i);
                    p.p2 = stripR.get(r1);
                }
                r1++;
            }
        }

        return p;
    }
}
