package com.aequilibrium.transformertest.event;

public class RefreshTokenEvent {
    private String token="";
    public RefreshTokenEvent(String token){
        this.token=token;

    }

    public String getToken(){
        return token;
    }
}
