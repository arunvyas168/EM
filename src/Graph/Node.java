package Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

//    public Node() {
//        this.val = 0;
//        this.neighbors = new ArrayList<>();
//    }
//    public Node(int val) {
//        this.val = val;
//        neighbors = new ArrayList<>();
//    }
}

