/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Valentin
 */
public class Oras {
    private String numeOras;

    public Oras(String numeOras) {
        this.numeOras = numeOras;
    }

    public String getNumeOras() {
        return numeOras;
    }

    public void setNumeOras(String numeOras) {
        this.numeOras = numeOras;
    }

    @Override
    public String toString() {
        return  numeOras;
    }
    
    
    
}
