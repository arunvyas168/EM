package M;

import java.util.HashMap;

/*
    1. Have double linked list Node class with key and value
    2. Have hash map to locate node for given Key
    3. as part of get and put we take that node and add to head
*/


class Node{
    int value;
    int key;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {
    int capacity;
    Node head;
    Node end;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        }else {
            head = n.next;
        }
        if (n.next != null){
            n.next.prev = n.prev;
        }else {
            end = n.prev;
        }
    }

    public void setHead(Node n){
        n.next = head;
        if(head!=null){
            head.prev = n;
        }
        head = n;
        if(end==null){
            end = head;
        }
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node myNode = map.get(key);
        int value = myNode.value;
        remove(myNode);
        setHead(myNode);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else {
            Node created = new Node(key,value);
            if(map.size()>=this.capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            }else {
                setHead(created);
            }
            map.put(key,created);
        }
    }
}
