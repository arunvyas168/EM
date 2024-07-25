package LinkedList;


/*
public class Node {
    int value;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
*/


public class InsertCircularSortedList {
    public Node insert(Node head, int key) {
        if (head == null) {
            Node newNode = new Node(key, null);
            newNode.next = newNode;     // circular list
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;

        do {
            if (prev.value <= key && key <= curr.value) {       // Case where we are able to find if node can go in between --> && is imp
                prev.next = new Node(key, curr);
                return head;
            } else if (prev.value > curr.value) {               // Case where we reached end/start of that circular linkedlist
                if (key >= prev.value || key <= curr.value) { // we have to check if this new value can become a last or fist node
                    prev.next = new Node(key, curr);
                    return head;
                }
            }

            prev = curr;                                    // if above cases are not solved we keep moving
            curr = curr.next;
        } while (prev != head);                             // end when prev is head again

        // Case 3).
        prev.next = new Node(key, curr);
        return head;
    }
}
