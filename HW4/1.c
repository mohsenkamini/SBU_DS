struct node {
    int data;
    node* next;
}
node* mianeLinkedList (linkedlist ll) {
    node* result=ll.L;
    node* nextCandidate=ll.L->next;
    counter=0;
    for (node* i = ll.L ; i !=null ; i=i->next, counter=counter++%2) {
        if (counter == 1) {
            result=nextCandidate;
            nextCandidate=ll[result]->next;
        }
    }
    return result;
}