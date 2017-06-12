package com.example.kamfin.kampusfinder.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamfin.kampusfinder.Classes.ClassUtil;
import com.example.kamfin.kampusfinder.Item.ItemKampus;
import com.example.kamfin.kampusfinder.R;

import java.util.List;

/**
 * Created by Nitacantik on 5/27/2017.
 */

public class AdapterKampus extends ArrayAdapter<ItemKampus> {
    public AdapterKampus(@NonNull Context context, @LayoutRes int resource, @NonNull List<ItemKampus> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v==null)
            v= LayoutInflater.from(getContext()).inflate(R.layout.item_kampus, null);

        ItemKampus it = getItem(position);

        TextView txtnmkampus = (TextView)v.findViewById(R.id.textvjudul);
        TextView txtdeskampus = (TextView)v.findViewById(R.id.textvdes);
        ImageView imgkampus = (ImageView)v.findViewById(R.id.gambarkampus);

        txtnmkampus.setText(it.getNm_kampus());
        txtdeskampus.setText(it.getDes_kampus());
        imgkampus.setImageBitmap(ClassUtil.getBitmapFromAsset(getContext(),"images/"+it.getGambar().get(0)));
        return v;


    }
}

