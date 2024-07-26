package Tree;

/*

    SOLUTION:  ------ No need of recursion
        TLDR: Node bigger than both --> go left,
              Node smaller than both --> go right
              othersie that's the answer

         1. Take root node as current
         2. Traverse till its not null while(current!=null)
         3. If value < both left and right --> current =  current.left;
         4. If value > both left and right --> current =  current.right;
         5. else return current
         if not found return null
*/


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
