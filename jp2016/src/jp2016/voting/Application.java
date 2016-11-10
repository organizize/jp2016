package jp2016.voting;

import java.io.IOException;

import jp2016.voting.exceptions.AlreadyVotedException;

public class Application {
    static final int NUM_CANDIDATES = 4;
    static final int NUM_VOTERS = 50;

    public static void main(String[] args) {

        VotingSystem votingSystem = new VotingSystem();

        for (int i = 0; i < NUM_CANDIDATES; i++) {
            votingSystem.addCandidate(new Candidate("Kandidatas", "#" + i));
        }

        for (int i = 0; i < NUM_VOTERS; i++) {
            try {
                votingSystem.registerVoter(new Voter("Rinkejas", "#" + i));
            } catch (AlreadyVotedException e) {
                System.err.println(e.toString());
            }
        }

//        pabandom nucheatint sistema
        Voter homer = new Voter("Homer", "Simpson");
        for (int i = 0; i < 5; i++) {
            try {
                votingSystem.registerVoter(homer);
            } catch (AlreadyVotedException e) {
                System.err.println(e.toString());
            }
        }

        votingSystem.countVotes();
        votingSystem.determineWinner();
        votingSystem.printResults();
        try {
            votingSystem.printResults("results.txt");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        
        
    }
}
