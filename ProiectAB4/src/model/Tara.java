/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 Pentru structura Tara ->judet -> oras am implementat relatii "has a".
Se mai pot aduce modificari in sensul aduagarii de sate, comune rin crearea a unor noi clase
* si adaugarea lor succesiva in clase ca si campuri.
 */

public class Tara {
    private String numeTara;
    private Judet judet;
    
    public Tara(String numeTara) {
        this.numeTara = numeTara;
    }

    public String getNumeTara() {
        return numeTara;
    }

    public void setNumeTara(String numeTara) {
        this.numeTara = numeTara;
    }

    public Judet getJudet() {
        return judet;
    }

    public void setJudet(Judet judet) {
        this.judet = judet;
    }
    
}
