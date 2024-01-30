public class LinkedList {
    Node head;
    Node tail;
    int size;

    LinkedList() {
        this.head = new Node();
        this.tail = this.head;
        this.head.next = null;
        this.size = 0;
    }
    public Customer find(String name) {
        Node result = this.head;
        for (int i = 0; i < this.size; i++, result = result.next) {
            if (result.customer.name.equals(name)) {
                return result.customer;
            }
        }
        return null;
    }

    public Customer insertLast(String name) {
        Customer insertedCustomer;
        if (this.size == 0) {
            this.head.customer.name = name;
            insertedCustomer = this.head.customer;
            insertedCustomer.accounts = new LinkedList();
        } else {
            Customer foundCustomer = find(name);
            if (foundCustomer == null) {
                Node temp = new Node();
                temp.customer.name = name;
                temp.next = null;
                this.tail.next = temp;
                this.tail = temp;
                insertedCustomer = this.tail.customer;
                insertedCustomer.accounts = new LinkedList();
            } else {
                insertedCustomer = foundCustomer;
                return insertedCustomer;
            }
        }
        this.size++;
        return insertedCustomer;
    }
    public Customer insertFirst(String name) {
        Customer insertedCustomer;
        if (this.size == 0) {
            this.head.customer.name = name;
            insertedCustomer = this.head.customer;
            insertedCustomer.accounts = new LinkedList();
        } else {
            Customer foundCustomer = find(name);
            if (foundCustomer == null) {
                Node temp = new Node();
                temp.customer = this.head.customer;
                temp.next = this.head.next;
                this.head.customer = new Customer();
                this.head.customer.name = name;
                this.head.next = temp;
                insertedCustomer = this.head.customer;
                insertedCustomer.accounts = new LinkedList();
        } else {
                insertedCustomer = foundCustomer;
                return insertedCustomer;
            }
        }
        this.size++;
        return insertedCustomer;
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
        System.out.println("");
    }
}

class Node {
    Customer customer;
    Node next;
    public Node () {
        this.customer = new Customer();
    }
}
