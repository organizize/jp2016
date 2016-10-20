package jp2016.dp.template;

import java.util.ArrayList;
import java.util.List;

public class TemplateTester {

    public static void main(String[] args) {

        String firstName = "Jonas";
        String lastName = "Jonaitis";

        List<Greeter> greeters = new ArrayList<Greeter>();
        greeters.add(new EnglishGreeterWithDotEnding());
        greeters.add(new EnglishGreeterWithExclamationEnding());
        greeters.add(new EnglishGreeterWithTripleExclamationEnding());
        greeters.add(new LithuanianGreeterWithDotEnding());
        greeters.add(new LithuanianGreeterWithExclamationEnding());
        greeters.add(new LithuanianGreeterWithTripleExclamationEnding());

        for (Greeter greeter : greeters) {
            greeter.greet(firstName, lastName);
        }
    }

}
