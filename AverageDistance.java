import java.lang.Math;

public class AverageDistance {
    public static void main(String args[]) {
        double[] point1 = {2.0, 3.0};
        double[] point2 = {-1.0, -3.5};
        double[] point3 = {5.97, 6.8};

        double result = averageDistance(point1[0], point1[1], point2[0], point2[1], point3[0], point3[1]);
        System.out.println(result);
    }
    
    public static double averageDistance(double x1, double y1, double x2, double y2, double x3, double y3) {
        double totalDistance = 0;
        totalDistance += Math.sqrt(Math.pow((x2 - x1), 2.0) + Math.pow((y2 - y1), 2.0));
        totalDistance += Math.sqrt(Math.pow((x3 - x1), 2.0) + Math.pow((y3 - y1), 2.0));
        totalDistance += Math.sqrt(Math.pow((x3 - x2), 2.0) + Math.pow((y3 - y2), 2.0));
        
        return totalDistance/3.0;
    }
}
