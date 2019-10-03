package com.aequilibrium.transformertest.service;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.util.ArrayList;
import java.util.List;

public class TransformerService {
    List<TransfomerEntity> entities=new ArrayList<>();
    public List<TransfomerEntity> getAllEntities(){

        TransfomerEntity e1 = new TransfomerEntity();
        e1.setName("test1");
        entities.add(e1);

        TransfomerEntity e2 = new TransfomerEntity();
        e2.setName("test1234");
        entities.add(e2);

        return entities;
    }

    public void add(){
        TransfomerEntity e2 = new TransfomerEntity();
        e2.setName("yyyy");
        entities.add(e2);
    }

}
