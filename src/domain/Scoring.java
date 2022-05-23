package domain;

public class Scoring {

    public int match;
    public int missMatch;
    public int gapsPenalty;

    public Scoring(int match, int missMatch, int gapsPenalty) {
        this.match = match;
        this.missMatch = missMatch;
        this.gapsPenalty = gapsPenalty;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getMissMatch() {
        return missMatch;
    }

    public void setMissMatch(int missMatch) {
        this.missMatch = missMatch;
    }

    public int getGapsPenalty() {
        return gapsPenalty;
    }

    public void setGapsPenalty(int gapsPenalty) {
        this.gapsPenalty = gapsPenalty;
    }

}
