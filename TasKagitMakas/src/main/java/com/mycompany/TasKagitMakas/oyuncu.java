/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.TasKagitMakas;

/**
 *
 * @author AsliD
 */
import java.util.ArrayList;

public abstract class oyuncu {
    
    private Integer oyuncuID;
    private String oyuncuAdi;
    private double skor;
    private String secim;
    private ArrayList<nesne> nesneListesi;


    public void skorGoster(){

    }
    public abstract void nesneSec(String nesneSec);

    public oyuncu(){ }

    public oyuncu(Integer oyuncuID, String oyuncuAdi, Integer skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }

    public Integer getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(Integer oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }
    
    public String getSecim() {
        return secim;
    }

    public void setSecim(String secim) {
        this.secim = secim;
    }
    
    public ArrayList<nesne> getNesneListesi() {
        return nesneListesi;
    }

    public void setNesneListesi(ArrayList<nesne> nesneListesi) {
        this.nesneListesi = nesneListesi;
    }
}

