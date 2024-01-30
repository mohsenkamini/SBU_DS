Node {
    int data;
    Node right;
    Node left;
    Node parent;

}

firstNext(Node root, int x) {
    if (root.data == null) {
        print("empty");
    }
    if (x == root.data)
        return root.data;
    
    if (x < root.data)
        if (root.left == null)
            return root.data;
        else
            return firstNext(root.left, key);
    else if (x > root.data)
        if (root.right == null)
            print ("doesn't exist");
        else
            return firstNext(root.right, key);
    return root;
}