package LinkedList;

/*
Merge K Sorted List

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
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
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static ListNode mergeKSortedList(ListNode[] listOfListNodes){
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        //Populate PQ with just the 1st list node from each list
        for(ListNode listnode: listOfListNodes){
            if(listnode!=null) {
                pq.add(listnode);
            }
        }
        while (!pq.isEmpty()){
            ListNode top = pq.poll();
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
        ListNode list1 = ListUtil.constructLinkedList(arr1);
        int[] arr2 = new int[] {1,3,4};
        ListNode list2 = ListUtil.constructLinkedList(arr2);
        int[] arr3 = new int[] {2,6};
        ListNode list3 = ListUtil.constructLinkedList(arr3);
        ListNode[] listOfListNodes = new ListNode[] {list1, list2, list3};
        ListUtil.printList(mergeKSortedList(listOfListNodes));
    }
}
