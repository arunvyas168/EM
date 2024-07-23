package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/*
    TLDR:
        1. Using DFS and cloning a graph
        2. Use HashMap visited to store <originalNode, cloneNode>
    Note: imp to know what you are storing in HashMap
*/

public class CloneGraph {
    // to avoid cycles and visiting same node
    HashMap<Node, Node> visited = new HashMap<>();

    // DFS so will be recursion
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
