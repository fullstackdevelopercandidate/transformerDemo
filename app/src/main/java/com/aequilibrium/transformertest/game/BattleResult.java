package com.aequilibrium.transformertest.game;


import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.Queue;

public class BattleResult {

    private boolean isTie=false;
    private boolean isFinished=false;
    private TransfomerEntity winner;
    private TransfomerEntity loser;


    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    public boolean isTie() {
        return isTie;
    }
    public void setTie(boolean isTie) {
        this.isTie = isTie;
    }
    public TransfomerEntity getWinner() {
        return winner;
    }
    public void setWinner(TransfomerEntity winner) {
        this.winner = winner;
    }
    public TransfomerEntity getLoser() {
        return loser;
    }
    public void setLoser(TransfomerEntity loser) {
        this.loser = loser;
    }




}
