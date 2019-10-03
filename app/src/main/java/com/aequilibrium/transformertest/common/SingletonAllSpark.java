package com.aequilibrium.transformertest.common;



import android.content.Context;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class SingletonAllSpark {
    private volatile static SingletonAllSpark instance;
    private static String token="";
    private SingletonAllSpark (){

    }

    public static SingletonAllSpark getSingleton() {
        if (instance == null) {
            synchronized (SingletonAllSpark.class) {
                if (instance == null) {
                    instance = new SingletonAllSpark();
                }
            }
        }
        return instance;
    }
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token=token;
    }

}