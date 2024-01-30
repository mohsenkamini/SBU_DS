import java.util.*;

class Node {
    int data;
    Node next;
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
    public void insertFirst(int data) {
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
    public void insertLast(int data) {
        if (this.size==0)
            this.head.data=data;
        else {
            Node temp = new Node();
            temp.data=data;
            temp.next=null;
            this.tail.next=temp;
        }
        this.size++;
    }
    public int removeFirst() {
        if (this.size==0) {
            System.out.println("Empty");
            return -1;
        }
        else{
            int result = this.head.data;
            this.head=this.head.next;
            size--;
            return result;
        }
    }
    public int getFirst() {
        if (this.size==0) {
            System.out.println("Empty");
            return -1;
        }
        else
            return this.head.data;
    }
}



// class Queue {
//     private int[] queueArray;
//     private int front;
//     private int rear;
//     private int capacity;

//     public Queue(int capacity) {
//         queueArray = new int[capacity];
//         this.capacity = capacity;
//         front=0;
//         rear = 0;
//     }
//     public void add(int data) {
//         if (rear == capacity - 1) {
//             System.out.println("Queue is full");
//         }
//         this.queueArray[this.rear++] = data;
//     }

//     public int remove() {
//         if (rear == front) {
//             System.out.println("Queue is Empty");
//         }
//         return this.queueArray[this.front++];
//     }


// }

class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        stackArray = new int[capacity];
        this.capacity = capacity;
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public void print() {
        for (int i=0 ; i < this.capacity ; i++)
            System.out.println(this.pop());
    }
}

public class DoughYaNoushabe {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] values = s.replaceAll("\\[|\\]|\\s", "").split(",");
        
        // Convert the strings to integers
        LinkedList students = new LinkedList();
        for (int i = values.length-1; i >= 0; i--) {
            students.insertFirst(Integer.parseInt(values[i]));
        }
        
        String d = input.nextLine();
        values = d.replaceAll("\\[|\\]|\\s", "").split(",");
        
        // Convert the strings to integers
        Stack drinks = new Stack(values.length);
        for (int i = values.length-1; i >= 0; i--) {
            drinks.push(Integer.parseInt(values[i]));
        }
        boolean flag = false;
        for (int i=0 ; i< students.size ;i++) {
            if (drinks.top() == students.getFirst()) {
                students.removeFirst();
                flag = true;
            }
            else {
                students.insertLast(students.removeFirst());
            }
            if (!flag && i == students.size-1)
                System.out.println( students.size);
            if (flag && i == students.size-1)
            {
                flag = false;
                i=0;
            }
        }

    }
}
