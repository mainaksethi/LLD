// A simple pattern which can be leveraged in interviews

public interface Strategy {
    public void execute();
}

public class StrategyA implements Strategy {
    public void execute() {

    }
}

public class StrategyB implements Strategy {
    public void execute() {

    }
}

public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        return strategy.execute();
    }
}

public static void main() {

    Context context = new Context();
    StrategyA strategyA = new StrategyA();
    context.setStrategy(StrategyA);
    context.execute();
}