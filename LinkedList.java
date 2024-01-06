public class LinkedList {
    class Node{
        String name;
        int value;
        Node next;

            Node(String name, int value){
                this.name = name;
                this.value = value;}
    }
private Node head;
private Node tail;
private int length;

public LinkedList(String name, int value){
    Node newNode = new Node(name, value);
    head = newNode;
    tail = newNode;
    length = 1;
}
public void printlist(){
    Node temp = head;
    while(temp != null){
    System.out.println("Name: " + temp.name + "Value: " + temp.value);
    temp = temp.next;}
}
public void append(String name, int value){
    Node newNode = new Node(name, value);
    if(length == 0){
        head = newNode;
        tail = newNode;
    } else{
        tail.next = newNode;
        tail = newNode;
    }
    length++;
}
public Node removeLast(){
    if(length == 0) return null;
    Node temp = head;
    Node pre = head;
    while(temp.next != null){
        pre = temp;
        temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length --;
    if(length == 0){
        head = null;
        tail = null;
    }
    return temp;
}
public void prepend(String name, int value){
    Node newNode = new Node(name, value);
    if(length == 0){
        head = newNode;
        tail = newNode;
    } else{
        newNode.next = head;
        head = newNode;
    }
    length ++;
}
public Node removeFirst(){
    if(length == 0) return null;
    Node temp = head;
    head = temp.next;
    temp.next = null;
    length --;
    if(length == 0){
        tail = null;
    }
    return temp;}

public Node getNode(int index){
    if(index < 0 || index >= length){
        return null;
    } else{
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
}
public boolean setNode(int index, String name, int value){
    Node temp = getNode(index);
    if(temp != null){
        temp.name = name;
        temp.value = value;
        return true;
    }
    return false;
}
public boolean insertNode(int index, String name, int value){
    if(index < 0 || index > length) return false;
    if(index == 0){
        prepend(name, value);
        return true;
    }
    if(index == length){
        append(name, value);
        return true;
    }
    Node newNode = new Node(name, value);
    Node temp = getNode(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length ++;
    return true;

    }
public Node removNode(int index){
    if(index < 0 || index >= length) return null;
    if(index == 0) return removeFirst();
    if(index == length-1) return removeLast();
    Node prev = getNode(index - 1);
    Node temp = prev.next;
    prev.next = temp.next;
    temp.next = null;
    length --;
    return temp;

}
public void reverse(){
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;
    for(int i = 0; i < length; i++){
        after = temp.next;
        temp.next = before;
        before = temp;
        temp = after;

    }
}
}
