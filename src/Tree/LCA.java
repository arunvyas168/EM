package Tree;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if ((root.value == p.value)||(root.value == q.value)){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if((left != null)&&(right !=null)){
            return root;
        }
        if ((left==null)&&(right==null)){
            return null;
        }
        return left !=null ? left : right;
    }
}
