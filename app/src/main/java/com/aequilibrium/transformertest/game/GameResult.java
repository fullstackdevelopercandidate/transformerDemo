package com.aequilibrium.transformertest.game;


import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.List;

public class GameResult {
    private int battle_count;
    private String winning_team;
    private String losing_team;
    private String survivor_team_name;
    private List<TransfomerEntity> survivors;
    private List<TransfomerEntity> winners;
    private boolean isGameOver;
    private String gameOvermsg;



    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public String getGameOvermsg() {
        return gameOvermsg;
    }

    public void setGameOvermsg(String gameOvermsg) {
        this.gameOvermsg = gameOvermsg;
    }

    public String getSurvivor_team_name() {
        return survivor_team_name;
    }

    public void setSurvivor_team_name(String survivor_team_name) {
        this.survivor_team_name = survivor_team_name;
    }

    // Decepticons
    // Autobots):
    public int getBattle_count() {
        return battle_count;
    }

    public void setBattle_count(int battle_count) {
        this.battle_count = battle_count;
    }

    public String getWinning_team() {
        return winning_team;
    }

    public void setWinning_team(String winning_team) {
        this.winning_team = winning_team;
    }

    public String getLosing_team() {
        return losing_team;
    }

    public void setLosing_team(String losing_team) {
        this.losing_team = losing_team;
    }

    public List<TransfomerEntity> getSurvivors() {
        return survivors;
    }

    public void setSurvivors(List<TransfomerEntity> survivors) {
        this.survivors = survivors;
    }

    public List<TransfomerEntity> getWinners() {
        return winners;
    }

    public void setWinners(List<TransfomerEntity> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        String res = "";
        if(isGameOver){
            res="Game Over! Because  Predaking(Optimus Prime) VS Predaking(Optimus Prime)";
            return res;
        }
        if (battle_count == 1) {
            res = "1 battle";
        } else {
            res = battle_count + " battles";
        }
        res = res + "\n";
        res = res + "Winning team (" + winning_team + "):";
        res=res+"\n";
        for(TransfomerEntity entity:winners) {
            res=res+entity.getName()+"\n";
        }
        if(survivors.size()>0) {
            res = res + "Survivors from the team (" + survivor_team_name + "):\n";
            for(TransfomerEntity entity:survivors) {
                res=res+entity.getName()+"\n";
            }
        }
        return res;
    }

}
