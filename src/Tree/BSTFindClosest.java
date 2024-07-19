package Tree;

import java.util.Stack;

public class BSTFindClosest {
    public int BSTCLosestValue(TreeNode root, int key){

        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        TreeNode current = root;

        while((!stack.isEmpty())||(current!=null)){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if((min<=key)&&(key<=current.value)){
                if(Math.abs(min-key)<=Math.abs(key-current.value)){
                    return min;
                }else{
                    return current.value;
                }
            }
            min = current.value;
            current = current.right;
        }

        return min;

    }
}
