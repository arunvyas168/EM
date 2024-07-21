package Tree;
/*
You are given two binary trees root1 and root2.
Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
Return the merged tree.
Note: The merging process must start from the root nodes of both trees.
*/



/*
        TLDR:
            1. Do postorder
            2. Return type has to be TreeNode
            3. Traverse at same time and overwrite t1
*/
public class MergeBinaryTrees {
    public TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        // base cases
        if (tree1 == null)
            return tree2;
        if (tree2 == null)
            return tree1;

        // set current value
        tree1.value = tree1.value+ tree2.value;

        // recursion
        tree1.left = mergeTrees(tree1.left, tree2.left);
        tree1.right = mergeTrees(tree1.right, tree2.right);

        // return tree1 root
        return tree1;
    }
}
