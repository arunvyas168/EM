package Tree;



/*
        TLDR:
            Have global diameter
            Initialize to 0 and find longest path updating diameter
            diameter = max of ldepth or rdepth
            always return max +1 of ldepth and rdepth
*/


public class DiameterTree {
    int diameter;
    public int findDiameterOfTree(TreeNode root){
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    public int longestPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int ldepth = longestPath(root.left);
        int rdepth = longestPath(root.right);

        diameter = Math.max(diameter, ldepth+rdepth);

        return Math.max(ldepth, rdepth)+1;
    }
}
