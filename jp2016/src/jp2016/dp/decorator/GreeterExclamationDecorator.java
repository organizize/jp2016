package jp2016.dp.decorator;

public class GreeterExclamationDecorator implements Greeter {
    private Greeter greeter;
    
    public GreeterExclamationDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public String greet(String firstName, String lastName) {
        return greeter.greet(firstName, lastName) + "!!!";
    }

}
