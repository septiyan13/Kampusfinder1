package com.example.kamfin.kampusfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nitacantik on 5/27/2017.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener 
{
    Button btnkampus;
    Button btnsearch;
    Button btnexit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnkampus = (Button)findViewById(R.id.btnkampus);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        btnexit = (Button)findViewById(R.id.btnexit);
        btnkampus.setOnClickListener(this);
        btnsearch.setOnClickListener(this);
        btnexit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) 
    {
        if (v==btnkampus)
        {
            Intent i = new Intent(this, KampusActivity.class);
            startActivity(i);
        }
        else if(v==btnsearch)
        {
            Intent i = new Intent(this, PencarianActivity.class);
            startActivity(i);
        }
        else if(v==btnexit)
        {
            finish();
        }
    }
}
