package com.aequilibrium.transformertest.event;

import com.aequilibrium.transformertest.model.TransfomerEntity;

public class EntityEvent {
    private TransfomerEntity entity;
    public EntityEvent(TransfomerEntity entity){
        this.entity=entity;
    }
    public TransfomerEntity getEntity(){
        return entity;
    }
}
