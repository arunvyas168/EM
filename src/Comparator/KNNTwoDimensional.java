package Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNNTwoDimensional {

    static class Point implements Comparator<Point> {
        int x;
        int y;
        Double distanceFromOrigin;

        public Point(){}
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distanceFromOrigin = getDistance(x,y);
        }
        public static Double getDistance(int x, int y){
            return Math.sqrt(Math.pow((x-0),2)+Math.pow((y-0),2));

        }

        @Override
        public int compare(Point p1, Point p2) {
            return p2.distanceFromOrigin.compareTo(p1.distanceFromOrigin);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<Point> comp = new Point();
        PriorityQueue<Point> pq = new PriorityQueue<>(comp);
        for(int[] coordinates : points){
            Point point = new Point(coordinates[0], coordinates[1]);
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i =0;
        int[][] result = new int[k][k];
        while(!pq.isEmpty()){
            Point p = pq.poll();
            result[i] = new int[]{p.x, p.y};
            i++;
        }
        return result;
    }

    public static void main (String[] args){
        int[][] input = {{3,3},{5,-1},{-2,-4}};
        int k = 2;
        int[][] result =  kClosest(input, k);
        for(int[] num: result){
            System.out.println(num[0] +", "+ num[1]);
        }

    }


}
