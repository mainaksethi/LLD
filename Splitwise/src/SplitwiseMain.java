import java.util.*;

public class SplitwiseMain {

    public static void main(String[] args) {
        new SplitwiseMain().test();
    }

    public void test() {
        List<User> userList = new ArrayList<>();
        User userA = new User("UserA");
        User userB = new User("UserB");
        User userC = new User("UserC");
        userList.add(userA);
        userList.add(userB);
        userList.add(userC);
        SplitWiseManager splitWiseManager = new SplitWiseManager(userList, new SimpleSettlementStrategy());
        splitWiseManager.addTransaction(new Transaction(userA, userB, new Amount(100, "Rupees")));
        splitWiseManager.addTransaction(new Transaction(userB, userC, new Amount(50, "Rupees")));
        List<Transaction> finalTransactions = splitWiseManager.getFinalTransactions();
        for (Transaction t: finalTransactions) {
            System.out.println("From: " + t.from.name + ", To: " + t.to.name + ", Amount: " + t.amount);
        }
        return;
    }

    class SplitWiseManager {

        private List<User> userList;

        private SettlementStrategy settlementStrategy;

        private ArrayList<Transaction> ledger = new ArrayList<>();

        public SplitWiseManager(List<User> userList,
                                SettlementStrategy settlementStrategy) {
            this.settlementStrategy = settlementStrategy;
            this.userList = userList;
        }

        public List<Transaction> getFinalTransactions() {
            return settlementStrategy.getFinalSettlement(ledger);
        }

        public void addTransaction(Transaction transaction) {
            ledger.add(transaction);
        }
    }

    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }
    }

    class Transaction {
        User from;
        User to;
        Amount amount;

        public Transaction(User from, User to, Amount amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }
    }

    class Amount {
        private Integer denomination;
        private String currency;

        public Amount(Integer denomination, String currency) {
            this.denomination = denomination;
            this.currency = currency;
        }

        @Override
        public String toString() {
            return denomination.toString() + " " + currency;
        }
    }

    private interface SettlementStrategy {
        List<Transaction> getFinalSettlement(ArrayList<Transaction> transactionList);
    }

    private class SimpleSettlementStrategy implements SettlementStrategy {

        public List<Transaction> getFinalSettlement(ArrayList<Transaction> transactionList) {
            Map<User, Integer> amountMap = new HashMap<>();
            for (Transaction t: transactionList) {
                amountMap.putIfAbsent(t.from, 0);
                amountMap.putIfAbsent(t.to, 0);
                amountMap.put(t.from, amountMap.get(t.from) - t.amount.denomination);
                amountMap.put(t.to, amountMap.get(t.to) + t.amount.denomination);
            }
            // settlement strategy
            ArrayList<Pair> positiveEntries = new ArrayList<>();
            ArrayList<Pair> negativeEntries = new ArrayList<>();
            for (Map.Entry<User, Integer> entry : amountMap.entrySet()) {
                if (entry.getValue() > 0 ) {
                    positiveEntries.add(new Pair(entry.getKey(), entry.getValue()));
                } else {
                    negativeEntries.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            positiveEntries.sort((o1, o2) -> o1.amount > o2.amount ? 1 : -1);
            negativeEntries.sort((o1, o2) -> o1.amount < o2.amount ? 1: -1);
            Integer positiveEntriesStart = 0, negativeEntriesStart = 0;
            List<Transaction> finalTransactions = new ArrayList<>();
            // TODO: handle persons which are settled transactions
            while(!(positiveEntriesStart == positiveEntries.size() &&
                  negativeEntriesStart == negativeEntries.size())) {
                Pair positiveEntry = positiveEntries.get(positiveEntriesStart);
                Pair negativeEntry = negativeEntries.get(negativeEntriesStart);
                Integer settlingAmount = Math.min(positiveEntry.amount,
                        Math.abs(negativeEntry.amount));
                positiveEntry.amount = positiveEntry.amount - settlingAmount;
                negativeEntry.amount = negativeEntry.amount + settlingAmount;
                if (positiveEntry.amount == 0) {
                    positiveEntriesStart++;
                } if (negativeEntry.amount == 0) {
                    negativeEntriesStart++;
                }
                finalTransactions.add(new Transaction(negativeEntry.user, positiveEntry.user, new Amount(settlingAmount, "Rupees")));
            }
            return finalTransactions;
        }
    }

    private class Pair {
        User user;
        Integer amount;

        public Pair(User user, Integer amount) {
            this.user = user;
            this.amount = amount;
        }
    }
}

/**
 * 1. Add User A needs to pay User B.
 * 2. Show final balances.
 */