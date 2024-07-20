package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
SOLUTION:
    TLDR: Do Level Order and take the right most of that level

    1. Since its level order -- use a Queue
    2. Have a variable rightMostValue
    3. when loop finishes its the right most value

*/


public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int rightMostValue=0;
            while(size>0){
                TreeNode next = q.remove();
                rightMostValue = next.value;
                if(next.left!=null){
                    q.add(next.left);
                }
                if(next.right!=null){
                    q.add(next.right);
                }
                size--;
            }
            result.add(rightMostValue);
        }
        return result;
    }
}
