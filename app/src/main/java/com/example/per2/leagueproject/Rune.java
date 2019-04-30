package com.example.per2.leagueproject;

public class Rune {
    private int runeId;
    private int tank;

    public Rune() {
    }

    @Override
    public String toString() {
        return "Mastery{" +
                "runeId=" + runeId +
                ", tank=" + tank +
                '}';
    }

    public int getRuneId() {
        return runeId;
    }

    public void setRuneId(int runeId) {
        this.runeId = runeId;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }
}
