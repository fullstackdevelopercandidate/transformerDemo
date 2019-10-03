package com.aequilibrium.transformertest.event;

public class MainPageMessageEvent {

    private String msg="";
    public MainPageMessageEvent(String msg){
        this.msg=msg;

    }

    public String getMsg(){
        return msg;
    }
}
