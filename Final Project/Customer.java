public class Customer {
    String name;
    float totalIncome;
    float totalExpense;

    LinkedList accounts;
    float accountedValue; // this value is not global and will only be filled in accounts list.
    public Customer() {
        totalIncome = 0.00f;
        totalExpense = 0.00f;
    }
}
