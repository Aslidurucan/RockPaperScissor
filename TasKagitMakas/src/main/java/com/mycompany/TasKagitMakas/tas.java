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
public class tas extends nesne{
    private Integer katilik;
	
	public tas(){ 
            super();
            this.katilik = 2;
        }

    public tas(Integer dayaniklilik, Integer seviyePuani, Integer katilik) {
        super(dayaniklilik, seviyePuani);
        this.katilik = katilik;
    }
    
    @Override
    public void nesnePuaniGoster(Integer puan){
        System.out.println(puan);
    }
    @Override
    public double etkiHesapla(String oyuncuSecim,String bilgisayarSecim, String oyuncuFlag){
        Integer direnc=1; 
        Integer kalinlik=1;
        Integer sicaklik=1;
        Integer keskinlik=0;
        Integer nufuz=0;
        double a=0.2;
        if(oyuncuFlag.equals("O")){
            switch(bilgisayarSecim) {
                case "kagit":
                    nufuz=2;
                    break;  
                case "makas":
                    keskinlik=2;
                    break;  
                case "ozelKagit":
                    nufuz=2;
                    kalinlik=2;
                    break;  
                case "ustaMakas":
                    keskinlik=2;
                    direnc=2;
                    break;      
                case "tas": 
                case "agirTas":
                    sicaklik=0;
                    keskinlik=1;
                    break; 
            }
        }
        if(oyuncuFlag.equals("B")){
            switch(oyuncuSecim) {
                case "kagit":
                    nufuz=2;
                    break;  
                case "makas":
                    keskinlik=2;
                    break;  
                case "ozelKagit":
                    nufuz=2;
                    kalinlik=2;
                    break;  
                case "ustaMakas":
                    keskinlik=2;
                    direnc=2;
                    break;    
                case "tas": 
                case "agirTas":
                    sicaklik=0;
                    keskinlik=1;
                    break; 
            }
        }
        System.out.println("Bilgisayar: " + oyuncuSecim + " " + bilgisayarSecim +" " + this.katilik);
        
        return (this.katilik*sicaklik)/((a*keskinlik*direnc)+((1-a)*nufuz*kalinlik));
    }
    @Override
    public double durumGuncelle(ArrayList<nesne> nesneListesi){
        double skor = 0;
        for(int i = 0; i< nesneListesi.size();i++){
            skor = skor + nesneListesi.get(i).getDayaniklilik();
        }
        return skor;
    }
    
    public Integer getKatilik() {
        return katilik;
    }

    public void setKatilik(Integer katilik) {
        this.katilik = katilik;
    }
    
}
