package com.aequilibrium.transformertest.service;

import com.aequilibrium.transformertest.model.TransfomerEntity;
import com.aequilibrium.transformertest.model.Transformers;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApi {
    @GET("allspark")
    Call<String> getToken();

    @POST("transformers")
    Call<TransfomerEntity> create(@Body TransfomerEntity entity);

    @GET("transformers/{id}")
    Call<TransfomerEntity> findById(@Path("id") String transformerId);

    @GET("transformers")
    Call<Transformers> getAll();

    @PUT("transformers")
    Call<TransfomerEntity> update(@Body TransfomerEntity entity);

    @DELETE("transformers/{id}")
    Call<ResponseBody> deleteBook(@Path("id") String transformerId);

}
