package jp2016.dp.template;

public abstract class LithuanianGreeter extends Greeter {

    @Override
    public String getGreetingString() {
        return "Tebuna pasveikintas";
    }

    @Override
    public abstract String getGreetingEnding();
}
