package jp2016.dp.decorator;

import java.util.ArrayList;
import java.util.List;

public class DecoratorTester {

    public static void main(String[] args) {

        String firstName = "Jonas";
        String lastName = "Jonaitis";

        List<Greeter> greeters = new ArrayList<Greeter>();

        Greeter ltGreeter = new LithuanianGreeter();
        Greeter enGreeter = new EnglishGreeter();

        greeters.add(ltGreeter);
        greeters.add(enGreeter);
        greeters.add(new GreeterExclamationDecorator(ltGreeter));
        greeters.add(new GreeterExclamationDecorator(enGreeter));
        greeters.add(new GreeterUppercaseDecorator(ltGreeter));
        greeters.add(new GreeterUppercaseDecorator(enGreeter));
        greeters.add(new GreeterExclamationDecorator(new GreeterUppercaseDecorator(ltGreeter)));
        greeters.add(new GreeterExclamationDecorator(new GreeterUppercaseDecorator(enGreeter)));
        greeters.add(new GreeterUppercaseDecorator(new GreeterExclamationDecorator(ltGreeter)));
        greeters.add(new GreeterUppercaseDecorator(new GreeterExclamationDecorator(enGreeter)));

        for (Greeter greeter : greeters) {
            System.out.println(greeter.greet(firstName, lastName));
        }

    }

}
