import java.util.Scanner;

class Menu {
    public static void main() {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();        // number of commands
        String dummy = input.nextLine(); // get the \n
        Bank bank = new Bank();
        for (int i = 0; i < q; i++) {
            String command = input.nextLine();
            if (command.isEmpty()) {
                i--;
                continue; // Skip to the next iteration if the command is empty
            }
            switch (command.charAt(0)) {
                case '1':
                    bank.handleCommand1(command.substring(2));
                    break;
                case '2':
                    bank.handleCommand2();
                    break;
                case '3':
                    bank.handleCommand3();
                    break;
                case '4':
                    bank.handleCommand4(command.substring(2));
                    break;
                case '5':
                    bank.handleCommand5(command.substring(2));
                    break;
                case '6':
                    bank.handleCommand6(command.substring(2));
                    break;
                default:
                    i--;
                    break;
            }
        }
    }
}

public class Bank {
    LinkedList customers;

    public Bank() {
        this.customers = new LinkedList();
    }

    public static void main(String[] args) {
        Menu.main();
    }
    public void handleCommand1(String input) {
        // Handle command 1
        String[] nodes = input.split(" ");
        float value = Float.parseFloat(nodes[2]);

        Customer talabkar = customers.insertFirst(nodes[0]);
        Customer bedehkar = customers.insertFirst(nodes[1]);

        talabkar.totalOut += value;
        bedehkar.totalIn += value;

        talabkar.accounts.insertFirst(nodes[1]).accountedValue += value;
        bedehkar.accounts.insertFirst(nodes[0]).accountedValue -= value;
        System.out.println(customers.find(talabkar.name).name+" "+customers.find(bedehkar.name).name);
    }

    public String handleCommand2() {
        // Handle command 2
        String result = "";
        customers.print();
        return result;
    }

    public String handleCommand3() {
        // Handle command 3
        String result = "";
        return result;
    }

    public String handleCommand4(String input) {
        // Handle command 4
        String result = "";
        customers.find(input).accounts.print();
        return result;
    }

    public String handleCommand5(String input) {
        // Handle command 5
        String result = "";
        return result;
    }

    public String handleCommand6(String input) {
        // Handle command 6
        String result = "";
        return result;
    }
}