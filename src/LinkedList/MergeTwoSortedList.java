package LinkedList;

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
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

    public static void main(String args[]){
        int[] arr1 = new int[] {1,2,4};
        ListNode list1 = ListUtil.constructLinkedList(arr1);
        int[] arr2 = new int[] {1,3,4};
        ListNode list2 = ListUtil.constructLinkedList(arr2);
        ListNode result = mergeTwoLists(list1, list2);
        ListUtil.printList(result);
    }
}


