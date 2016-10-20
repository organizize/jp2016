package jp2016.dp.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyTester {

    public static void main(String[] args) {

        String firstName = "Jonas";
        String lastName = "Jonaitis";
        List<Greeter> greeters = new ArrayList<Greeter>();

        greeters.add(new Greeter(new LithuanianStartStrategy(), new DotEndStrategy()));
        greeters.add(new Greeter(new LithuanianStartStrategy(), new ExclamationEndStrategy()));
        greeters.add(new Greeter(new LithuanianStartStrategy(), new TripleExclamationEndStrategy()));
        greeters.add(new Greeter(new EnglishStartStrategy(), new DotEndStrategy()));
        greeters.add(new Greeter(new EnglishStartStrategy(), new ExclamationEndStrategy()));
        greeters.add(new Greeter(new EnglishStartStrategy(), new TripleExclamationEndStrategy()));

        for (Greeter greeter : greeters) {
            greeter.greet(firstName, lastName);
        }

    }

}
