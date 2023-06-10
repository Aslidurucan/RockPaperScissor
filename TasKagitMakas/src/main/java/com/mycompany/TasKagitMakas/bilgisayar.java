/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.TasKagitMakas;

import java.util.Random;
/**
 *
 * @author AsliD
 */
public class bilgisayar extends oyuncu {

    private Random rand;
    private final int MAX_NUMBER = 3;
    
    public bilgisayar(){}
    
    public bilgisayar(Integer oyuncuID, String oyuncuAdi, Integer skor) {
        super(oyuncuID, oyuncuAdi, skor);
    	rand = new Random();
    }
	
	@Override
    public void nesneSec(String secim) {
        int randomNum = rand.nextInt(MAX_NUMBER);
        switch(randomNum) {
            case 0:
                setSecim("tas");
                break;
            case 1:
                setSecim("kagit");
                break;
            case 2:
                setSecim("makas");
                break;
        }
    }
}
