package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

public class BattleStrategySimple implements BattleStrategy {

    @Override
    public BattleResult findWinner(TransfomerEntity t1, TransfomerEntity t2) {
        BattleResult result = new BattleResult();
        String name1 = t1.getName();
        String name2 = t2.getName();
        boolean b1=(name1.equals("Optimus Prime") && name2.equals("Predaking"));
        boolean b2=(name2.equals("Optimus Prime") && name1.equals("Predaking"));
        boolean b3=(name1.equals("Optimus Prime") && name2.equals("Optimus Prime"));
        boolean b4=(name2.equals("Predaking") && name1.equals("Predaking"));

        if (b1||b2||b3||b4) {
            result.setFinished(true);
            return result;
        }
        if (name1.equals("Optimus Prime") || name1.equals("Predaking")) {
            result.setWinner(t1);
            result.setLoser(t2);
            return result;
        }

        if (name2.equals("Optimus Prime") || name2.equals("Predaking")) {
            result.setWinner(t2);
            result.setLoser(t1);
            return result;
        }
        TransformerBattleComparator comparator = new TransformerBattleComparator();
        int res = comparator.compare(t1, t2);
        if (res > 0) {
            result.setWinner(t1);
            result.setLoser(t2);
            return result;
        } else if (res < 0) {
            result.setWinner(t2);
            result.setLoser(t1);
        } else {
            result.setTie(true);
        }
        return result;
    }

}

