package com.example.per2.leagueproject;

import java.util.List;

public class MatchHistory {
    private List<Matches> matches;
    private int totalGames;
    private int startIndex;
    private int endIndex;


    public MatchHistory() {
    }

    @Override
    public String toString() {
        return "MatchHistory{" +
                "matches=" + matches +
                ", totalGames=" + totalGames +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                '}';
    }

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

}
