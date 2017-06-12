package com.example.kamfin.kampusfinder.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kamfin.kampusfinder.Classes.ClassUtil;
import com.example.kamfin.kampusfinder.R;

/**
 * Created by GrT on 5/27/2017.
 */

public class GambarFragment extends Fragment
{
    private String gambar;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        gambar = getArguments().getString("gambar");
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.item_gambar, container, false);
    
        ImageView imgGambar = (ImageView)v.findViewById(R.id.imgGambar);
        imgGambar.setImageBitmap(ClassUtil.getBitmapFromAsset(getContext(), "images/" + gambar));
        
        return v;
    }
}
