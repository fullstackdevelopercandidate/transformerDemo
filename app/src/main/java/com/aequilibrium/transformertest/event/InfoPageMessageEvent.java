package com.aequilibrium.transformertest.event;

public class InfoPageMessageEvent {

    private String msg="";
    public InfoPageMessageEvent(String msg){
        this.msg=msg;

    }

    public String getMsg(){
        return msg;
    }
}
