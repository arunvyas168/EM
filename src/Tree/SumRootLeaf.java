package Tree;

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
