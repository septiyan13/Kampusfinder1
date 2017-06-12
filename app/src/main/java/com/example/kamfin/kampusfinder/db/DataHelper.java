package com.example.kamfin.kampusfinder.db;

import android.content.Context;

import com.example.kamfin.kampusfinder.Item.ItemKampus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrT on 5/27/2017.
 */

public class DataHelper
{
    public static List<ItemKampus> getAllKampus(Context context)
    {
        List<ItemKampus> list = new ArrayList<>();
        
        String q1 = "SELECT * FROM kampus";
        String[][] res1 = SQLiteDataManager.read(context, q1);
        
        for (int a = 0; a < res1.length; a++)
        {
            ItemKampus it = new ItemKampus(res1[a]);
            
            String q2 = "SELECT gambar FROM gambar WHERE id_kampus = '" + it.getId_kampus() + "'";
            String[][] res2 = SQLiteDataManager.read(context, q2);
            
            List<String> gambars = new ArrayList<>();
            for (int b = 0; b < res2.length; b++)
            {
                gambars.add(res2[b][0]);
            }
            
            it.setGambar(gambars);
    
            String q3 = "SELECT nm_jurusan FROM kampus_pjurusan JOIN jurusan ON jurusan.id_jurusan = kampus_pjurusan.id_jurusan WHERE id_kampus = '" + it.getId_kampus() + "'";
            String[][] res3 = SQLiteDataManager.read(context, q3);
    
            List<String> jurusans = new ArrayList<>();
            for (int b = 0; b < res3.length; b++)
            {
                jurusans.add(res3[b][0]);
            }
    
            it.setJurusan(jurusans);
            
            list.add(it);
        }
        
        return list;
    }
    
    public static List<ItemKampus> getKampusByJurusan(Context context, String jurusan)
    {
        List<ItemKampus> list = new ArrayList<>();
        
        String q1 = "SELECT * FROM kampus\n" +
                "WHERE id_kampus IN (SELECT id_kampus FROM kampus_pjurusan\n" +
                "JOIN jurusan ON jurusan.id_jurusan = kampus_pjurusan.id_jurusan\n" +
                "WHERE nm_jurusan LIKE '%" + jurusan + "%')";
        String[][] res1 = SQLiteDataManager.read(context, q1);
        
        for (int a = 0; a < res1.length; a++)
        {
            ItemKampus it = new ItemKampus(res1[a]);
            
            String q2 = "SELECT gambar FROM gambar WHERE id_kampus = '" + it.getId_kampus() + "'";
            String[][] res2 = SQLiteDataManager.read(context, q2);
            
            List<String> gambars = new ArrayList<>();
            for (int b = 0; b < res2.length; b++)
            {
                gambars.add(res2[b][0]);
            }
            
            it.setGambar(gambars);
            
            String q3 = "SELECT nm_jurusan FROM kampus_pjurusan JOIN jurusan ON jurusan.id_jurusan = kampus_pjurusan.id_jurusan WHERE id_kampus = '" + it.getId_kampus() + "'";
            String[][] res3 = SQLiteDataManager.read(context, q3);
            
            List<String> jurusans = new ArrayList<>();
            for (int b = 0; b < res3.length; b++)
            {
                jurusans.add(res3[b][0]);
            }
            
            it.setJurusan(jurusans);
            
            list.add(it);
        }
        
        return list;
    }
}
