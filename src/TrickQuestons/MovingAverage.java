package TrickQuestons;

import java.util.LinkedList;
import java.util.Queue;

/*
    QUESTION:

    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    Implement the MovingAverage class:

    MovingAverage(int size) Initializes the object with the size of the window size.

    double next(int val) Returns the moving average of the last size values of the stream.


Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3

 */


/*
    SOLUTION:

    1.
    Moving average class will have a QUEUE ---> data comes in and goes out
    Size of Queue will be part of constructor

    2.
    Always add 1st
    check size and remove if bigger than size
    calculate average --->
        1. add all numbers and devide by queue.size()
            queue.size() because queue can have less element than size
*/


public class MovingAverage {
    Queue<Integer> queue;
    int size;
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.add(val);
        if(queue.size()>size){
            queue.remove();
        }
        int sum = 0;
        for(Integer num :  queue){
            sum += num;
        }
        return (double)sum/queue.size();
    }
}
