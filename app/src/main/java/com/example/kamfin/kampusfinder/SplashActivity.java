package com.example.kamfin.kampusfinder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable
{

    Handler h;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        h = new Handler();
        h.postDelayed(this, 3000);
    }
    
    @Override
    public void run()
    {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        
        finish();
    }
    
    @Override
    public void onBackPressed()
    {
        h.removeCallbacks(this);
    }
}
