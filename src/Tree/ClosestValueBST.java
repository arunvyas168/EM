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

public class ClosestValueBST {
    public int closestValue(TreeNode root, double target) {
        //Keeps track of previous min
        int previousMin = Integer.MIN_VALUE;

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        //important condition
        while((!stack.isEmpty())||(current!=null)){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if((previousMin<=target)&&(target<=current.value)){
                if(Math.abs(previousMin-target)<=Math.abs(current.value-target)){
                    return previousMin;
                }else{
                    return current.value;
                }
            }
            // set previous min
            previousMin = current.value;

            current = current.right;
        }
        // this can be the last element in bst
        return previousMin;
    }
}
