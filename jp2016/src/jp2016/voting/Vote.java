package jp2016.voting;

public class Vote {
    private Candidate votedFor;
    
    public Vote(Candidate candidate) {
        votedFor = candidate;
    }
    
    public Candidate getResult() {
        return votedFor;
    }
    
}
