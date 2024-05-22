package LinkedList;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/
public class MergeTwoSortedList {

    public static Node mergeTwoLists(Node list1, Node list2){
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        while((list1!=null)&&(list2!=null)){
            if(list1.value<list2.value){
                current.next = list1;
                list1 = list1.next;
            }else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1==null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        int[] arr1 = new int[] {1,2,4};
        Node list1 = ListUtil.constructLinkedList(arr1);
        int[] arr2 = new int[] {1,3,4};
        Node list2 = ListUtil.constructLinkedList(arr2);
        Node result = mergeTwoLists(list1, list2);
        ListUtil.printList(result);
    }
}


