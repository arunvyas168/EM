package Tree;


/*
    TLDR:

        1. We need to pass number computed at each level to leaf
        2. Once leaf is reached return the number
        3. At top level we add

    1. Use util and pass number as 0
    2. compute number = (number*10)+value
    3. if leaf noad return number;
    4. Else call dfs and add the return value
*/



public class SumRootLeaf {

    // Main Fnction
    public int sumNumbers(TreeNode root) {
        // most imp to understand to send 0 (10*0 = 0)
        return dfs(root, 0);
    }

    // Helper function
    public int dfs(TreeNode root, int num){
        if(root==null){
            return 0;
        }

        // compute value
        num = num*10+root.value;

        // return if leaf node
        if((root.left==null)&&(root.right==null)){
            return num;
        }

        // Add left and right subtree to get sum
        return dfs(root.left, num) + dfs(root.right, num);
    }
}
