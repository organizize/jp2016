package jp2016.dp.decorator;

public class EnglishGreeter implements Greeter {

    @Override
    public String greet(String firstName, String lastName) {
        return "Welcome " + firstName + " " + lastName;
    }

}