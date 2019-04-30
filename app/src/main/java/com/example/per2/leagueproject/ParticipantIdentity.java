package com.example.per2.leagueproject;

public class ParticipantIdentity {
    private Player player;
    private int ParticipantId;

    public ParticipantIdentity() {
    }

    @Override
    public String toString() {
        return "ParticipantIdentity{" +
                "player=" + player +
                ", ParticipantId=" + ParticipantId +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getParticipantId() {
        return ParticipantId;
    }

    public void setParticipantId(int participantId) {
        ParticipantId = participantId;
    }
}
