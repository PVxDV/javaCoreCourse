package AutoboxingChallengeRemaster;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    public void addNewCustomer(String customerName, double initialDeposit) {
        if (getCustomer(customerName) == null) {
            var customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
        }
    }

    public Customer getCustomer (String customerName) {
        for (var customer: customers) {
            if (customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addTransaction(Customer customer, double transaction) {
        customer.transactions().add(transaction);
    }

    public void printStatement(Customer customer) {
        System.out.printf("List of transactions by %s :%n", customer.name());
        for(double d: customer.transactions()) {
            System.out.printf("$%10.2f (%s)%n", d, d<0 ? "debit" : "credit");
        }
    }
}
