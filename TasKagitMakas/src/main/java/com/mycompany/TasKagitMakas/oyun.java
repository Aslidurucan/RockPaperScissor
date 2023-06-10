/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.TasKagitMakas;

/**
 *
 * @author AsliD
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Random;

public class oyun {
    private kullanici oyuncu;
    private bilgisayar bilgisayar;
    private bilgisayar bilgisayar2;
    private int secimSayisi = 0;
    private int toplamSecim = 0;
    private double dayaniklilik = 0 ;
    private int nesneSayisi = 5;
    private int MAX_NUMBER = 5;
    private String hamleSayisi="";
    private String oynanisModuSec="";
    JFrame win;
    JLabel oyuncu1_img;
    JLabel oyuncu2_img;
    JButton tas;
    JButton kagit;
    JButton makas;
    JLabel oyuncu1;
    JLabel oyuncu2;
    JLabel skor;
    JButton secilen1;
    JButton secilen2;
    JButton secilen3;
    JButton secilen4;
    JButton secilen5;
    JLabel secilenNesneler;
    JButton hamleSayisiButon;
    JButton oynanisModu;
    JButton hamleYap;
    

    public oyun() {
        oyuncu = new kullanici(0,"Kullanıcı",0);
        oyuncu.setNesneListesi(new  ArrayList<nesne>());    
        bilgisayar = new bilgisayar(1,"Bilgisayar",0);
        bilgisayar.setNesneListesi(new  ArrayList<nesne>());
        bilgisayar2 = new bilgisayar(3,"Bilgisayar 2",0);
        bilgisayar2.setNesneListesi(new  ArrayList<nesne>());
        setJframe();
        SwingUtilities.updateComponentTreeUI(win);
        tas.setVisible(false);
        kagit.setVisible(false);
        makas.setVisible(false);
        hamleSayisiButon.setVisible(false);
        hamleYap.setVisible(false);
        oynanisModu.addActionListener((ActionEvent e) -> {
            oynanisModuSec = JOptionPane.showInputDialog(
                oynanisModu, "Oyun Modu Seçiniz. \n Kullanıcı- Bigisayar için: 1 \n Bilgisayar - Bilgisayar için: 2", 
                "Hamle Sayısı", JOptionPane.OK_CANCEL_OPTION);
            {
                hamleSayisiButon.setVisible(true);
                oynanisModu.setVisible(false);
                if(oynanisModuSec == null || !(oynanisModuSec.equals("1")||oynanisModuSec.equals("2"))){
                    oynanisModuSec="1";
                }     
                System.out.println(oynanisModuSec); 
                if(oynanisModuSec.equals("1")){
                    oyuncu1.setText(oyuncu.getOyuncuAdi());
                }else{
                    oyuncu1.setText(bilgisayar2.getOyuncuAdi());      
                } 
            }
        });
        hamleSayisiButon.addActionListener((ActionEvent e) -> {
            hamleSayisi = JOptionPane.showInputDialog(
                hamleSayisiButon, "Hamle Sayısı Gir", 
                "Hamle Sayısı", JOptionPane.OK_CANCEL_OPTION);
            { 
                hamleSayisiButon.setVisible(false);
                if(oynanisModuSec.equals("1")){
                    tas.setVisible(true);
                    kagit.setVisible(true);
                    makas.setVisible(true);
                }
                if(hamleSayisi != null && !hamleSayisi.equals("")){
                    for (char c : hamleSayisi.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            hamleSayisi="10";
                        }
                    }
                }else{
                    hamleSayisi="10";
                }
                if(oynanisModuSec.equals("2")){
                    hamleYap.setVisible(true);
                    bilNesneSec();
                }
                System.out.println(hamleSayisi); 
            }
        });
        hamleYap.addActionListener((ActionEvent e)->{
                makineOyun();
        });
        tas.addActionListener((ActionEvent e)->{
                oyuncu1_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\tas_right.png"));
        	oyuncu.getNesneListesi().add(new tas());
                secilenNesneler();
        });

        kagit.addActionListener((ActionEvent e)->{
                oyuncu1_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\kagit_right.png"));
                oyuncu.getNesneListesi().add(new kagit());
                secilenNesneler();
        });

        makas.addActionListener((ActionEvent e)->{
                oyuncu1_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\makas_right.png"));
                oyuncu.getNesneListesi().add(new makas());
                secilenNesneler();
        });
        
        secilen1.addActionListener((ActionEvent e)->{
            butonClick(0);
        });
        
        secilen2.addActionListener((ActionEvent e)->{
            butonClick(1);
        });
        
        secilen3.addActionListener((ActionEvent e)->{
            butonClick(2);
        });
        
        secilen4.addActionListener((ActionEvent e)->{
            butonClick(3);
        });
        
        secilen5.addActionListener((ActionEvent e)->{
            butonClick(4);
        });
    }
    public void butonClick(Integer i){
        secimSayisi++;
        toplamSecim++;
        String secim = oyuncu.getNesneListesi().get(i).getClass().getSimpleName();
        oyuncu1_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"O")));
        if(secimSayisi==nesneSayisi){
            secimSifirla();
            secimSayisi=0;
        }else{
            switch(i){
                case 0:
                    secilen1.setEnabled(false);
                    break;
                case 1:
                    secilen2.setEnabled(false);
                    break;
                case 2:
                    secilen3.setEnabled(false);
                    break;
                case 3:
                    secilen4.setEnabled(false);
                    break;
                case 4:
                    secilen5.setEnabled(false);
                    break;  
            } 
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(MAX_NUMBER);
        double a = oyuncu.getNesneListesi().get(i).etkiHesapla(oyuncu.getNesneListesi().get(i).getClass().getSimpleName(), bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName(), "O");
        double b = bilgisayar.getNesneListesi().get(randomNum).etkiHesapla(oyuncu.getNesneListesi().get(i).getClass().getSimpleName(), bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName(), "B");
        System.out.println("Bilgisayar: " + a + " " + b);
        dayaniklilik=oyuncu.getNesneListesi().get(i).getDayaniklilik() - b;
        oyuncu.getNesneListesi().get(i).setDayaniklilik(dayaniklilik < 0 ? 0 : dayaniklilik);
        dayaniklilik=bilgisayar.getNesneListesi().get(randomNum).getDayaniklilik() - a;
        bilgisayar.getNesneListesi().get(randomNum).setDayaniklilik(dayaniklilik < 0 ? 0 : dayaniklilik);
        oyuncu.setSkor(oyuncu.getNesneListesi().get(i).durumGuncelle(oyuncu.getNesneListesi()));
        bilgisayar.setSkor(bilgisayar.getNesneListesi().get(randomNum).durumGuncelle(bilgisayar.getNesneListesi()));
        skor.setText(oyuncu.getSkor()+" - "+bilgisayar.getSkor());
        if(a>b){
           oyuncu.getNesneListesi().get(i).setSeviyePuani(oyuncu.getNesneListesi().get(i).getSeviyePuani()+20);
           if(oyuncu.getNesneListesi().get(i).getSeviyePuani()>30 && (secim.equals("tas")||secim.equals("kagit")||secim.equals("makas"))){
               oyuncu.getNesneListesi().set(i, getOzelNesne(secim));
               switch(i){
                    case 0:
                        secilen1.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"D")));
                        break;
                    case 1:
                        secilen2.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"D")));
                        break;
                    case 2:
                        secilen3.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"D")));
                        break;
                    case 3:
                        secilen4.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"D")));
                        break;
                    case 4:
                        secilen5.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"D")));
                        break;  
                } 
           }
        }
        if(oyuncu.getNesneListesi().get(i).getDayaniklilik()<=0){
            nesneSayisi--;
            switch(i){
                case 0:
                    secilen1.setVisible(false);
                    break;
                case 1:
                    secilen2.setVisible(false);
                    break;
                case 2:
                    secilen3.setVisible(false);
                    break;
                case 3:
                    secilen4.setVisible(false);
                    break;
                case 4:
                    secilen5.setVisible(false);
                    break;  
            } 
        }
        secim = bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName();
        oyuncu2_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"")));
        if(a<b){
           bilgisayar.getNesneListesi().get(randomNum).setSeviyePuani(bilgisayar.getNesneListesi().get(randomNum).getSeviyePuani()+20);
           if(bilgisayar.getNesneListesi().get(randomNum).getSeviyePuani()>30 && (secim.equals("tas")||secim.equals("kagit")||secim.equals("makas"))){
               bilgisayar.getNesneListesi().set(randomNum, getOzelNesne(secim));
           }
        }
        if(bilgisayar.getNesneListesi().get(randomNum).getDayaniklilik()<=0){
           MAX_NUMBER--;
           bilgisayar.getNesneListesi().remove(randomNum);
           for(int j=0; j< bilgisayar.getNesneListesi().size();j++){
               System.out.println("Bilgisayar List: " + bilgisayar.getNesneListesi().get(j).getClass().getSimpleName());
           }
        }
        if(toplamSecim==Integer.parseInt(hamleSayisi) || nesneSayisi==0 || bilgisayar.getNesneListesi().isEmpty()){
            if(oyuncu.getSkor()>bilgisayar.getSkor() || bilgisayar.getNesneListesi().isEmpty()){
                JOptionPane.showMessageDialog(null,oyuncu.getOyuncuAdi()+ " kazandı!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            if(oyuncu.getSkor()<bilgisayar.getSkor() || nesneSayisi==0 ){
                JOptionPane.showMessageDialog(null,bilgisayar.getOyuncuAdi()+ " kazandı!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            if(oyuncu.getSkor()==bilgisayar.getSkor()){
                JOptionPane.showMessageDialog(null,"Berabere bitti!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            secilen1.setEnabled(false);
            secilen2.setEnabled(false);
            secilen3.setEnabled(false);
            secilen4.setEnabled(false);
            secilen5.setEnabled(false);
        }
    }
    public void makineOyun(){
        toplamSecim++;
        Random rand = new Random();
        int randomNum = rand.nextInt(MAX_NUMBER);
        int randomNum2 = rand.nextInt(nesneSayisi);
        String secim = bilgisayar2.getNesneListesi().get(randomNum2).getClass().getSimpleName();
        oyuncu1_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"")));
        double a = bilgisayar2.getNesneListesi().get(randomNum2).etkiHesapla(bilgisayar2.getNesneListesi().get(randomNum2).getClass().getSimpleName(), bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName(), "O");
        double b = bilgisayar.getNesneListesi().get(randomNum).etkiHesapla(bilgisayar2.getNesneListesi().get(randomNum2).getClass().getSimpleName(), bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName(), "B");
        System.out.println("Bilgisayar: " + a + " " + b);
        dayaniklilik=bilgisayar2.getNesneListesi().get(randomNum2).getDayaniklilik() - b;
        bilgisayar2.getNesneListesi().get(randomNum2).setDayaniklilik(dayaniklilik < 0 ? 0 : dayaniklilik);
        dayaniklilik=bilgisayar.getNesneListesi().get(randomNum).getDayaniklilik() - a;
        bilgisayar.getNesneListesi().get(randomNum).setDayaniklilik(dayaniklilik < 0 ? 0 : dayaniklilik);
        bilgisayar2.setSkor(bilgisayar2.getNesneListesi().get(randomNum2).durumGuncelle(bilgisayar2.getNesneListesi()));
        bilgisayar.setSkor(bilgisayar.getNesneListesi().get(randomNum).durumGuncelle(bilgisayar.getNesneListesi()));
        skor.setText(bilgisayar2.getSkor()+" - "+bilgisayar.getSkor());
        if(a>b){
           bilgisayar2.getNesneListesi().get(randomNum2).setSeviyePuani(bilgisayar.getNesneListesi().get(randomNum2).getSeviyePuani()+20);
           if(bilgisayar2.getNesneListesi().get(randomNum2).getSeviyePuani()>30 && (secim.equals("tas")||secim.equals("kagit")||secim.equals("makas"))){
               bilgisayar2.getNesneListesi().set(randomNum2, getOzelNesne(secim));
           }
        }
        if(bilgisayar2.getNesneListesi().get(randomNum2).getDayaniklilik()<=0){
            nesneSayisi--;
            bilgisayar2.getNesneListesi().remove(randomNum2);
            for(int j=0; j< bilgisayar2.getNesneListesi().size();j++){
                System.out.println("Bilgisayar List: " + bilgisayar2.getNesneListesi().get(j).getClass().getSimpleName());
            }
        }
        secim = bilgisayar.getNesneListesi().get(randomNum).getClass().getSimpleName();
        oyuncu2_img.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"")));
        if(a<b){
           bilgisayar.getNesneListesi().get(randomNum).setSeviyePuani(bilgisayar.getNesneListesi().get(randomNum).getSeviyePuani()+20);
           if(bilgisayar.getNesneListesi().get(randomNum).getSeviyePuani()>30 && (secim.equals("tas")||secim.equals("kagit")||secim.equals("makas"))){
               bilgisayar.getNesneListesi().set(randomNum, getOzelNesne(secim));
           }
        }
        if(bilgisayar.getNesneListesi().get(randomNum).getDayaniklilik()<=0){
           MAX_NUMBER--;
           bilgisayar.getNesneListesi().remove(randomNum);
           for(int j=0; j< bilgisayar.getNesneListesi().size();j++){
               System.out.println("Bilgisayar List: " + bilgisayar.getNesneListesi().get(j).getClass().getSimpleName());
           }
        }
        if(toplamSecim==Integer.parseInt(hamleSayisi) || nesneSayisi==0 || bilgisayar.getNesneListesi().isEmpty() || bilgisayar2.getNesneListesi().isEmpty()){
            if(bilgisayar2.getSkor()>bilgisayar.getSkor() || bilgisayar.getNesneListesi().isEmpty()){
                JOptionPane.showMessageDialog(null,bilgisayar2.getOyuncuAdi()+ " kazandı!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            if(bilgisayar2.getSkor()<bilgisayar.getSkor() || bilgisayar2.getNesneListesi().isEmpty() ){
                JOptionPane.showMessageDialog(null,bilgisayar.getOyuncuAdi()+ " kazandı!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            if(bilgisayar2.getSkor()==bilgisayar.getSkor()){
                JOptionPane.showMessageDialog(null,"Berabere bitti!", "tas kagit makas", JOptionPane.DEFAULT_OPTION);
            }
            hamleYap.setEnabled(false);
        }
    }
    public void secilenNesneler(){
    	if(oyuncu.getNesneListesi().size()==5){
            tas.setVisible(false);
            kagit.setVisible(false);
            makas.setVisible(false);
            for(int i = 0; i< oyuncu.getNesneListesi().size();i++){
                System.out.println("Kullanıcı: " + oyuncu.getNesneListesi().get(i).getClass().getSimpleName());
                String secim = oyuncu.getNesneListesi().get(i).getClass().getSimpleName();
                switch(i) {
                    case 0:
                      secilen1.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"B")));
                      break;
                    case 1:
                      secilen2.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"B")));
                      break;
                    case 2:
                      secilen3.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"B")));
                      break;
                    case 3:
                      secilen4.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"B")));
                      break;  
                    case 4:
                      secilen5.setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\"+nesneSecim(secim,"B")));
                      break;
                  }
                bilgisayar.nesneSec("");
                switch(bilgisayar.getSecim()) {
                    case "tas":
                        bilgisayar.getNesneListesi().add(new tas());
                        break;
                    case "kagit":
                        bilgisayar.getNesneListesi().add(new kagit());
                        break;  
                    case "makas":
                        bilgisayar.getNesneListesi().add(new makas());
                        break;  
                }
                System.out.println("Bilgisayar: " + bilgisayar.getNesneListesi().get(i).getClass().getSimpleName());
                oyuncu.setSkor(oyuncu.getSkor()+oyuncu.getNesneListesi().get(i).getDayaniklilik());
                bilgisayar.setSkor(bilgisayar.getSkor()+bilgisayar.getNesneListesi().get(i).getDayaniklilik());
            }
            secilenNesneler.setText("Seçilen Nesneler");
            skor.setText(oyuncu.getSkor()+" - "+bilgisayar.getSkor());
        }
    }
    public void bilNesneSec(){
        for(int i = 0; i< 5;i++){
            bilgisayar.nesneSec("");
            bilgisayar2.nesneSec("");
            switch(bilgisayar.getSecim()) {
                case "tas":
                    bilgisayar.getNesneListesi().add(new tas());
                    break;
                case "kagit":
                    bilgisayar.getNesneListesi().add(new kagit());
                    break;  
                case "makas":
                    bilgisayar.getNesneListesi().add(new makas());
                    break;  
            }
            switch(bilgisayar2.getSecim()) {
                case "tas":
                    bilgisayar2.getNesneListesi().add(new tas());
                    break;
                case "kagit":
                    bilgisayar2.getNesneListesi().add(new kagit());
                    break;  
                case "makas":
                    bilgisayar2.getNesneListesi().add(new makas());
                    break;  
            }
            System.out.println("Bilgisayar: " + bilgisayar.getNesneListesi().get(i).getClass().getSimpleName());
            bilgisayar2.setSkor(bilgisayar2.getSkor()+bilgisayar2.getNesneListesi().get(i).getDayaniklilik());
            bilgisayar.setSkor(bilgisayar.getSkor()+bilgisayar.getNesneListesi().get(i).getDayaniklilik());
        }
    }
    public void secimSifirla(){
        for(int i = 0; i< oyuncu.getNesneListesi().size();i++){
            String secim = oyuncu.getNesneListesi().get(i).getClass().getSimpleName();
            switch(i) {
                case 0:
                  secilen1.setEnabled(true);
                  break;
                case 1:
                  secilen2.setEnabled(true);
                  break;
                case 2:
                  secilen3.setEnabled(true);
                  break;
                case 3:
                  secilen4.setEnabled(true);
                  break;  
                case 4:
                  secilen5.setEnabled(true);
                  break;
              }
        }
    }
    public String nesneSecim(String secim, String gelisFlag) {
        String oyuncuSecim = "";
        if(secim.equals("tas")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="tas_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="agir_tas_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="tas_right.png";
            }else{
                oyuncuSecim="tas_left.png";
            }
        }else if(secim.equals("kagit")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="kagit_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="ozel_kagit_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="kagit_right.png";
            }else{
                oyuncuSecim="kagit_left.png";
            }
        }else if(secim.equals("makas")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="makas_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="usta_makas_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="makas_right.png";
            }else{
                oyuncuSecim="makas_left.png";
            }
        }else if(secim.equals("agirTas")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="tas_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="agir_tas_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="agir_tas_right.png";
            }else{
                oyuncuSecim="agir_tas_left.png";
            }
        }else if(secim.equals("ozelKagit")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="kagit_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="ozel_kagit_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="ozel_kagit_right.png";
            }else{
                oyuncuSecim="ozel_kagit_left.png";
            }
        }else if(secim.equals("ustaMakas")){
            if(gelisFlag.equals("B")){
                oyuncuSecim="makas_button.png";
            }else if(gelisFlag.equals("D")){
                oyuncuSecim="usta_makas_button.png";
            }else if(gelisFlag.equals("O")){
                oyuncuSecim="usta_makas_right.png";
            }else{
                oyuncuSecim="usta_makas_left.png";
            }
        }
        return oyuncuSecim;
    }
    public void setJframe() {
        this.win = new JFrame("Tas Kagit Makas");
        win.setSize(900,450);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);

        this.tas = new JButton(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\tas_button.png"));
        tas.setBounds(365, 250, 50, 50);
        tas.setBorderPainted(false);
        tas.setOpaque(false);
        tas.setContentAreaFilled(false);

        this.kagit = new JButton(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\kagit_button.png"));
        kagit.setBounds(425, 250, 50, 50);
        kagit.setBorderPainted(false);
        kagit.setOpaque(false);
        kagit.setContentAreaFilled(false);

        this.makas = new JButton(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\RockPaperScissor-main\\TasKagitMakas\\src\\main\\java\\com\\mycompany\\TasKagitMakas\\image\\makas_button.png"));
        makas.setBounds(485, 250, 50, 50);
        makas.setBorderPainted(false);
        makas.setOpaque(false);
        makas.setContentAreaFilled(false);

        this.secilen1 = new JButton(new ImageIcon(""));
        secilen1.setBounds(300, 350, 50, 50);
        secilen1.setBorderPainted(false);
        secilen1.setOpaque(false);
        secilen1.setContentAreaFilled(false);

        this.secilen2 = new JButton(new ImageIcon(""));
        secilen2.setBounds(360, 350, 50, 50);
        secilen2.setBorderPainted(false);
        secilen2.setOpaque(false);
        secilen2.setContentAreaFilled(false);

        this.secilen3 = new JButton(new ImageIcon(""));
        secilen3.setBounds(420, 350, 50, 50);
        secilen3.setBorderPainted(false);
        secilen3.setOpaque(false);
        secilen3.setContentAreaFilled(false);

        this.secilen4 = new JButton(new ImageIcon(""));
        secilen4.setBounds(480, 350, 50, 50);
        secilen4.setBorderPainted(false);
        secilen4.setOpaque(false);
        secilen4.setContentAreaFilled(false);

        this.secilen5 = new JButton(new ImageIcon(""));
        secilen5.setBounds(540, 350, 50, 50);
        secilen5.setBorderPainted(false);
        secilen5.setOpaque(false);
        secilen5.setContentAreaFilled(false);
        
        this.hamleSayisiButon = new JButton();
        hamleSayisiButon.setBounds(368, 20, 150, 50);
        hamleSayisiButon.setBackground(new Color(220, 220, 220));
        hamleSayisiButon.setForeground(Color.BLACK);
        hamleSayisiButon.setFocusPainted(false);
        hamleSayisiButon.setFont(new Font("Tahoma", Font.BOLD, 12));
        hamleSayisiButon.setText("Hamle Sayısı Giriniz");
        
        this.oynanisModu = new JButton();
        oynanisModu.setBounds(368, 20, 150, 50);
        oynanisModu.setBackground(new Color(220, 220, 220));
        oynanisModu.setForeground(Color.BLACK);
        oynanisModu.setFocusPainted(false);
        oynanisModu.setFont(new Font("Tahoma", Font.BOLD, 12));
        oynanisModu.setText("Oyun Modu Seç");
        
        this.hamleYap = new JButton();
        hamleYap.setBounds(368, 20, 150, 50);
        hamleYap.setBackground(new Color(220, 220, 220));
        hamleYap.setForeground(Color.BLACK);
        hamleYap.setFocusPainted(false);
        hamleYap.setFont(new Font("Tahoma", Font.BOLD, 12));
        hamleYap.setText("Hamle Yap");

        this.oyuncu1_img = new JLabel(new ImageIcon("C:\\\\Users\\\\Duayeng\\\\Desktop\\\\rockpaper\\\\tas_right.png"));
        oyuncu1_img.setBounds(25, 80, 230, 160);

        this.oyuncu2_img = new JLabel(new ImageIcon("C:\\\\Users\\\\Duayeng\\\\Desktop\\\\rockpaper\\\\tas_left.png"));
        oyuncu2_img.setBounds(640, 80, 230, 160);
        
        if(oynanisModuSec.equals("1")){
            this.oyuncu1 = new JLabel(oyuncu.getOyuncuAdi());
        }else{
            this.oyuncu1 = new JLabel(bilgisayar2.getOyuncuAdi());       
        }    
        oyuncu1.setBounds(25,40,160,50);
        oyuncu1.setFont(new Font("Arial",Font.BOLD,25));

        this.oyuncu2 = new JLabel(bilgisayar.getOyuncuAdi());
        oyuncu2.setBounds(640,40,160,50);
        oyuncu2.setFont(new Font("Arial",Font.BOLD,25));
        
        if(oynanisModuSec.equals("1")){
            this.skor = new JLabel(oyuncu.getSkor()+" - "+bilgisayar.getSkor());
        }else{
            this.skor = new JLabel(bilgisayar2.getSkor()+" - "+bilgisayar.getSkor());       
        }  
        skor.setBounds(300, 110, 300, 100);
        skor.setFont(new Font("Arial",Font.BOLD,50));
        skor.setHorizontalAlignment(JLabel.CENTER);

        this.secilenNesneler =  new JLabel();
        secilenNesneler.setBounds(350,300,300,50);
        secilenNesneler.setFont(new Font("Arial",Font.BOLD,25));

        win.add(tas);
        win.add(kagit);
        win.add(makas);
        win.add(oyuncu1_img);
        win.add(oyuncu2_img);
        win.add(oyuncu1);
        win.add(oyuncu2);
        win.add(skor);
        win.add(secilen1);
        win.add(secilen2);
        win.add(secilen3);
        win.add(secilen4);
        win.add(secilen5);
        win.add(secilenNesneler);
        win.add(hamleSayisiButon);
        win.add(oynanisModu);
        win.add(hamleYap);
        win.setVisible(true);
    } 
    public nesne getOzelNesne(String nesneAdi){
        nesne ozelNesne = new nesne();
        switch(nesneAdi) {
            case "tas":
                ozelNesne = new agirTas();
                break;
            case "kagit":
                ozelNesne = new ozelKagit();
                break;  
            case "makas":
                ozelNesne = new ustaMakas();
                break;  
        }
        return ozelNesne;
    } 
}