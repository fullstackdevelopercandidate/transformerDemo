package com.aequilibrium.transformertest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aequilibrium.transformertest.common.SingletonAllSpark;
import com.aequilibrium.transformertest.common.TransformerAdapter;
import com.aequilibrium.transformertest.event.MainPageMessageEvent;
import com.aequilibrium.transformertest.event.RefreshMainEvent;
import com.aequilibrium.transformertest.event.RefreshTokenEvent;
import com.aequilibrium.transformertest.model.TransfomerEntity;
import com.aequilibrium.transformertest.service.RestService;
import com.aequilibrium.transformertest.service.SingletonService;
import com.aequilibrium.transformertest.service.TransformerService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TransformerService service;
    List<TransfomerEntity> entities;
    TransformerAdapter adapter;
    RecyclerView recyclerView;
    Context context;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.aequilibrium.transformertest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.viewMain);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TransformerAdapter(this);
        adapter.setOnItemClickListener(new TransformerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                updateTranformer(adapter.getItems().get(position));
                //Toast.makeText(MainActivity.this, "click " +  adapter.getItems().get(position).getName()+adapter.getItems().get(position).getSpeed(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void addTransformer() {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", "");
        startActivity(intent);
    }

    private void updateTranformer(TransfomerEntity entity) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", entity.getId());
        SingletonService.getSingleton().setEntity(entity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void add(View view) {
        addTransformer();
    }

    public void run(View view) {
        SingletonService.getSingleton().setData(adapter.getItems());
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPreferences = getSharedPreferences(
                sharedPrefFile, MODE_PRIVATE);
        String token = mPreferences.getString("token", "");
        Log.d(TAG, "token=" + token);
        if (token != null && token.length() > 0) {
            SingletonAllSpark.getSingleton().setToken(token);
            RestService.findAll();
        } else {
            RestService.findToken();
            ;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshData(RefreshMainEvent event) {
        adapter.getItems().clear();
        adapter.getItems().addAll(event.getEntities());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshToen(RefreshTokenEvent event) {
        SingletonAllSpark.getSingleton().setToken(event.getToken());
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("token", event.getToken());
        editor.apply();
        RestService.findAll();
        Log.d(TAG, event.getToken());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showMsg(MainPageMessageEvent event) {
        Toast.makeText(MainActivity.this, event.getMsg(), Toast.LENGTH_SHORT).show();
    }

}
