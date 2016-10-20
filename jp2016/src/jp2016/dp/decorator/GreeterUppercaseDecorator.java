package jp2016.dp.decorator;

public class GreeterUppercaseDecorator implements Greeter {
    private Greeter greeter;

    public GreeterUppercaseDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public String greet(String firstName, String lastName) {
        return greeter.greet(firstName, lastName).toUpperCase();
    }

}
