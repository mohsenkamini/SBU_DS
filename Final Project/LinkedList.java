public class LinkedList {
    Node head;
    Node tail;
    int size;

    LinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = null;
        this.size = 0;
    }
    public Node find(String name) {
        Node result = this.head;
        for (int i =0 ; i < this.size ; i++,result=result.next) {
            if (result.customer.name.equals(name)){
                return result;
            }
        }
        return null;
    }
    public Node insertFirst(String name) {
        Node result;
        if (this.size==0) {
            this.head.customer.name=name;
            result=this.head;
        }
        else {
            result = find(name);
            if (result == null) {
                Node temp = new Node();
                temp.customer.name=this.head.customer.name;
                temp.next=this.head.next;
                this.head.customer.name=name;
                this.head.next=temp;
                result=this.head;
            } else return result;
        }
        this.size++;
        return result;
    }
    public String getName(int index) {
        Node temp = this.head;
        for (int i =0 ; i < index ; i++)
        {
            temp=temp.next;
        }
        return temp.customer.name;
    }
    public void print() {
        Node temp = this.head;
        System.out.println("The list size is: "+this.size);
        for (int i=0 ; i < this.size ; i++) {
            System.out.print(temp.customer.name);
            temp=temp.next;
            if (i+1 < this.size)
                System.out.print(" -> ");
        }
    }
}

class Node {
    Customer customer;
    Node next;
    public Node () {
        this.customer = new Customer();
    }
}
