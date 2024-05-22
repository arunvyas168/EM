package Tree;


/*
    SOLUTION:
        TLDR: If Node Lower than range go right <--> If Highr than range go left <---> If in range add

        1. Base case will return 0 --> node is null
        2. check if node value bigger than range --> bigger than high --> go left
        3. check if node value smaller than range --> smaller than low --> go right
        4. otherwise its in range so
                add (root value) + recursion of left and right

*/

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root==null){
            return 0;
        }

        if(root.value>high){
            return rangeSumBST(root.left, low, high);
        }
        if (root.value<low){
            return rangeSumBST(root.right, low, high);
        }
        return root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }
}
