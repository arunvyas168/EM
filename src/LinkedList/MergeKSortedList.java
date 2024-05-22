package LinkedList;

/*
Merge K Sorted List

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/

/*
    SOLUTION:
        1. Use Priority queue, sorted by Node.value
        2. Input is List of Linkedlist
        3. Output is Head pointer
   Add all head in PQ
   Remove smallest and add to dummy head
   put the next element back in
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static Node mergeKSortedList(Node[] listOfNodes){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        //Populate PQ with just the 1st list node from each list
        for(Node listnode: listOfNodes){
            if(listnode!=null) {
                pq.add(listnode);
            }
        }
        while (!pq.isEmpty()){
            Node top = pq.poll();
            current.next = top;
            current = current.next;
            if(top.next!=null){
                pq.add(top.next);
            }
        }
        return dummyHead.next;

    }

    public static void main(String[] args){
        int[] arr1 = new int[] {1,4,5};
        Node list1 = ListUtil.constructLinkedList(arr1);
        int[] arr2 = new int[] {1,3,4};
        Node list2 = ListUtil.constructLinkedList(arr2);
        int[] arr3 = new int[] {2,6};
        Node list3 = ListUtil.constructLinkedList(arr3);
        Node[] listOfListNodes = new Node[] {list1, list2, list3};
        ListUtil.printList(mergeKSortedList(listOfListNodes));
    }
}
