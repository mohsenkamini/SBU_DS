import java.beans.Customizer;
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
                case '7':
                    bank.handleCommand7();
                    break;
                case '8':
                    bank.handleCommand8(command.substring(2));
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
    private String nameOf2; // max in - out
    private float valueOf2; // max in - out

    private String nameOf3; // min in - out
    private float valueOf3; // min in - out

    public Bank() {
        this.customers = new LinkedList();
    }

    public static void main(String[] args) {
        Menu.main();
    }
    public void handleInOutDifference (Customer customer) {
        customer.difference = customer.totalIn - customer.totalOut;
        if (customer.difference > this.valueOf2){
            this.valueOf2=customer.difference;
            this.nameOf2=customer.name;
        } else if (customer.difference == this.valueOf2 && this.nameOf2 != null){
            if (customer.name.compareTo(this.nameOf2) < 0) {
                this.valueOf2=customer.difference;
                this.nameOf2=customer.name;
            }
        } else if (customer.name.equals(this.nameOf2)) {
            this.nameOf2=null;
            this.valueOf2=-1;
        }

        if (customer.difference < this.valueOf3){
            this.valueOf3=customer.difference;
            this.nameOf3=customer.name;
        } else if (customer.difference == this.valueOf3 && this.nameOf3 != null){
            if (customer.name.compareTo(this.nameOf3) < 0) {
                this.valueOf3=customer.difference;
                this.nameOf3=customer.name;
            }
        } else if (customer.name.equals(this.nameOf3)) {
            this.nameOf3=null;
            this.valueOf3=1;
        }
    }
    public void calclateMinMax () {
        float max=-1;
        String maxName=null;
        float min=1;
        String minName=null;
        Node index = customers.head;
        for (int i=0 ; i < customers.size ; i++,index=index.next) {
            if (max<index.customer.difference) {
                maxName=index.customer.name;
                max=index.customer.difference;
            }
            if (min>index.customer.difference) {
                minName=index.customer.name;
                min=index.customer.difference;
            }
        }
        if (max > 0) {
            this.valueOf2=max;
            this.nameOf2=maxName;
        }
        else {
            this.valueOf2=-1;
            this.nameOf2=null;
        }
        if (min < 0){
            this.valueOf3=min;
            this.nameOf3=minName;
        }
        else {
            this.valueOf2=1;
            this.nameOf2=null;
        }
    }
    public void handleCommand1(String input) {
        // Handle command 1
        String[] nodes = input.split(" ");
        float value = Float.parseFloat(nodes[2]);

        Customer talabkar = customers.insertFirst(nodes[0]);
        Customer bedehkar = customers.insertFirst(nodes[1]);

        talabkar.totalOut += value;
        bedehkar.totalIn += value;
        handleInOutDifference(talabkar);
        handleInOutDifference(bedehkar);

        talabkar.accounts.insertFirst(nodes[1]).accountedValue += value;
        bedehkar.accounts.insertFirst(nodes[0]).accountedValue -= value;
        System.out.println(customers.find(talabkar.name).totalOut+" "+customers.find(bedehkar.name).totalOut);
    }

    public void handleCommand2() {
        // Handle command 2
        if (this.valueOf2 < 0)
            calclateMinMax();
        System.out.println(this.nameOf2+this.valueOf2);
    }

    public void handleCommand3() {
        // Handle command 3
        if (this.valueOf3 > 0)
            calclateMinMax();
        System.out.println(this.nameOf3+this.valueOf3);
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
    public String handleCommand7() {
        // Handle command 7
        String result = "";
        customers.print();
        return result;
    }
    public String handleCommand8(String input) {
        // Handle command 8
        String result = "";
        customers.find(input).accounts.print();
        return result;
    }

}