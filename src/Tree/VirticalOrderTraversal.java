package Tree;

import java.util.*;

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
        Solution-1 DFS solution with Treemap for sorting (only sort column)
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




    /*
        Solution-2 DFS solution with Treemap for sorting (sort column and column)

        TLDR:
            TreeMap key == column in sorted way
            TreeMap value == List of nodes in that virtical
            Value list has to be sorted. So for list sort use Pair class
    */

    public static class Pair implements Comparable<Pair>{
        int value;
        int row;
        public Pair(int value, int row){
            this.value = value;
            this. row = row;
        }
        @Override
        public int compareTo(Pair pair){

            return Integer.compare(this.row, pair.row);
        }

    }

    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
        int column = 0;
        int row = 0;
        verticalOrder2_util(root, row, column, map);
        for(Map.Entry<Integer, ArrayList<Pair>> entry: map.entrySet()){
            // lets get sorted value instead of sorted pair
            ArrayList<Integer> list = getColumnSortedList(entry.getValue());
            result.add(list);
        }
        return result;
    }

    // Helper function to create Pair object and add to Tree map
    public void verticalOrder2_util(TreeNode root, int column, int row, TreeMap<Integer, ArrayList<Pair>> map){
        if(root == null){
            return;
        }
        ArrayList<Pair> list = null;
        if(map.containsKey(column)){
            list = map.get(column);
        }else{
            list = new ArrayList<>();

        }
        list.add(new Pair(row, root.value));
        map.put(column, list);
        verticalOrder2_util(root.left, column-1, row+1, map);
        verticalOrder2_util(root.right, column+1, row+1, map);
    }

    // This function is to sort and also convert pair list to value list
    public ArrayList<Integer> getColumnSortedList(ArrayList<Pair> value){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(value);
        for(Pair item: value){
            list.add(item.value);
        }
        return list;
    }

}
