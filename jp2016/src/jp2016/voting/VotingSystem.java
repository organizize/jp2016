package jp2016.voting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp2016.voting.exceptions.AlreadyVotedException;

public class VotingSystem {

    private List<Candidate> candidates = new ArrayList<Candidate>();
    private Set<Voter> voters = new HashSet<Voter>();
    private List<Vote> votes = new ArrayList<Vote>();
    private Map<Candidate, Integer> results = new HashMap<Candidate, Integer>();
    private Candidate winner = null;

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        results.put(candidate, 0);
    }

    public void registerVoter(Voter voter) throws AlreadyVotedException {
        if (voters.contains(voter)) {
            throw new AlreadyVotedException(voter.toString());
        } else {
            voters.add(voter);
            acceptVote(voter.vote(candidates));
        }
    }

    public void countVotes() {
        votes
            .stream()
            .map(Vote::getResult)
            .forEach((Candidate candidate) -> results.merge(candidate, 1, (oldVal, newVal) -> oldVal + 1));
    }

    public void determineWinner() {
        int maxVotes = 0;
        for (Candidate candidate : candidates) {
            if (results.get(candidate) > maxVotes) {
                maxVotes = results.get(candidate);
                winner = candidate;
            }
        }

        // check to see if there is no draw
        for (Candidate candidate : candidates) {
            if (candidate != winner && results.get(candidate) == maxVotes) {
                winner = null;
                break;
            }
        }
    }
    
    private void acceptVote(Vote vote) {
        votes.add(vote);
    }
    
    public List<Candidate> getCandidateList() {
        return candidates;
    }

    public void printResults() {
        try (PrintWriter out = new PrintWriter(System.out)) {
            printResults(out);
        }
    }
    
    public void printResults(String s) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(s)){            
            printResults(out);
        }
    }
    
    public void printResults(PrintWriter out) {
        results.forEach((candidate, voteCount) -> out.format("%s: %d votes, %.2f%%\n", candidate, voteCount,
                (double) voteCount * 100 / votes.size()));
        out.format("\nWinner %s", (winner == null) ? "undetermined yet (draw)" : winner);
    }

}
