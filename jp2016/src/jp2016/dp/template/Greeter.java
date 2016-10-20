package jp2016.dp.template;

public abstract class Greeter {

    public void greet(String first_name, String last_name) {
        System.out.println(getGreetingString() + " " + first_name + " " + last_name + getGreetingEnding());
    }

    abstract String getGreetingString();

    abstract String getGreetingEnding();

}
