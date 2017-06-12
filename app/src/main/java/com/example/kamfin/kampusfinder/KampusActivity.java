package com.example.kamfin.kampusfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kamfin.kampusfinder.Adapter.AdapterKampus;
import com.example.kamfin.kampusfinder.Item.ItemKampus;
import com.example.kamfin.kampusfinder.db.DataHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrT on 5/27/2017.
 */

public class KampusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    ListView lsvKampus;
    List<ItemKampus> lKampus;
    AdapterKampus adapterKampus;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus);
        
        lsvKampus = (ListView)findViewById(R.id.listvkampus);
        lKampus = new ArrayList<>();
        adapterKampus = new AdapterKampus(this, 0, lKampus);
        
        lsvKampus.setAdapter(adapterKampus);
        lsvKampus.setOnItemClickListener(this);
        
        refreshList();
    }
    
    private void refreshList()
    {
        lKampus.addAll(DataHelper.getAllKampus(this));
        adapterKampus.notifyDataSetChanged();
    }
    
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        ItemKampus it = lKampus.get(i);
    
        Intent intent = new Intent(this, DetailKampusActivity.class);
        intent.putExtra("it", it);
        startActivity(intent);
    }
}
