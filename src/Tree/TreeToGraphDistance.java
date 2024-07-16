package Tree;

/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
    TLDR:
        Convert Tree to Graph (Adjacency matrix)
        Build Graph:
            computIfAbsent == current - parent
                           == parent --> current
        DFS with visited set and depth
*/





public class TreeToGraphDistance {
    HashMap<Integer, ArrayList<Integer>> graph;
    HashSet<Integer> visited;
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
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
        }
        for(int neighbour: graph.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                dfs(neighbour, depth+1, k);
            }
        }
    }
}
