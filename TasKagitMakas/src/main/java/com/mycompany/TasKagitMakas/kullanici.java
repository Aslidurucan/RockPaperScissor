/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.TasKagitMakas;

/**
 *
 * @author AsliD
 */
public class kullanici extends oyuncu {

    private Integer hareket;
    public kullanici(){ }

    public kullanici(Integer oyuncuID, String oyuncuAdi, Integer skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public void nesneSec(String secim){
        setSecim(secim);
    }
}
