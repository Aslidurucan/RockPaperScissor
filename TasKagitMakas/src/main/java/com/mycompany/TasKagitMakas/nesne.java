/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.TasKagitMakas;

import java.util.ArrayList;

/**
 *
 * @author AsliD
 */
public class nesne {
    	private double dayaniklilik;
	private Integer seviyePuani;
	
	
	public nesne(){ 
            this.dayaniklilik = 20;
            this.seviyePuani = 0;
        }

    public nesne(Integer dayaniklilik, Integer seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
    }
    
    public void nesnePuaniGoster(Integer puan){
        System.out.println(puan);
    }
    
    public double etkiHesapla(String oyuncuSecim,String bilgisayarSecim, String oyuncuFlag){
        Integer direnc=1; 
        Integer kalinlik=1;
        Integer sicaklik=1;
        Integer keskinlik=0;
        Integer nufuz=0;
        Integer katilik=0;
        double a=0.2;
        String etkiO ="";
        String etkiB ="";
        System.out.println("Bilgisayar: " + oyuncuSecim + " " + bilgisayarSecim);
        switch(oyuncuSecim) {
            case "tas":
                katilik=2;
                etkiO="T";
                break;
            case "kagit":
                nufuz=2;
                etkiO="K";
                System.out.println("Bilgisayar: " + etkiO);
                break;  
            case "makas":
                keskinlik=2;
                etkiO="M";
                break;  
            case "agirTas":
                katilik=2;
                sicaklik=2;
                etkiO="T";
                break;  
            case "ozelKagit":
                nufuz=2;
                kalinlik=2;
                etkiO="K";
                break;  
            case "ustaMakas":
                keskinlik=2;
                direnc=2;
                etkiO="M";
                break;      
        }
        
        switch(bilgisayarSecim) {
            case "tas":
                katilik=2;
                etkiB="T";
                break;
            case "kagit":
                nufuz=2;
                etkiB="K";
                break;  
            case "makas":
                keskinlik=2;
                etkiB="M";
                break;  
            case "agirTas":
                katilik=2;
                sicaklik=2;
                etkiB="T";
                break;  
            case "ozelKagit":
                nufuz=2;
                kalinlik=2;
                etkiB="K";
                break;  
            case "ustaMakas":
                keskinlik=2;
                direnc=2;
                etkiB="M";
                break;      
        }
        
        if(oyuncuFlag.equals("O")){
            switch(etkiO) {
                case "T":
                    System.out.println("Bilgisayar: " + a);
                    return (katilik*sicaklik)/((a*keskinlik*direnc)+((1-a)*nufuz*kalinlik));
                case "K":
                    return (nufuz*kalinlik)/((a*katilik*sicaklik)+((1-a)*keskinlik*direnc));  
                case "M":
                    return (keskinlik*direnc)/((a*nufuz*kalinlik)+((1-a)*katilik*sicaklik));      
            }
        }
        if(oyuncuFlag.equals("B")){
            switch(etkiB) {
                case "T":
                    return (katilik*sicaklik)/((a*keskinlik*direnc)+((1-a)*nufuz*kalinlik));
                case "K":
                    return (nufuz*kalinlik)/((a*katilik*sicaklik)+((1-a)*keskinlik*direnc));  
                case "M":
                    return (keskinlik*direnc)/((a*nufuz*kalinlik)+((1-a)*katilik*sicaklik));      
            }
        }
        return 1;
    }
    
    public double durumGuncelle(ArrayList<nesne> nesneListesi){
        double skor = 0;
        for(int i = 0; i< nesneListesi.size();i++){
            skor = skor + nesneListesi.get(i).getDayaniklilik();
        }
        return skor;
    }
	
	public double getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(double dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }
    
    public Integer getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(Integer seviyePuani) {
        this.seviyePuani = seviyePuani;
    }
}
