package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

public interface BattleStrategy {
    public BattleResult findWinner(TransfomerEntity t1, TransfomerEntity t2);

}
