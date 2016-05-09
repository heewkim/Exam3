/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kim
 */
public class Players {
    private int playerID;
    private String playerName;
    private String playerPosition;
    private int playerAge;
    private String playerTeam;
    private int playerDraftYear;
    private String playerDraftRank;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public int getPlayerDraftYear() {
        return playerDraftYear;
    }

    public void setPlayerDraftYear(int playerDraftYear) {
        this.playerDraftYear = playerDraftYear;
    }

    public String getPlayerDraftRank() {
        return playerDraftRank;
    }

    public void setPlayerDraftRank(String playerDraftRank) {
        this.playerDraftRank = playerDraftRank;
    }

    @Override
    public String toString() {
        return "Players{" + "playerID=" + playerID + ", playerName=" + playerName + ", playerPosition=" + playerPosition + ", playerAge=" + playerAge + ", playerTeam=" + playerTeam + ", playerDraftYear=" + playerDraftYear + ", playerDraftRank=" + playerDraftRank + '}';
    }

    
    public Players() {
        this.playerID = 0;
        this.playerName = "";
        this.playerPosition ="";
        this.playerAge = 0;
        this.playerTeam = "";
        this.playerDraftYear = 0;
        this.playerDraftRank = "";
    }
    
    public Players(int playerID, String playerName, String playerPosition, int playerAge, String playerTeam, int playerDraftYear, String playerDraftRank) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerAge = playerAge;
        this.playerTeam = playerTeam;
        this.playerDraftYear = playerDraftYear;
        this.playerDraftRank = playerDraftRank;
    }
}
