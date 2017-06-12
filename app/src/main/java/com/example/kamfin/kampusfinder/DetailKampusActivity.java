package com.example.kamfin.kampusfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kamfin.kampusfinder.Adapter.AdapterGambar;
import com.example.kamfin.kampusfinder.Item.ItemKampus;
import com.example.kamfin.kampusfinder.VIew.WrapPager;

/**
 * Created by GrT on 5/27/2017.
 */
public class DetailKampusActivity extends AppCompatActivity implements View.OnClickListener
{
    WrapPager wrapPager;
    AdapterGambar adapterGambar;
    
    TextView txtNamaKampus;
    TextView txtDeskripsi;
    TextView txtJurusan;
    
    Button btnPeta;
    
    ItemKampus it;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kampus);
        
        it = (ItemKampus)getIntent().getSerializableExtra("it"); 
        
        wrapPager = (WrapPager)findViewById(R.id.wrapPager);
        adapterGambar = new AdapterGambar(getSupportFragmentManager(), it.getGambar());
        wrapPager.setAdapter(adapterGambar);
        
        txtNamaKampus = (TextView)findViewById(R.id.txtNamaKampus);
        txtDeskripsi = (TextView)findViewById(R.id.txtDeskripsi);
        txtJurusan = (TextView)findViewById(R.id.txtJurusan);
        
        btnPeta = (Button)findViewById(R.id.btnPeta);
        btnPeta.setOnClickListener(this);
        
        fillData();
    }
    
    private void fillData()
    {
        txtNamaKampus.setText(it.getNm_kampus());
        txtDeskripsi.setText(it.getDes_kampus());
        
        String jurusan = "Jurusan :\n";
        
        for (int a = 0; a < it.getJurusan().size(); a++)
        {
            jurusan += "- " + it.getJurusan().get(a);
            
            if (a < it.getJurusan().size() - 1)
                jurusan += "\n";
        }
     
        txtJurusan.setText(jurusan);
    }
    
    @Override
    public void onClick(View v)
    {
        if (v == btnPeta)
        {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?daddr=" + it.getLatitude() + "," +
                            it.getLongitude() + "&mode=driving"));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
    }
}
