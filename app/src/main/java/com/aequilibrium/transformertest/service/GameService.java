package com.aequilibrium.transformertest.service;


import com.aequilibrium.transformertest.game.BattleStrategySimple;
import com.aequilibrium.transformertest.game.Game;
import com.aequilibrium.transformertest.game.GameResult;
import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    Game game = null;
    private List<TransfomerEntity> list;

    public GameService(List<TransfomerEntity> list) {
        this.list = list;
        game = new Game(new BattleStrategySimple());
    }

    public GameResult startGame() {
        GameResult result = game.battle(list);
        return result;
    }



}

