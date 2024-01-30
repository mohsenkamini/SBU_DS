main() {
    Queue q1 = new Queue();
    n = std_input();
    for (int i=1 ; i <= n ; i++ ) {
        q1.add(i);
        if (q1.isFull == 1)
            q1.emptyQueue();
    }
    q1.emptyQueue();
}
