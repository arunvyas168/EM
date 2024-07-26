package Tree;

import java.util.Stack;

/*
    Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.
Example 1:
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4

Example 2:
Input: root = [1], target = 4.428571
Output: 1
*/



/*
        TLDR:
            InOrder BST --> Sorted Array
            Stop traversal when you find lastMin <= target < current value
            Use stack and do in order
*/

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
