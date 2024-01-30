
class Node {
    int data;
    OpNode next;
}

class OpNode {
    char operator;
    Node   next;
    char[] priorities;
}
class Operation {
    Node n1,n2;
    OpNode operator;
    Operation(Node n1,Node n2, OpNode operator) {
        this.n1=n1;
        this.n2=n2;
        this.operator=operator;
    }
    public static Node calculate(Operation op) {
        Node result = new Node();
        // do calculations
        return result;
    }
}
class calculatingLinkedList {
    // TODO: You must implement the data structure yourself 
    Operation head;
    Node result;
    calculatingLinkedList(Operation head) {
        this.head = head;
    }
    public void insertFirst(Operation newOp) {
        // add ops here
    }
    public Node calculate() {
        Node result;
        // if there are no head.operators return head.n1
        // store operators from each operation,
        // calculate the results of that operation,
        // connect the before and after operations to the results of this operation
        // if there are no other operations to be connected, just have n1
    }
}
