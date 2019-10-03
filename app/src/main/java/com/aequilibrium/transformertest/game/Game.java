package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Game {
    private List<TransfomerEntity> list;
    Queue<TransfomerEntity> aqueue = null;
    Queue<TransfomerEntity> dqueue = null;
    List<TransfomerEntity> survivors = new ArrayList();
    private String survivor_team_name = "";
    private BattleStrategy battleStrategy;

    public Game(BattleStrategy battleStrategy) {
        this.battleStrategy = battleStrategy;
    }

    private void buildQueue() {
        TransformerComparator comparator = new TransformerComparator();
        aqueue = new PriorityQueue<TransfomerEntity>(10, comparator);
        dqueue = new PriorityQueue<TransfomerEntity>(10, comparator);
        for (TransfomerEntity entity : list) {
            if (entity.getTeam().equals("D")) {
                dqueue.offer(entity);
            } else {
                aqueue.offer(entity);
            }
        }
        int acount = aqueue.size();
        int dcount = dqueue.size();
        int count = Math.abs(acount - dcount);
        Queue<TransfomerEntity> queue = null;
        if (acount > dcount) {
            queue = aqueue;
            survivor_team_name = "Autobots";
        } else {
            queue = dqueue;
            survivor_team_name = "Decepticons";
        }
        for (int i = 0; i < count; i++) {
            survivors.add(queue.poll());
        }
    }

    public GameResult battle(List<TransfomerEntity> list) {
        this.list = list;
        GameResult result = new GameResult();
        buildQueue();
        int count = aqueue.size();
        List<TransfomerEntity> alist = new ArrayList();
        List<TransfomerEntity> dlist = new ArrayList();
        int a_count_success = 0;
        int d_count_success = 0;
        for (int i = 0; i < count; i++) {
            TransfomerEntity at = aqueue.poll();
            TransfomerEntity dt = dqueue.poll();
            alist.add(at);
            dlist.add(dt);
            BattleResult battleResult = battleStrategy.findWinner(at, dt);
            if (battleResult.isFinished()) {
                result.setGameOver(true);
                result.setGameOvermsg(at.getName() + " vs " + dt.getName() + "!");
                return result;
            }
            if (!battleResult.isTie()) {
                TransfomerEntity winner = battleResult.getWinner();
                TransfomerEntity loser = battleResult.getLoser();
                if(winner.getId().equals(at.getId())) {
                    a_count_success++;
                }else {
                    d_count_success++;
                }
            } else {
                a_count_success++;
                d_count_success++;
            }
        }
        if(a_count_success>d_count_success) {
            result.setWinning_team("Autobots");
            result.setWinners(alist);
        }else {
            result.setWinning_team("Decepticons");
            result.setWinners(dlist);
        }
        result.setBattle_count(count);
        result.setSurvivor_team_name(survivor_team_name);
        result.setSurvivors(survivors);
        return result;
    }

}

