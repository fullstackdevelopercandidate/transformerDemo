package com.aequilibrium.transformertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aequilibrium.transformertest.game.GameResult;
import com.aequilibrium.transformertest.model.TransfomerEntity;
import com.aequilibrium.transformertest.service.GameService;
import com.aequilibrium.transformertest.service.SingletonService;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        List<TransfomerEntity> list= SingletonService.getSingleton().getData();
        GameService gameService=new GameService(list);
        GameResult result=gameService.startGame();
        TextView txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtMsg.setText(result.toString());
    }
}
