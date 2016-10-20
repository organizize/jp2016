package jp2016.dp.template;

public abstract class EnglishGreeter extends Greeter {

    @Override
    String getGreetingString() {
        return "Welcome";
    }

    @Override
    abstract String getGreetingEnding();

}
