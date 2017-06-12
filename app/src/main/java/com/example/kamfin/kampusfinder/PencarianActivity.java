package com.example.kamfin.kampusfinder;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.kamfin.kampusfinder.Adapter.AdapterKampus;
import com.example.kamfin.kampusfinder.Item.ItemKampus;
import com.example.kamfin.kampusfinder.db.DataHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrT on 5/28/2017.
 */
public class PencarianActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, TextWatcher
{
    EditText edtCari;
    
    ListView lsvKampus;
    List<ItemKampus> lKampus;
    AdapterKampus adapterKampus;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
    
        edtCari = (EditText)findViewById(R.id.edtCari);
        edtCari.addTextChangedListener(this);
    
        lsvKampus = (ListView)findViewById(R.id.lsvKampus);
        lKampus = new ArrayList<>();
        adapterKampus = new AdapterKampus(this, 0, lKampus);
    
        lsvKampus.setAdapter(adapterKampus);
        lsvKampus.setOnItemClickListener(this);
    
        refreshList();
    }
    
    private void refreshList()
    {
        lKampus.clear();
        lKampus.addAll(DataHelper.getKampusByJurusan(this, edtCari.getText().toString()));
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
    
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        
    }
    
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        
    }
    
    @Override
    public void afterTextChanged(Editable editable)
    {
        refreshList();
    }
}
