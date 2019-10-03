package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransformerComparatorTest {
    TransformerComparator comparator=null;
    TransfomerEntity t1=null;
    TransfomerEntity t2=null;
    int res=0;
    @Before
    public void prepare(){
         comparator=new TransformerComparator();
         t1=new TransfomerEntity();
         t2=new TransfomerEntity();
    }
    @Test
    public void testCase1(){
        t1.setRank(1);
        t2.setRank(1);
        res=comparator.compare(t1,t2);
        assertEquals(res,0);
    }

    @Test
    public void testCase2(){
        t1.setRank(1);
        t2.setRank(2);
        res=comparator.compare(t1,t2);
        assertEquals(res,-1);
    }

    @Test
    public void testCase3(){
        t1.setRank(3);
        t2.setRank(1);
        res=comparator.compare(t1,t2);
        assertEquals(res,2);
    }
}
