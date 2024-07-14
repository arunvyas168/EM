package Tree;

/*
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
Note:
The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Example 1:
Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation:
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
*/


/*
    TLDR:
        Trick
            1. is we need to do POSTORDER
            2. Return 2 things -- cumilative sum and total subtree count
            3. We need rdepth+ldepth+1 for count and also store cumilative sum

*/

public class NodeEqualAvgSubTree {
    int count;
    public static class Pair{
        public int depth;
        public int cumilativeSum;
        public Pair(int depth, int cumilativeSum){
            this.depth= depth;
            this.cumilativeSum = cumilativeSum;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        averageOfSubtreeUtil(root);
        return count;
    }
    public Pair averageOfSubtreeUtil(TreeNode root){
        if(root==null){
            return new Pair(0, 0);
        }
        Pair lPair = averageOfSubtreeUtil(root.left);
        Pair rPair =  averageOfSubtreeUtil(root.right);
        int depth = lPair.depth+rPair.depth+1;
        int cumilativeSum = lPair.cumilativeSum + rPair.cumilativeSum +root.value;
        if((cumilativeSum/depth) == root.value){
            count++;
        }
        return new Pair(depth, cumilativeSum);
    }
}