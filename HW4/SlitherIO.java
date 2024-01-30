import java.util.*;

class Node {
    int data;
    Node   next;
}

class LinkedList {
    // TODO: You must implement the data structure yourself 
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
    public int getData(int index) {
        Node temp = this.head;
        for (int i =0 ; i < index ; i++)
        {
            temp=temp.next;
        }
        return temp.data;
    }
    public void print() {
        Node temp = this.head;
        for (int i=0 ; i < this.size ; i++) {
            System.out.print(temp.data);
            temp=temp.next;
            if (i+1 < this.size)
                System.out.print(" -> ");
        }
    }
    public void addAll(int[] array) {
        for (int i=array.length-1 ; i >=0 ; i--) {
            this.insertFirst(array[i]);
        }
    }
}

public class SlitherIO {
    public static int[][] playCircleOfDeath(int r, int c, Node head) {
        // TODO: Solve the problem here
        // traverse the result array in a spiral way
        // and add the head.data to it
        int[][] result = new int[r][c];
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int direction = 0; // 0: left to right, 1: top to bottom, 2: right to left, 3: bottom to top
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    result[top][i]=head.data;
                    head=head.next;
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    result[i][right]=head.data;
                    head=head.next;
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i]=head.data;
                    head=head.next;
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left]=head.data;
                    head=head.next;
                }
                left++;
            }

            direction = (direction + 1) % 4;
        }
       return result;
    }

    public static void main(String[] args) {
        // Take input and give output here
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();        // rows
        int c = input.nextInt();        // columns
        String dummy = input.nextLine(); // get the \n
        String s = input.nextLine();
        String[] numbers = s.split(" ");
        int[] array = new int[r*c];
        for (int i=0 ; i < numbers.length;i++)
            array[i]=Integer.parseInt(numbers[i]);
        for (int i=numbers.length ; i < r*c ; i++) {
            array[i]=-1;
        }
        
        LinkedList ll = new LinkedList();
        ll.addAll(array);

        int[][] result = playCircleOfDeath(r, c, ll.head);

        for (int i=0 ;i< r; i++) {
            for (int j=0 ; j< c; j++){
                System.out.print(result[i][j]);
                if (j+1<c)
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}