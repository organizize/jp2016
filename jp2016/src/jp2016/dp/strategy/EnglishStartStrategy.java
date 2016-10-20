package jp2016.dp.strategy;

public class EnglishStartStrategy implements GreeterStartStrategy {

    @Override
    public String getStartString() {
        return "Welcome";
    }

}
