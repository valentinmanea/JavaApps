/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 Pentru structura Tara ->judet -> oras am implementat relatii "has a".
Se mai pot aduce modificari in sensul aduagarii de sate, comune prin crearea a unor noi prototipuri
* si adaugarea lor succesiva ca si membrii in clasele deja create.
 */

public class Tara {
    private String numeTara;
    private Judet judet;
    
    public Tara(String numeTara) {
        this.numeTara = numeTara;
    }
    
}
