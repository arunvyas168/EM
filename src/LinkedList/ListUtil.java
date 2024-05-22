package LinkedList;

public class ListUtil {
    public ListUtil(){
    }
    public static Node constructLinkedList(int[] arr){
        if(arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i=1; i<arr.length; i++){
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(Node list){
        Node current = list;
        while(current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
