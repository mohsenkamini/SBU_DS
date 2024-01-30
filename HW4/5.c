bool hasCircle(node* head) {
    for (node* L=head ; L != NULL ; L=L->next) {
        if (L->next == head->next)
        {
            L->next = null;
            return true;
        }
    }
    return false;
}
