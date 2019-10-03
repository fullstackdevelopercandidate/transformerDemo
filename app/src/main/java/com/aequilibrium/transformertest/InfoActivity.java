package com.aequilibrium.transformertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.aequilibrium.transformertest.databinding.ActivityTransformerBinding;
import com.aequilibrium.transformertest.event.InfoPageMessageEvent;
import com.aequilibrium.transformertest.event.RefreshTransformer;
import com.aequilibrium.transformertest.model.TransfomerEntity;
import com.aequilibrium.transformertest.service.RestService;
import com.aequilibrium.transformertest.service.SingletonService;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class InfoActivity extends AppCompatActivity {
    Context context;
    TransfomerEntity entity=null;
    boolean isAdd=false;
    String id="";
    boolean loaded=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        context=this;
        ActivityTransformerBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_transformer);

        entity=new TransfomerEntity();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if(id==null||id.length()==0){
            isAdd=true;
            entity.setStrength(8);
            entity.setSkill(8);
            entity.setIntelligence(8);
            entity.setCourage(8);
            entity.setName("Test");
            entity.setRank(8);
            entity.setSpeed(8);
            entity.setEndurance(8);
            entity.setFirepower(8);
            entity.setTeam("D");
        }else{
            entity= SingletonService.getSingleton().getEntity();
            //RestService.findById(id);
        }
        viewDataBinding.setEntity(entity);
    }

    public void add(View view)
    {
        if(isAdd)
            RestService.create(entity);
        else {
            RestService.update(entity);
        }
    }

    public void delete(View view)
    {
            RestService.delete(entity.getId());
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshEntity(RefreshTransformer event) {

        entity.setSpeed(event.getEntity().getSpeed());
        entity.setRank(event.getEntity().getRank());
        entity.setName(event.getEntity().getName());
        entity.setEndurance(event.getEntity().getEndurance());
        entity.setFirepower(event.getEntity().getFirepower());
        entity.setCourage(event.getEntity().getCourage());
        entity.setIntelligence(event.getEntity().getIntelligence());
        entity.setSkill(event.getEntity().getSkill());
        entity.setStrength(event.getEntity().getStrength());
        entity.setTeam(event.getEntity().getTeam());
        entity.setTeam_icon(event.getEntity().getTeam_icon());
        loaded=true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showMsg(InfoPageMessageEvent event) {
        Toast.makeText(InfoActivity.this,event.getMsg(), Toast.LENGTH_SHORT).show();
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



}
