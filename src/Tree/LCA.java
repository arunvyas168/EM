package Tree;

/*
    SOLUTION:
        TLDR: we go all the way to p and q and then start returning not-null
                If we see not null from both right and left returned back we can say thats the LCA

        1. base case return null if root is null;
        2. If we reach p or q return the root/node back
        3. Get current left
        4. Get current right
        5. If check for that condition if both are not null ---> return node;
        6. If both are null return null;
        7. otherwise return what ever is not null
*/

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
