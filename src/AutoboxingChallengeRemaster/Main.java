package AutoboxingChallengeRemaster;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("someBank");

        bank.addNewCustomer("Pasha", 1000);
        bank.addNewCustomer("Dasha", 2000);


        bank.addTransaction(bank.getCustomer("Pasha"), 100.0);
        bank.addTransaction(bank.getCustomer("Pasha"), 20.0);
        bank.addTransaction(bank.getCustomer("Pasha"), -10.0);
        bank.addTransaction(bank.getCustomer("Pasha"), 8.0);
        bank.addTransaction(bank.getCustomer("Pasha"), 3.5);
        bank.addTransaction(bank.getCustomer("Pasha"), -23.16);

        bank.addTransaction(bank.getCustomer("Dasha"), -100.0);
        bank.addTransaction(bank.getCustomer("Dasha"), 20.0);
        bank.addTransaction(bank.getCustomer("Dasha"), -13.0);
        bank.addTransaction(bank.getCustomer("Dasha"), 8.0);
        bank.addTransaction(bank.getCustomer("Dasha"), 3.5);
        bank.addTransaction(bank.getCustomer("Dasha"), -23.16);

        bank.printStatement(bank.getCustomer("Pasha"));
        bank.printStatement(bank.getCustomer("Dasha"));







    }
}
