package com.example.per2.leagueproject;

public class Player {
    private String currentPlatformId;
    private String summonerName;
    private String matchHistoryUrl;
    private String platformId;
    private String currentAccountId;
    private int profileIcon;
    private String summonerId;
    private String accountId;

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "currentPlatformId='" + currentPlatformId + '\'' +
                ", summonerName='" + summonerName + '\'' +
                ", matchHistoryUrl='" + matchHistoryUrl + '\'' +
                ", platformId='" + platformId + '\'' +
                ", currentAccountId='" + currentAccountId + '\'' +
                ", profileIcon=" + profileIcon +
                ", summonerId='" + summonerId + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    public String getCurrentPlatformId() {
        return currentPlatformId;
    }

    public void setCurrentPlatformId(String currentPlatformId) {
        this.currentPlatformId = currentPlatformId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getMatchHistoryUrl() {
        return matchHistoryUrl;
    }

    public void setMatchHistoryUrl(String matchHistoryUrl) {
        this.matchHistoryUrl = matchHistoryUrl;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getCurrentAccountId() {
        return currentAccountId;
    }

    public void setCurrentAccountId(String currentAccountId) {
        this.currentAccountId = currentAccountId;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
