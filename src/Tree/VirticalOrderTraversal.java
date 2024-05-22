package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VirticalOrderTraversal {



/*
    SOLUTION:

    TLDR: --- Maintain a column starting 0 and increment and derement---> use sorted map --> treemap for getting in sorted order

        1. We do Depth First Search and store Nodes in TreeMap
        2. With TreeMap Stores {ColumnNUmber,Node} mapping
        3. every time left decrease ColumnNUmber
        4. Right will increase ColumnNUmber
        5. In the end Traverse Tree map and give result
*/




    /*
        DFS solution with Treemap for sorting
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int column = 0;
        verticalOrderUtil(root, map, column);
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public void verticalOrderUtil(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map, int column){
        if(root==null){
            return;
        }
        ArrayList<Integer> list = null;
        if(map.containsKey(column)){
            list = map.get(column);
        }else{
            list = new ArrayList<>();

        }
        list.add(root.value);
        map.put(column, list);
        verticalOrderUtil(root.left, map, column-1);
        verticalOrderUtil(root.right, map, column+1);
    }
}
