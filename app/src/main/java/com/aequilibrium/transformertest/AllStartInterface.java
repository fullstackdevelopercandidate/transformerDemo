package com.aequilibrium.transformertest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllStartInterface {

    @GET("allspark")
    Call<String> getToken();
}


