package com.aequilibrium.transformertest.service;

import android.util.Log;

import com.aequilibrium.transformertest.common.SingletonAllSpark;
import com.aequilibrium.transformertest.common.TLSSocketFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TokenUtil {
    private static final String TAG = "SingletonRest";

    private volatile static TokenUtil instance;

    private static Retrofit retrofit = null;

    private TokenUtil() throws NoSuchAlgorithmException, KeyManagementException {

        String base = "https://transformers-api.firebaseapp.com/";
        OkHttpClient client = new OkHttpClient();
        client = new OkHttpClient.Builder()
                .sslSocketFactory(new TLSSocketFactory())
                .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        //.addHeader("Authorization", "Bearer " + SingletonAllSpark.getSingleton().getToken())
                        .addHeader("accept","application/json")
                        .build();
                return chain.proceed(newRequest);
            }
        })
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(base)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

    }

    public static TokenUtil getSingleton() {
        if (instance == null) {
            synchronized (SingletonAllSpark.class) {
                if (instance == null) {
                    try {
                        instance = new TokenUtil();
                    } catch (NoSuchAlgorithmException e) {
                        Log.e(TAG, e.getMessage());
                    } catch (KeyManagementException e) {
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}
