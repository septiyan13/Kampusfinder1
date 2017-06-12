package com.example.kamfin.kampusfinder.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nitacantik on 5/27/2017.
 */

public class ItemKampus implements Serializable 
{
    private String id_kampus;
    private String nm_kampus;
    private String des_kampus;
    private Double latitude;
    private Double longitude;
    private List<String> gambar;
    private List<String> jurusan;

    public ItemKampus(String[] s)
    {
        id_kampus = s[0];
        nm_kampus = s[1];
        des_kampus = s[2];
        latitude = ParseDouble(s[3]);
        longitude = ParseDouble(s[4]);

    }
    private Double ParseDouble(String s)
    {
        double d = 0;
        try{
            d = Double.parseDouble(s);
        }catch (NumberFormatException e)
        {

        }
        return d;
    }

    public String getId_kampus() {
        return id_kampus;
    }

    public void setId_kampus(String id_kampus) {
        this.id_kampus = id_kampus;
    }

    public String getNm_kampus() {
        return nm_kampus;
    }

    public void setNm_kampus(String nm_kampus) {
        this.nm_kampus = nm_kampus;
    }

    public String getDes_kampus() {
        return des_kampus;
    }

    public void setDes_kampus(String des_kampus) {
        this.des_kampus = des_kampus;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<String> getGambar() {
        return gambar;
    }

    public void setGambar(List<String> gambar) {
        this.gambar = gambar;
    }

    public List<String> getJurusan() {
        return jurusan;
    }

    public void setJurusan(List<String> jurusan) {
        this.jurusan = jurusan;
    }
}
