package Tree;

/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor.
You should return the pointer to the smallest element of the linked list.
*/


/*
    TLDR:
        1. Sorted --> in-order traversal
        2. Keep First and Last Pointer
        3. Close loop of circular Linked list
*/


public class BSTSortedDoubleLinkedList {
    // The first node (smallest--left most)
    TreeNode first = null;
    // The Last node (largest--right most)
    TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null){
            return null;
        }
        // inorder traversal
        helper(root);

        // Closing the Circle of double linked list
        last.right = first;
        first.left = last;
        return first;
    }

    public void helper(TreeNode node) {
        // Already checked for null so check for not null
        if (node != null) {
            // Go to left most
            helper(node.left);

            // Current node ---> build the list
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                first = node;
            }
            // keep making last as current node as we build
            last = node;

            // go to right
            helper(node.right);
        }
    }
}
