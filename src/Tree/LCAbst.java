package Tree;

public class LCAbst {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(current!=null){
            if((p.value>current.value)&&(q.value>current.value)){
                current = current.right;
            }else if((p.value< current.value)&&(q.value<current.value)){
                current = current.left;
            }
            else{
                return current;
            }
        }
        return null;
    }
}
