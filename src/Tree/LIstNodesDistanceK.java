package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
*/



/*
    TLDR:
        Convert Tree to Graph (Adjacency matrix)
        Build Graph:
            computIfAbsent == current - parent
                           == parent --> current
        DFS with visited set and depth
*/




public class LIstNodesDistanceK {
    // Ask if values are unique
    HashMap<Integer, ArrayList<Integer>> graph;
    HashSet<Integer> visited;
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Build graph Adjacency matrix
        graph = new HashMap<>();
        buildGraph(root, null);

        // DFS starts
        visited = new HashSet<>();
        result = new ArrayList<>();
        visited.add(target.value);
        dfs(target.value, 0, k);
        return result;

    }

    public void buildGraph(TreeNode current, TreeNode parent){
        if((current!=null)&&(parent!=null)){
            graph.computeIfAbsent(current.value, k-> new ArrayList<>()).add(parent.value);
            graph.computeIfAbsent(parent.value, k-> new ArrayList<>()).add(current.value);
        }
        if(current.left!=null){
            buildGraph(current.left, current);
        }
        if(current.right!=null){
            buildGraph(current.right, current);
        }
    }

    public void dfs(int curr, int depth, int k){
        if(depth==k){
            result.add(curr);
            return;
        }
        for(int neighbour: graph.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                dfs(neighbour, depth+1, k);
            }
        }
    }





    /*
        Assuming we can add parent pointer
    */

    /*
    List<Integer> result = new ArrayList<>();
    HashSet<TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        //Optional step only if we have to reconstruct parent pointers

        addParent(root, null);  // step-1
        //------------------


        dfs(target, k);         // step-2
        return result;          // step-3
    }

    public void addParent(TreeNode current, TreeNode parent){
        if(current!=null){
            current.parent = parent;
            addParent(current.left, current);
            addParent(current.right, current);
        }
    }

    public void dfs(TreeNode current, int distance){
        if((current==null)||(visited.contains(current))){
            return;
        }
        visited.add(current);
        if(distance==0){
            result.add(current.val);
            return;
        }
        dfs(current.parent, distance-1);
        dfs(current.left, distance-1);
        dfs(current.right, distance-1);
    }
    */

}
