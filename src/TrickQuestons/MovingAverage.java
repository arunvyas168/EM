package TrickQuestons;

import java.util.LinkedList;
import java.util.Queue;

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
