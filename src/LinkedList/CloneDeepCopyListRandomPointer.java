package LinkedList;

import java.util.HashMap;

/*
    Deep clone linked list which has random pointers connected
*/



/*
        TLDR:
            1. We will use 2 pass
            2. 1st pass:-->  copy node and save in hash map. HashMap<oldNode, newNode>
            3. 2nd pass:--> read map and point --> note to default to null
*/
public class CloneDeepCopyListRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node cloneRandomList(Node head) {
        HashMap<Node, Node> cloneMap = new HashMap<>();

        // create for 1st pass iteration
        Node old = head;
        // 1st Pass
        while(old!=null){
            // Iterate and copy and save in hash map
            Node copy = new Node(old.val);
            cloneMap.put(old, copy);
            old = old.next;
        }

        // create for 2nd Pass
        Node curr = head;
        // 2nd pass
        while(curr!=null){
            Node copy = cloneMap.get(curr);
            // defaulting to null in case any next is pointing to null
            copy.next = cloneMap.getOrDefault(curr.next, null);
            copy.random = cloneMap.getOrDefault(curr.random, null);
            curr = curr.next;
        }

        // returning the head of cloned node from hash map
        return cloneMap.get(head);
    }
}
