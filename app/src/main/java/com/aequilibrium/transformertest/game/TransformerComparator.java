package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.Comparator;

public class TransformerComparator implements Comparator<TransfomerEntity> {
    @Override
    public int compare(TransfomerEntity t1, TransfomerEntity t2) {
        return t1.getRank()-t2.getRank();
    }
}
