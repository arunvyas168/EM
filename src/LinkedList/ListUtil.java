package LinkedList;

public class ListUtil {
    public ListUtil(){
    }
    public static ListNode constructLinkedList(int[] arr){
        if(arr.length==0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i=1; i<arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode list){
        ListNode current = list;
        while(current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
