package Tree;


/*
    TLDR: We Just Traverse Tree and form numbers and add them

    1. Use an util where number is passed as 0
    2. It will check current nodes value and then append to number
    3. If we reach the end leaf --> (right and left null) --> we send final number back
    4. We have to add it recursively on left and right subtree

*/



public class SumRootLeaf {
    public int dfs(TreeNode root, int num){
        if(root==null){
            return 0;
        }
        num = num*10+root.value;
        if((root.left==null)&&(root.right==null)){
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}
