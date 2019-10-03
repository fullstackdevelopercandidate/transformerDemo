package com.aequilibrium.transformertest.service;

import androidx.databinding.ObservableArrayList;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SingletonService {
    private volatile static SingletonService instance; //声明成 volatile
    private SingletonService (){
        entities=new ArrayList();
    }

    public static SingletonService getSingleton() {
        if (instance == null) {
            synchronized (SingletonService.class) {
                if (instance == null) {
                    instance = new SingletonService();
                }
            }
        }
        return instance;
    }

    private  List<TransfomerEntity> entities;
    private ObservableArrayList<TransfomerEntity> data=null;

    public  List<TransfomerEntity> getEntities(){
        return entities;
    }

    public void setData(ObservableArrayList<TransfomerEntity> data){
        this.data=data;

    }

    public ObservableArrayList<TransfomerEntity> getData(){
        return data;
    }

    private TransfomerEntity entity;
    public void setEntity(TransfomerEntity entity){
        this.entity=entity;
    }
    public TransfomerEntity getEntity(){
        return entity;
    }
}
