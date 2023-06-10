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
public class ustaMakas extends makas{
	private Integer hiz;
	
	public ustaMakas(){ 
            super();
            this.hiz = 2;
        }

    public ustaMakas(Integer dayaniklilik, Integer seviyePuani, Integer keskinlik, Integer hiz) {
        super(dayaniklilik, seviyePuani, keskinlik);
        this.hiz = hiz;
    }
    
    @Override
    public void nesnePuaniGoster(Integer puan){
        System.out.println(puan);
    }
    @Override
    public double etkiHesapla(String oyuncuSecim,String bilgisayarSecim, String oyuncuFlag){
        Integer keskinlik=2; 
        Integer kalinlik=1;
        Integer sicaklik=1;
        Integer nufuz=0;
        Integer katilik=0;
        double a=0.2;
        if(oyuncuFlag.equals("O")){
            switch(bilgisayarSecim) {
                case "tas":
                    katilik=2;
                    break;  
                case "kagit":
                    nufuz=2;
                    break;  
                case "agirTas":
                    katilik=2;
                    sicaklik=2;
                    break;  
                case "ozelKagit":
                    nufuz=2;
                    kalinlik=2;
                    break; 
                case "makas": 
                case "ustaMakas":
                    keskinlik=0;
                    nufuz=1;
                    break;       
            }
        }
        if(oyuncuFlag.equals("B")){
            switch(oyuncuSecim) {
                case "tas":
                    katilik=2;
                    break;  
                case "kagit":
                    nufuz=2;
                    break;  
                case "agirTas":
                    katilik=2;
                    sicaklik=2;
                    break;  
                case "ozelKagit":
                    nufuz=2;
                    kalinlik=2;
                    break; 
                case "makas":    
                case "ustaMakas":
                    keskinlik=0;
                    nufuz=1;
                    break;    
            }
        }
        System.out.println("Bilgisayar: " + oyuncuSecim + " " + bilgisayarSecim +" " + this.hiz);
        return (keskinlik*this.hiz)/((a*nufuz*kalinlik)+((1-a)*katilik*sicaklik));
    }
    @Override
    public double durumGuncelle(ArrayList<nesne> nesneListesi){
        double skor = 0;
        for(int i = 0; i< nesneListesi.size();i++){
            skor = skor + nesneListesi.get(i).getDayaniklilik();
        }
        return skor;
    }
    
    public Integer getHiz() {
        return hiz;
    }

    public void setHiz(Integer hiz) {
        this.hiz = hiz;
    }
}