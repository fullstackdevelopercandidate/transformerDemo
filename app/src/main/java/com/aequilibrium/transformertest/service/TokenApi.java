package com.aequilibrium.transformertest.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TokenApi {
    @GET("allspark")
    Call<String> getToken();
}
