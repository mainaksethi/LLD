/**
 * This is made to incorporate Percentage-Split, Equal-Split kind of scenarios.
 *
 * Thought:
 * 1. There will be split object which will return list of transactions.
 * 2. These list of transactions will be leveraged by Settling Strategy to return final set of transactions.
 */
public class SplitwiseManager {

    private SettlingStrategy settlingStrategy;

    SplitwiseManager(SettlingStrategy settlingStrategy) {

    }

    public void addSplit(Split s) {
    }

}


public class SettlingStrategy {
    addSplit(Split s);

    List<Transactions> getFinalTransactions();
}


public class SimplifiedSettlingStrategy implements SettlingStrategy {

    List<Transactions> getFinalTransactions();

}


public class Transaction {
    private User from;

    private User to;

    private Amount amount;
}


public class Amount {
    private Integer value;
    private Currency currency;
}

public enum Currency {
    Dollar,
    Rupees;
}

public class Split {

    List<Transactions> getTransactions();
}

public class EqualSplit extends Split {

    public Split(User paidBy, Amount amount, List<Users> splitAmong, MetaInformation otherMetadata) {

    }

}

public class PercentageSplit extends Split {

    public Split(User paidBy, Amount amount, Map<User, Integer> splitAmongWithPercentage, MetaInformation otherMetadata) {

    }

    List<Transactions> getTransactions();

}