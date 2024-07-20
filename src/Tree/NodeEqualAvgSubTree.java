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
            1. POSTORDER Traversal
            2. Keep track of depth and cumulative sum Pair(Depth, cumilativeSum)
            3. Util Return Pair object
*/

public class NodeEqualAvgSubTree {

    // Define The pair --> Easy to keep track of depth and cumilativeSum
    public static class Pair{
        public int depth;
        public int cumilativeSum;
        public Pair(int depth, int cumilativeSum){
            this.depth= depth;
            this.cumilativeSum = cumilativeSum;
        }
    }

    /*------------function------------------*/
    // Global count will be modified by util
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        averageOfSubtreeUtil(root);
        return count;
    }

    /*--------UTIL------*/
    // return Pair
    public Pair averageOfSubtreeUtil(TreeNode root){
        // if null return Pair with 0,0 --> sum is 0 and depth is 0
        if(root==null){
            return new Pair(0, 0);
        }

        // Post order --> get Pair object with sum and depth
        Pair lPair = averageOfSubtreeUtil(root.left);
        Pair rPair =  averageOfSubtreeUtil(root.right);

        // Calculate depth, sum and average
        int depth = lPair.depth+rPair.depth+1;
        int cumilativeSum = lPair.cumilativeSum + rPair.cumilativeSum +root.value;

        // if cumilativeSum/depth = root.value --> increment counter
        if((cumilativeSum/depth) == root.value){
            count++;
        }
        // finally return Pair with value----> post order so return this finally
        return new Pair(depth, cumilativeSum);
    }
}