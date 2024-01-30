import java.util.*;

class Node {
    String data;
    Node   next;
}

class LinkedList {
    Node head;
    Node tail;
    int size;
    LinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = null;
        this.size = 0;
    }
    public void insertFirst(String data) {
        if (this.size==0)
            this.head.data=data;
        else {
            Node temp = new Node();
            temp.data=this.head.data;
            temp.next=this.head.next;
            this.head.data=data;
            this.head.next=temp;
        }
        this.size++;
    }
    public String getData(int index) {
        Node temp = this.head;
        for (int i =0 ; i < index ; i++)
        {
            temp=temp.next;
        }
        return temp.data;
    }
    public void print() {
        Node temp = this.head;
        for (int i=0 ; i < this.size && temp.data != null ; i++) {
            System.out.print(temp.data);
            temp=temp.next;
            if (i+1 < this.size && temp.data != null)
                System.out.print(" -> ");
        }
    }
    public void doLinkedShuffle() {
        LinkedList firsthalf = new LinkedList();
        LinkedList secondhalf = new LinkedList();
        LinkedList tempList = this;
        for (int i=0 ; i <= (this.size-1)/2 ; i++) {
            firsthalf.insertFirst(tempList.head.data);
            tempList.head=tempList.head.next;
        }
        secondhalf=tempList;
        tempList= new LinkedList();
        if (size %2 == 0) {
            for (int i=0 ; i < this.size ; i++)
            {
                if (secondhalf.head != null) {
                    tempList.insertFirst(secondhalf.head.data);
                    secondhalf.head=secondhalf.head.next;
                }
                if (firsthalf.head != null) {
                    tempList.insertFirst(firsthalf.head.data);
                    firsthalf.head=firsthalf.head.next;
                }
            }
        } else {
            for (int i=0 ; i < this.size ; i++)
            {
                if (firsthalf.head != null) {
                    tempList.insertFirst(firsthalf.head.data);
                    firsthalf.head=firsthalf.head.next;
                }
                if (secondhalf.head != null) {
                    tempList.insertFirst(secondhalf.head.data);
                    secondhalf.head=secondhalf.head.next;
                }
            }
        }
        this.head=tempList.head;
    }
}

public class LinkedShuffle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();        // linkedList's size
        String dummy = input.nextLine(); // get the \n
        String s = input.nextLine();
        int m = input.nextInt();

        String[] numbers = s.split(" -> ");
        LinkedList ll = new LinkedList();
        for (int i=numbers.length-1 ; i >= 0  ; i--)
            ll.insertFirst(numbers[i]);

        for (int i=0 ; i < m; i++)
            ll.doLinkedShuffle();
        ll.print();
        
    }
}

