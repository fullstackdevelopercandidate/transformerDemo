package com.aequilibrium.transformertest.event;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.List;

public class RefreshMainEvent {

    List<TransfomerEntity> entities = null;

    public RefreshMainEvent(List<TransfomerEntity> entities) {
        this.entities = entities;
    }

    public List<TransfomerEntity> getEntities(){
        return entities;
    }

}
