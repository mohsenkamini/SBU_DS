public class Customer {
    String name;
    float totalIn;
    float totalOut;

    LinkedList accounts;
    float accountedValue; // this value is not global and will only be filled in accounts list.
    public Customer() {
        totalIn = 0.00f;
        totalOut = 0.00f;
    }
}
