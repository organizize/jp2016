package jp2016.dp.strategy;

public class Greeter {
    private GreeterStartStrategy startStrategy;
    private GreeterEndStrategy endStrategy;

    public Greeter(GreeterStartStrategy startStrategy, GreeterEndStrategy endStrategy) {
        this.startStrategy = startStrategy;
        this.endStrategy = endStrategy;
    }

    public void greet(String first, String last) {
        System.out.format("%s %s %s%s\n", startStrategy.getStartString(), first, last, endStrategy.getEndString());

    }
}
