node* sortAbsoluteSortedLinkedList (node* head) {
    node* result=head;
    node* previousNode=head;
    for (node* L=head ; L != NULL ; ) {
        // the iterations are done in if and else clauses
        if (L->value < 0){
            // iterate the list from first node up to end
            // put every negative node to the first of the list
            previousNode->next=L->next;
            node* temp = L->next;
            L->next = result;
            result=L;
            L=temp;
        }else {
            previousNode=previousNode->next;
            L=L->next;
        }
    }
    return result;
}