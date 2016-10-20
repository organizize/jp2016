package jp2016.dp.strategy;

public class ExclamationEndStrategy implements GreeterEndStrategy {

    @Override
    public String getEndString() {
        return "!";
    }

}
