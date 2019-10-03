package com.aequilibrium.transformertest.game;


import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.Comparator;

public class TransformerBattleComparator implements Comparator<TransfomerEntity> {
    @Override
    public int compare(TransfomerEntity t1, TransfomerEntity t2) {
        if(t1.getCourage()>(t2.getCourage()+3) && t1.getStrength()>(t2.getStrength()+2))
            return 1;
        if(t2.getCourage()>(t1.getCourage()+3) && t2.getStrength()>(t1.getStrength()+2))
            return -1;
        if(t1.getSkill()>(t2.getSkill()+2))
            return 1;
        if(t2.getSkill()>(t1.getSkill()+2))
            return -1;
        if(t1.getRank()==t2.getRank())
            return 0;
        if(t1.getRank()>t2.getRank())
            return 1;
        return -1;
    }
}
