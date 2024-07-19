package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    /*
        STACK --- Iterative
    */

    public List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while((!stack.isEmpty())||(current!=null)){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.value);
            current = current.right;
        }
        return result;
    }


    /*
        RECURSIVE
    */

    public void inorderHelper(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        inorderHelper(root.left, result);
        result.add(root.value);
        inorderHelper(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
}
