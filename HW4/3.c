node* merge(node* nHead, node* mHead ) {
    node* previousNode=nHead; // just an assumption that nhead's value is lower.
    node* result=nHead;
    for (int i=0 ; i < m+n ; i++) {
        /* compare paires of n and m then acquire
         the lowest as a node to the new list
         and go on.
        */
        if (nHead->value < mHead->value) {
            if (nHead != previousNode)
                previousNode->next=nHead;
            nHead=nHead->next;
        } else {
            if (i==0)
                result=mHead;
            previousNode->next=mHead;
            mHead=mHead->next;
        }
    }
    return result;
}