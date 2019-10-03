package com.aequilibrium.transformertest.service;

import android.util.Log;

import com.aequilibrium.transformertest.AllStartInterface;
import com.aequilibrium.transformertest.event.InfoPageMessageEvent;
import com.aequilibrium.transformertest.event.MainPageMessageEvent;
import com.aequilibrium.transformertest.event.RefreshMainEvent;
import com.aequilibrium.transformertest.event.RefreshTokenEvent;
import com.aequilibrium.transformertest.event.RefreshTransformer;
import com.aequilibrium.transformertest.model.TransfomerEntity;
import com.aequilibrium.transformertest.model.Transformers;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class RestService {
    private static final String TAG = "RestService";
    public static void findToken(){
        Retrofit retrofit = TokenUtil.getSingleton().getRetrofit();
        AllStartInterface api = retrofit.create(AllStartInterface.class);
        Call<String> call = api.getToken();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                String token=response.body();
                EventBus.getDefault().post(new RefreshTokenEvent(token));

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public static void findAll(){
        Retrofit retrofit = RestUtil.getSingleton().getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<Transformers> call = api.getAll();
        call.enqueue(new Callback<Transformers>() {
            @Override
            public void onResponse(Call<Transformers> call, retrofit2.Response<Transformers> response) {
                List<TransfomerEntity> list = new ArrayList<>();
                if(response!=null&&response.body()!=null&&response.body().getTransformers()!=null)
                list=response.body().getTransformers();
                EventBus.getDefault().post(new RefreshMainEvent(list));

            }
            @Override
            public void onFailure(Call<Transformers> call, Throwable t) {

                EventBus.getDefault().post(new MainPageMessageEvent("Error for fetching all tramsformers!"));
                Log.d(TAG,"error!");
            }
        });
    }

    public static void create(TransfomerEntity entity){
        Retrofit retrofit = RestUtil.getSingleton().getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<TransfomerEntity> call = api.create(entity);
        call.enqueue(new Callback<TransfomerEntity>() {
            @Override
            public void onResponse(Call<TransfomerEntity> call, retrofit2.Response<TransfomerEntity> response) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Add sucess!"));
            }
            @Override
            public void onFailure(Call<TransfomerEntity> call, Throwable t) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Error for creating this tramsformers!"));
            }
        });
    }

    public static void update(TransfomerEntity entity){
        Retrofit retrofit = RestUtil.getSingleton().getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<TransfomerEntity> call = api.update(entity);
        call.enqueue(new Callback<TransfomerEntity>() {
            @Override
            public void onResponse(Call<TransfomerEntity> call, retrofit2.Response<TransfomerEntity> response) {
                //List<TransfomerEntity> list = new ArrayList<>();
                //list=response.body().getTransformers();
                EventBus.getDefault().post(new InfoPageMessageEvent("update sucess!"));
            }
            @Override
            public void onFailure(Call<TransfomerEntity> call, Throwable t) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Error for updating this tramsformers!"));
            }
        });
    }

    public static void delete(String id){
        Retrofit retrofit = RestUtil.getSingleton().getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<ResponseBody> call = api.deleteBook(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Delete sucess!"));
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Error for deleting this tramsformers!"));
            }
        });
    }

    public static void findById(String id){
        Retrofit retrofit = RestUtil.getSingleton().getRetrofit();
        RestApi api = retrofit.create(RestApi.class);
        Call<TransfomerEntity> call = api.findById(id);
        call.enqueue(new Callback<TransfomerEntity>() {
            @Override
            public void onResponse(Call<TransfomerEntity> call, retrofit2.Response<TransfomerEntity> response) {
                TransfomerEntity entity=response.body();
                EventBus.getDefault().post(new RefreshTransformer(entity));
            }
            @Override
            public void onFailure(Call<TransfomerEntity> call, Throwable t) {
                EventBus.getDefault().post(new InfoPageMessageEvent("Error for fetching this tramsformers!"));
            }
        });
    }
}
