package AutoboxingChallengeRemaster;

import java.util.ArrayList;
import java.util.Locale;

public record Customer(String name, ArrayList<Double> transactions) {

    public Customer(String name, double initialDeposit) {
        this(name.toUpperCase(Locale.ROOT), new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}
