package com.aequilibrium.transformertest.event;

import com.aequilibrium.transformertest.model.TransfomerEntity;

public class RefreshTransformer {
    private TransfomerEntity entity;
    public RefreshTransformer(TransfomerEntity entity){
        this.entity=entity;
    }
    public TransfomerEntity getEntity(){
        return entity;
    }
}
