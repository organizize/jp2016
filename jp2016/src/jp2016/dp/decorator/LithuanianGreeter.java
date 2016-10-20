package jp2016.dp.decorator;

public class LithuanianGreeter implements Greeter {

    @Override
    public String greet(String firstName, String lastName) {
        return "Tebuna pasveikintas " + firstName + " " + lastName;
    }

}
