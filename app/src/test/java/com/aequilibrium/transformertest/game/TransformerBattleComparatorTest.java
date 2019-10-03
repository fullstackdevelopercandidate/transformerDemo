package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformerBattleComparatorTest {

    TransformerBattleComparator comparator=null;
    TransfomerEntity t1=null;
    TransfomerEntity t2=null;
    int res=0;
    @Before
    public void prepare(){
        comparator=new TransformerBattleComparator();
        t1=new TransfomerEntity();
        t2=new TransfomerEntity();
    }
    @Test
    public void testCase1(){
        t1.setCourage(3);
        t1.setStrength(3);
        t2.setCourage(7);
        t2.setStrength(6);
        res=comparator.compare(t1,t2);
        assertEquals(res,-1);
    }
    @Test
    public void testCase2(){
        t1.setCourage(4);
        t1.setStrength(3);
        t1.setRank(5);
        t2.setCourage(7);
        t2.setStrength(6);
        t2.setRank(5);
        res=comparator.compare(t1,t2);
        assertEquals(res,0);
    }
    @Test
    public void testCase3(){
        t1.setCourage(4);
        t1.setStrength(3);
        t1.setRank(4);
        t2.setCourage(7);
        t2.setStrength(6);
        t2.setRank(5);
        res=comparator.compare(t1,t2);
        assertEquals(res,-1);
    }

    @Test
    public void testCase4(){
        t1.setCourage(4);
        t1.setStrength(3);
        t1.setSkill(3);
        t2.setCourage(7);
        t2.setStrength(6);
        t2.setSkill(6);
        res=comparator.compare(t1,t2);
        assertEquals(res,-1);
    }
}
