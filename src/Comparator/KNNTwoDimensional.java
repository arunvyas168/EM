package Comparator;

import java.util.PriorityQueue;

/*
Problem: K Closest point to origin
*/


/*
    SOLUTION:
        TLDR:  Use Object POINT ---> constructor(x,y)--> calculates distance
                    @Override- compareTo -->
                    since closers we need a reverse comparator ---> so use the opject passed 1st
*/


public class KNNTwoDimensional {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        double distanceFromOrigin;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distanceFromOrigin = getDistance(x,y);
        }
        public double getDistance(int x, int y){
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));

        }
        @Override
        public int compareTo(Point point){
            return Double.compare(point.distanceFromOrigin,this.distanceFromOrigin);
        }

    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<points.length;i++){
            Point p = new Point(points[i][0], points[i][1]);
            pq.add(p);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i =0;
        int[][] result = new int[k][2];
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
