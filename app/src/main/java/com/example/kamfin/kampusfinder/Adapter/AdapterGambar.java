package com.example.kamfin.kampusfinder.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kamfin.kampusfinder.Fragment.GambarFragment;

import java.util.List;

/**
 * Created by GrT on 5/27/2017.
 */

public class AdapterGambar extends FragmentPagerAdapter
{
    List<String> gambars;
    GambarFragment[] fragments;
    
    public AdapterGambar(FragmentManager fm, List<String> gambars)
    {
        super(fm);
        
        this.gambars = gambars;
        fragments = new GambarFragment[gambars.size()];
    }
    
    @Override
    public Fragment getItem(int position)
    {
        if (fragments[position] == null)
        {
            Bundle b = new Bundle();
            b.putString("gambar", gambars.get(position));
            
            fragments[position] = new GambarFragment();
            fragments[position].setArguments(b);
        }
        
        return fragments[position];
    }
    
    @Override
    public int getCount()
    {
        return gambars.size();
    }
}
