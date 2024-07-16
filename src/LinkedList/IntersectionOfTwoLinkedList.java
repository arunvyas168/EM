package LinkedList;

/*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
*/


/*
        https://leetcode.com/problems/intersection-of-two-linked-lists/editorial/
        TLDR:
            Set pointer pA to point at headA.
            Set pointer pB to point at headB.
                    While pA and pB are not pointing at the same node:
                           If pA is pointing to a null, set pA to point to headB.
                           Else, set pA to point at pA.next.
                           If pB is pointing to a null, set pB to point to headA.
                           Else, set pB to point at pB.next.
            return the value pointed to by pA (or by pB; they're the same now).
*/


public class IntersectionOfTwoLinkedList {

    public Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;
        while(a!=b){
            if(a==null){
                a = headB;
            }else {
                a = a.next;
            }
            if(b==null){
                b = headA;
            }else {
                b = b.next;
            }
        }
        return a;
    }

}
