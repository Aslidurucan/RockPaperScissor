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
public class kagit extends nesne{
	private Integer nufuz;
	
	public kagit(){
            super();
            this.nufuz = 2;
        }

    public kagit(Integer dayaniklilik, Integer seviyePuani, Integer nufuz) {
        super(dayaniklilik, seviyePuani);
        this.nufuz = nufuz;
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
        Integer katilik=0;
        double a=0.2;
        if(oyuncuFlag.equals("O")){
            switch(bilgisayarSecim) {
                case "tas":
                    katilik=2;
                    break;  
                case "makas":
                    keskinlik=2;
                    break;  
                case "agirTas":
                    katilik=2;
                    sicaklik=2;
                    break;  
                case "ustaMakas":
                    keskinlik=2;
                    direnc=2;
                    break; 
                case "kagit": 
                case "ozelKagit":
                    kalinlik=0;
                    katilik=1;
                    break; 
            }
        }
        if(oyuncuFlag.equals("B")){
            switch(oyuncuSecim) {
                case "tas":
                    katilik=2;
                    break;  
                case "makas":
                    keskinlik=2;
                    break;  
                case "agirTas":
                    katilik=2;
                    sicaklik=2;
                    break;  
                case "ustaMakas":
                    keskinlik=2;
                    direnc=2;
                    break; 
                case "kagit": 
                case "ozelKagit":
                    kalinlik=0;
                    katilik=1;
                    break; 
            }
        }
        System.out.println("Bilgisayar: " + oyuncuSecim + " " + bilgisayarSecim +" " + this.nufuz);
        return (this.nufuz*kalinlik)/((a*katilik*sicaklik)+((1-a)*keskinlik*direnc)); 
    }
    @Override
    public double durumGuncelle(ArrayList<nesne> nesneListesi){
        double skor = 0;
        for(int i = 0; i< nesneListesi.size();i++){
            skor = skor + nesneListesi.get(i).getDayaniklilik();
        }
        return skor;
    }
    
    public Integer getNufuz() {
        return nufuz;
    }

    public void setNufuz(Integer nufuz) {
        this.nufuz = nufuz;
    }
}
