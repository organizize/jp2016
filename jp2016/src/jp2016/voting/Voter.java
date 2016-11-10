package jp2016.voting;

import java.util.List;
import java.util.Random;

public class Voter extends Person {
    private static Random rand = new Random();
    
    public Voter(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Vote vote(List<Candidate> candidates) {
        return randomVote(candidates);
    }
    
    public Vote randomVote(List<Candidate> candidates) {
        return new Vote(candidates.get(rand.nextInt(candidates.size())));
    }

}
