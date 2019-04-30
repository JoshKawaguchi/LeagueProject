package com.example.per2.leagueproject;

public class Mastery {
    private int masteryId;
    private int rank;

    public Mastery() {
    }

    @Override
    public String toString() {
        return "Mastery{" +
                "masteryId=" + masteryId +
                ", rank=" + rank +
                '}';
    }

    public int getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(int masteryId) {
        this.masteryId = masteryId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
